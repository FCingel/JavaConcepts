package concepts;

//Implementing Runnable is preferable to extending Thread
public class RunnableExample implements Runnable{
    @Override
    public void run() {
        System.out.println("Running thread");
    }
}
