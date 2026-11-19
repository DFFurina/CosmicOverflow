package dev.dffurina.cosmic_overflow.measurement;

import java.util.Locale;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record ParityReading(double bias, double uncertainty) {
    public static final Codec<ParityReading> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    Codec.DOUBLE
                            .fieldOf("bias")
                            .forGetter(ParityReading::bias),
                    Codec.DOUBLE
                            .fieldOf("uncertainty")
                            .forGetter(ParityReading::uncertainty)
            ).apply(instance, ParityReading::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ParityReading> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.DOUBLE,
                    ParityReading::bias,
                    ByteBufCodecs.DOUBLE,
                    ParityReading::uncertainty,
                    ParityReading::new
            );

    public ParityReading {
        if (!Double.isFinite(bias)) {
            throw new IllegalArgumentException("Parity bias must be finite.");
        }
        if (!Double.isFinite(uncertainty) || uncertainty < 0.0) {
            throw new IllegalArgumentException("Measurement uncertainty must be finite and non-negative.");
        }
    }

    public String formattedBias() {
        return formatValue(bias);
    }

    public  String formattedUncertainty() {
        return formatValue(uncertainty);
    }

    public static String formatValue(double value) {
        return String.format(Locale.ROOT, "%.3f", value);
    }
}
