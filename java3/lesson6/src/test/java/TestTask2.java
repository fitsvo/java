import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask2 {
    Integer[] start;
    boolean result;

    public TestTask2(Integer[] start, boolean result) {
        this.start = start;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1,2,3,4,5},false},
                {new Integer[]{1,1,1,1,1,1,1,1,1,4},true},
                {new Integer[]{4, 1}, true},
                {new Integer[]{4, 1, 1}, true},
                {new Integer[]{4, 4}, false},
                {new Integer[]{1,1,1,1,1,1,1,7},false}
        });
    }

    @Test
    public void TestArray(){
        TaskSecond.checkArray(start);
    }
}
