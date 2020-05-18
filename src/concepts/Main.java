package concepts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner input = new Scanner(System.in);
        String concept = new String();

        while(!concept.equals("Quit")) {
            System.out.print("\nEnter the name of the concept you would like to run or type quit:");
            concept = input.next();
            //Capitalize first character in case user hasn't
            concept = concept.substring(0, 1).toUpperCase() + concept.substring(1);

            try {
                if (!concept.equals("Quit")) {
                    //Use reflection to run method by name
                    Method method = Main.class.getMethod("run" + concept);
                    method.invoke(new Main());
                }
            } catch(NoSuchMethodException e) {
                System.out.println("There is no concept called " + concept);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void runGeneric() {
        //Generic class
        Generic<Integer> genericInt = new Generic<>(42);
        Generic<String> genericStr = new Generic<>("Hello");

        genericInt.display();
        genericStr.display();

        //Generic method
        Generic.displayGeneric(20);
        Generic.displayGeneric("Frank");
    }

    public static void runWildcard() {

    }

    public static void runThread() throws InterruptedException {
        ThreadExample threadExample = new ThreadExample();
        System.out.println("Thread start");
        threadExample.start();

        System.out.println("isAlive method while thread is running: " + threadExample.isAlive());

        System.out.println("State: " + threadExample.getState());
        System.out.println("Name: " + threadExample.getName());
        System.out.println("Priority: " + threadExample.getPriority());

        //join() method waits for the thread to die
        threadExample.join();
        System.out.println("isAlive method after thread is finished: " + threadExample.isAlive());

        Thread.sleep(2000);
        System.out.println("Thread end");

    }

    public static void runRunnable() throws InterruptedException {
        RunnableExample runnableExample = new RunnableExample();
        Thread threadObject = new Thread(runnableExample);
        System.out.println("Thread start");
        threadObject.start();

        System.out.println("isAlive method while thread is running: " + threadObject.isAlive());

        System.out.println("State: " + threadObject.getState());
        System.out.println("Name: " + threadObject.getName());
        System.out.println("Priority: " + threadObject.getPriority());

        //join() method waits for the thread to die
        threadObject.join();
        System.out.println("isAlive method after thread is finished: " + threadObject.isAlive());

        Thread.sleep(2000);
        System.out.println("Thread end");
    }

    public static void runCallable() {
        ExecutorService exService = Executors.newSingleThreadExecutor();
        CallableExample uploadCallable = new CallableExample("Batch 1");
        Future<Boolean> future = exService.submit(uploadCallable);
        try {
            System.out.println("Upload completed: " + future.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        exService.shutdown();
    }

    public static void runLambda() {
        LambdaExample le = (num1, num2) -> num1 + num2;
        System.out.println(le.add(5, 7));
    }
}