package dev.dffurina.cosmic_overflow.registry;

import dev.dffurina.cosmic_overflow.CosmicOverflowMod;
import dev.dffurina.cosmic_overflow.measurement.ParityReading;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModDataComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(
                    Registries.DATA_COMPONENT_TYPE,
                    CosmicOverflowMod.MODID
            );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ParityReading>> PARITY_READING =
            DATA_COMPONENTS.registerComponentType(
                    "parity_reading",
                    builder -> builder.persistent(ParityReading.CODEC)
                            .networkSynchronized(ParityReading.STREAM_CODEC)
            );
    private  ModDataComponents() {

    }
    public static void register(IEventBus modEventBus) {
        DATA_COMPONENTS.register(modEventBus);
    }
}
