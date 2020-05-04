package concepts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner input = new Scanner(System.in);
        String concept = new String();

        while(!concept.equals("Quit")) {
            System.out.print("Enter the name of the concept you would like to run or type quit:");
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
        Generic<Integer> genericInt = new Generic<>(42);
        Generic<String> genericStr = new Generic<>("Hello");

        genericInt.display();
        genericStr.display();
    }

}