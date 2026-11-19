package dev.dffurina.cosmic_overflow.item;

import java.util.ConcurrentModificationException;
import java.util.Locale;

import dev.dffurina.cosmic_overflow.measurement.ParityReading;
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

    private final double baseBias;
    private final double baseUncertainty;

    public ParitySampleItem(double baseBias, double baseUncertainty, Item.Properties properties) {
        super(properties);
        this.baseBias = baseBias;
        this.baseUncertainty = baseUncertainty;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(
            Level level,
            Player player,
            InteractionHand hand
    ) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            ParityReading reading = measure();
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

    private  ParityReading measure() {
        return new ParityReading(baseBias, baseUncertainty);
    }
}
