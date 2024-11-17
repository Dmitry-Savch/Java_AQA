package task_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введіть розмір масиву: ");
            int size = Integer.parseInt(scanner.nextLine());

            int[] array = new int[size];
            System.out.println("Введіть елементи масиву:");
            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Введіть кількість позицій для ротації: ");
            int positions = Integer.parseInt(scanner.nextLine());

            ArrayUtils.rotateArray(array, positions);

            System.out.println("Повернутий масив:");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int num : array) {
                arrayList.add(num);
            }

            arrayList.add(999);
            System.out.println("Після додавання елемента до кінця: " + arrayList);

            arrayList.remove(0);
            System.out.println("Після видалення елемента зі списку: " + arrayList);

            arrayList.set(1, 555);
            System.out.println("Після заміни елемента: " + arrayList);

            Collections.sort(arrayList);
            System.out.println("Після сортування: " + arrayList);

            System.out.println("Елементи списку: " + arrayList);

            System.out.print("Введіть некоректне число для NumberFormatException: ");
            int invalidNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Введено некоректне число! Це NumberFormatException.");
        } finally {
            scanner.close();
        }
    }
}


/*
V15.
Array Rotation: Write a Java program that takes an array of integers and rotates it by a given number of positions.
Your program should prompt the user to enter the array size and the elements of the array, and then the number of
positions to rotate the array. Finally, your program should output the rotated array.
Make ArrayList from the result array and perform the following operations: a) Add an element to the end of the list;
b) Remove an element from the list; c) Replace an element in the list; d) Sort the list in alphabetical order;
e) Print the elements of the list;
Make up the situation for NumberFormatException. Catch it and display the explanation for your custom case.
*/