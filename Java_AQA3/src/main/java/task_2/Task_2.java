package task_2;

public class Task_2 {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        int andResult = a & b;
        System.out.println("a & b = " + andResult);

        int orResult = a | b;
        System.out.println("a | b = " + orResult);

        int xorResult = a ^ b;
        System.out.println("a ^ b = " + xorResult);

        int notResult = ~a;
        System.out.println("~a = " + notResult);

        int leftShiftResult = a << 2;
        System.out.println("a << 2 = " + leftShiftResult);

        int rightShiftResult = a >> 1;
        System.out.println("a >> 1 = " + rightShiftResult);
    }
}

/*
V 15: Bitwise Operators
Objective: To understand and use bitwise operators in Java with primitive types.
Instructions:
Declare and initialize two int variables.
Use bitwise operators (e.g., &, |, ^, ~, <<, >>) to perform operations on the variables.
Print the result of each operation to the console.
*/