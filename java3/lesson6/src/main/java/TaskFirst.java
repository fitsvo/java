import java.util.Arrays;
import java.util.List;

public class TaskFirst {
    public static Integer[] afterLastFour(Integer[] array) throws RuntimeException{
        List<Integer> list;
        list = Arrays.asList(array);
        if(!list.contains(4)){
            throw new RuntimeException("Введенный массив не содержит четверок!");
        }
        Integer[] result = new Integer[array.length - list.lastIndexOf(4) - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[list.lastIndexOf(4) + i + 1];
        }
        return result;
    }
}
