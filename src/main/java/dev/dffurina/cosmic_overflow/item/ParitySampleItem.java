package dev.dffurina.cosmic_overflow.item;

import java.util.Locale;

import dev.dffurina.cosmic_overflow.measurement.ParityReading;
import dev.dffurina.cosmic_overflow.registry.ModDataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public final class ParitySampleItem extends Item {
    private static final int MEASUREMENT_COOLDOWN_TICKS = 20;

    public static final ParityReading DEFAULT_READING =
            new ParityReading(0.114, 0.007);

    public ParitySampleItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(
            Level level,
            Player player,
            InteractionHand hand
    ) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            ParityReading reading = measure(stack);
            player.getCooldowns().addCooldown(
                    this,
                    MEASUREMENT_COOLDOWN_TICKS
            );
            player.sendSystemMessage(
                    Component.translatable(
                            "message.cosmic_overflow.parity_sample.measured",
                            reading.formattedBias(),
                            reading.formattedUncertainty()
                    ).withStyle(ChatFormatting.AQUA)
            );
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }

    private ParityReading measure(ItemStack stack) {
        return stack.getOrDefault(
                ModDataComponents.PARITY_READING,
                DEFAULT_READING
        );
    }
}
