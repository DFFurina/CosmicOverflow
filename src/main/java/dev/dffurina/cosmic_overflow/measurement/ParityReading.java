package dev.dffurina.cosmic_overflow.measurement;

import java.util.Locale;

public record ParityReading(double bias, double uncertainty) {
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
