package task_4;

import java.lang.reflect.Constructor;

public class CustomClass {
    private String name;
    private int age;

    public CustomClass() {
        this.name = "Default";
        this.age = 0;
    }

    public CustomClass(String name) {
        this.name = name; this.age = 0;
    }

    public CustomClass(String name, int age) {
        this.name = name; this.age = age;
    }

    @Override
    public String toString() {
        return "CustomClass{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        try {
            Constructor<?>[] constructors = CustomClass.class.getDeclaredConstructors();
            System.out.println("Available Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.print(constructor.getName() + "(");
                Class<?>[] params = constructor.getParameterTypes();
                for (int i = 0; i < params.length; i++) {
                    System.out.print(params[i].getSimpleName() + (i < params.length - 1 ? ", " : ""));
                }
                System.out.println(")");
            }

            Constructor<?> chosenConstructor = CustomClass.class.getDeclaredConstructor(String.class, int.class);
            CustomClass instance = (CustomClass) chosenConstructor.newInstance("Alice", 30);
            System.out.println("Created instance: " + instance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
b)Create your own custom class with a few constructors, and make an object for it.
Use getDeclaredConstructors() to print out all the constructors of the class and their
parameter types. Choose a specific constructor and create a new instance of the class using newInstance().
Print out your results or processing progress.
*/