package h06;

import h06.problems.Fractals;
import h06.ui.DrawInstruction;
import h06.ui.FractalVisualizer;
/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        // Generiert die Anweisungen zum Zeichnen einer Drachenkurve
        DrawInstruction[] dragonCurveInstructions = Fractals.dragonCurve(5);
        // Erstellt einer FractalVisualizer Instanz, um die Drachenkurve mit einem Winkel von 90 Grad zu visualisieren
        FractalVisualizer dragonCurveVisualizer = new FractalVisualizer(dragonCurveInstructions, 90);
        // Macht den Drachenkurven-Visualizer sichtbar
        dragonCurveVisualizer.setVisible(true);

        // Generiert die Anweisungen zum Zeichnen eine Kochschneeflocke
        DrawInstruction[] kochSnowflakeInstructions = Fractals.kochSnowflake(3);
        // Erstellt einer FractalVisualizer Instanz, um die Kochschneeflocke mit einem Winkel von 60 Grad zu visualisieren
        FractalVisualizer kochSnowflakeVisualizer = new FractalVisualizer(kochSnowflakeInstructions, 60);
        // Macht den Kochschneeflocken-Visualizer sichtbar
        kochSnowflakeVisualizer.setVisible(true);
    }
}
