public class ChangeElements<T> {
    private final T[] arr;

    public ChangeElements(T[] arr) {
        this.arr = arr;
    }

    public T[] change(int pos1, int pos2){
        T value;
        value = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = value;
        return arr;
    }
}
