package dev.dffurina.cosmic_overflow.registry;

import dev.dffurina.cosmic_overflow.CosmicOverflowMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(CosmicOverflowMod.MODID);

    public static final DeferredItem<Item> PARITY_SAMPLE =
            ITEMS.registerSimpleItem("parity_sample");

    private ModItems() {
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
