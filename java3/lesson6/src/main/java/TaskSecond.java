import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskSecond {
    public static boolean checkArray(Integer[] array){
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(array));
        return (set.size() == 2) && (set.contains(1)) &&(set.contains(4));
    }
}
