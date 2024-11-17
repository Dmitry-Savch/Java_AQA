package task_4;

public class Task_4A {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Hello, world!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                    break;
                }
            }
        });

        thread.start();
    }
}

/*
a)Create a thread that outputs "Hello, world!" every second using Thread and sleep.
*/