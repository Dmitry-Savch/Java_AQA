package task_4;

import java.util.Arrays;

public class Task_4C {
    public static <T> void printArray(T[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Hello", "World", "!"};

        System.out.println("Integer array:");
        printArray(intArray);

        System.out.println("String array:");
        printArray(strArray);
    }
}

/*
V15.
c)	Create a generic method that takes an array of elements of any type, and prints them out using T[] and forEach().
*/