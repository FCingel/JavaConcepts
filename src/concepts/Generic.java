package concepts;

public class Generic<T>{
    private T obj;

    public Generic(T obj) {
        this.obj = obj;
    }

    public void display() {
        System.out.println(this.obj);
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
