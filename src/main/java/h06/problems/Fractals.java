package h06.problems;

import h06.ui.DrawInstruction;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * A class to generate draw instructions in order to draw a dragon curve.
 *
 * @author Manuel Peters
 */
public class Fractals {

    /**
     * Default Constructor for this class.
     */
    @DoNotTouch
    public Fractals() {}

    /**
     * This method calculates a raised to the power of b using recursion.
     * a and b are expected to be non-negative integers.
     *
     * @param a the base, must be non-negative
     * @param b the exponent, must be non-negative
     * @return the result of a raised to the power of b
     */
    @StudentImplementationRequired
    public static int pow(int a, int b) {
        if (b == 0){
            return 1;
        } else {
            return a * pow(a, b-1);
        }
        // TODO: H3.1 - remove if implemented
    }



    /**
     * This method combines two arrays of DrawInstruction objects into a single array.
     * The elements of the first array are followed by the elements of the second array in the new array.
     *
     * @param arr1 the first array of type DrawInstruction
     * @param arr2 the second array of type DrawInstruction
     * @return A new array containing all elements of arr1 followed by all elements of arr2
     */
    @StudentImplementationRequired
    public static DrawInstruction[] concatenate(DrawInstruction[] arr1, DrawInstruction[] arr2) {
        DrawInstruction[] result = new DrawInstruction[arr1.length + arr2.length];
        int index = 0;

        for (int i = 0; i < arr1.length; i++){
            result[index] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++){
            result[index] = arr2[i];
        }

        return result;
        // TODO: H3.2 - remove if implemented
    }

    /**
     * This method creates a new array that is a copy of the input array arr, but with the element at the specified
     * index idx replaced by elem.
     *
     * @param arr the original array of type DrawInstruction
     * @param idx the index at which to replace the element
     * @param elem the new DrawInstruction to place at the specified index
     * @return A new array with the element at idx replaced by elem
     */
    @StudentImplementationRequired
    public static DrawInstruction[] replaceAtIndex(DrawInstruction[] arr, int idx, DrawInstruction elem) {
        DrawInstruction[] result = new DrawInstruction[arr.length];
        for (int i = 0; i < arr.length; i++){
            if (i == idx){
                result[i] = elem;
            } else {
                result[i] = arr[i];
            }
        }
        return result;
        // TODO: H3.3 - remove if implemented
    }

    /**
     * Generates an array of DrawInstruction objects to draw a dragon curve of order n
     *
     * @param n The order of the dragon curve to generate
     * @return an array of DrawInstruction objects to draw a dragon curve of order n
     */
    @StudentImplementationRequired
    public static DrawInstruction[] dragonCurve(int n) {
        if (n <= 0){
            return new DrawInstruction[]{DrawInstruction.DRAW_LINE};
        } else if (n == 1) {
            return new DrawInstruction[]{
                DrawInstruction.DRAW_LINE,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.DRAW_LINE
            };
        } else {
            DrawInstruction[] previous = dragonCurve(n - 1);
            DrawInstruction[] reversed = replaceAtIndex(
                dragonCurve(n - 1), (int) Math.pow(2, n - 1) - 1, DrawInstruction.TURN_LEFT
            );
            return concatenate(concatenate(previous, new DrawInstruction[]{DrawInstruction.TURN_RIGHT}), reversed);
        }
        // TODO: H3.4 - remove if implemented
    }

    /**
     * Generates an array of DrawInstruction objects to draw a koch snowflake of order n
     *
     * @param n The order of the koch snowflake to generate
     * @return an array of DrawInstruction objects to draw a koch snowflake of order n
     */
    @StudentImplementationRequired
    public static DrawInstruction[] kochSnowflake(int n) {
        if (n <= 0){
            return new DrawInstruction[]{
                DrawInstruction.DRAW_LINE,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.DRAW_LINE,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.DRAW_LINE
            };
        } else {
            DrawInstruction[] prev = kochSnowflake(n - 1);
            int ct = 0;
            for (DrawInstruction instruction : prev){
                if (instruction == DrawInstruction.DRAW_LINE){
                    ct++;
                }
            }
            DrawInstruction[] result = new DrawInstruction[prev.length + ct * 7];
            int index = 0;
            for (DrawInstruction instruction : prev){
                if(instruction == DrawInstruction.DRAW_LINE){
                    result[index++] = DrawInstruction.DRAW_LINE;
                    result[index++] = DrawInstruction.TURN_LEFT;
                    result[index++] = DrawInstruction.DRAW_LINE;
                    result[index++] = DrawInstruction.TURN_RIGHT;
                    result[index++] = DrawInstruction.TURN_RIGHT;
                    result[index++] = DrawInstruction.DRAW_LINE;
                    result[index++] = DrawInstruction.TURN_LEFT;
                    result[index++] = DrawInstruction.DRAW_LINE;
                } else {
                    result[index++] = instruction;
                }
            }
            return result;
        }
        // TODO: H3.5 - remove if implemented
    }
}
