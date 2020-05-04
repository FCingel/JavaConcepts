package concepts;

public class Generic<T>{
    private T obj;

    public Generic(T obj) {
        this.obj = obj;
    }

    public void display() {
        System.out.println(this.obj);
    }

    //Generic method example
    public <E> void displayGeneric(E element) {
        System.out.println(element);
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
