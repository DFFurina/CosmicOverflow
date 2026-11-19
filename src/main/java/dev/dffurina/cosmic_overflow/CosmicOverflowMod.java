package dev.dffurina.cosmic_overflow;

import dev.dffurina.cosmic_overflow.registry.ModCreativeTabs;
import dev.dffurina.cosmic_overflow.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(CosmicOverflowMod.MODID)
public final class CosmicOverflowMod {
    public static final String MODID = "cosmic_overflow";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public CosmicOverflowMod(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        LOGGER.info("Cosmic Overflow initialized");
    }
}
