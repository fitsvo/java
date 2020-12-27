import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToList<T> {
    private final T[] arr;

    public ArrayToList(T[] arr) {
        this.arr = arr;
    }

    public ArrayList<T> getList(){
        return new ArrayList<T>(Arrays.asList(this.arr));
    }
}
