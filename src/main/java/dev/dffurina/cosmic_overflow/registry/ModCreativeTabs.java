package dev.dffurina.cosmic_overflow.registry;

import dev.dffurina.cosmic_overflow.CosmicOverflowMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CosmicOverflowMod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COSMIC_OVERFLOW =
            CREATIVE_TABS.register("cosmic_overflow", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.cosmic_overflow"))
                    .icon(() -> new ItemStack(ModItems.PARITY_SAMPLE.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.PARITY_SAMPLE.get());
                        output.accept(ModBlocks.PARITY_BIASED_ORE_ITEM.get());
                    })
                    .build());

    private ModCreativeTabs() {
    }

    public static void register(IEventBus modEventBus) {
        CREATIVE_TABS.register(modEventBus);
    }
}
