package task_3;

public class ArrayUtils {

    public static void rotateArray(int[] array, int positions) {
        int length = array.length;
        positions = positions % length;
        reverseArray(array, 0, length - 1);
        reverseArray(array, 0, positions - 1);
        reverseArray(array, positions, length - 1);
    }

    public static void reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
