package dev.dffurina.cosmic_overflow.registry;

import dev.dffurina.cosmic_overflow.CosmicOverflowMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CosmicOverflowMod.MODID);

    public static final DeferredBlock<Block> PARITY_BIASED_ORE =
            BLOCKS.registerSimpleBlock(
                    "parity_biased_ore",
                    BlockBehaviour.Properties.of().strength(3.0F, 6.0F)
            );

    public static final DeferredItem<BlockItem> PARITY_BIASED_ORE_ITEM =
            ModItems.ITEMS.registerSimpleBlockItem(PARITY_BIASED_ORE);

    private ModBlocks() {
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}