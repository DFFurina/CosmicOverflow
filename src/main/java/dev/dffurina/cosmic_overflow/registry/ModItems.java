package dev.dffurina.cosmic_overflow.registry;

import dev.dffurina.cosmic_overflow.CosmicOverflowMod;
import dev.dffurina.cosmic_overflow.item.ParitySampleItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(CosmicOverflowMod.MODID);

    public static final DeferredItem<ParitySampleItem> PARITY_SAMPLE =
            ITEMS.registerItem(
                    "parity_sample",
                    properties -> new ParitySampleItem(0.427, 0.012, properties)
            );

    private ModItems() {
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
