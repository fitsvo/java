import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask1 {
    Integer[] start;
    Integer[] result;

    public TestTask1(Integer[] start, Integer[] result) {
        this.start = start;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1,2,3,4,5},new Integer[]{5}},
                {new Integer[]{1,2,3,4,5,6,7,4,9,0},new Integer[]{9, 0}},
                {new Integer[]{4, 0},new Integer[]{0}},
                {new Integer[]{1,1,1,11,4,1,7},new Integer[]{1,7}}
        });
    }


    @Test
    public void TestArray(){
        Assert.assertArrayEquals(result, TaskFirst.afterLastFour(start));
    }


    private Integer[] arrayWithout4;

    @Before
    public void testOnException (){
        arrayWithout4 = new Integer[]{1,2,3};
    }


    @Test (expected = RuntimeException.class)
    public void testArrException(){
        TaskFirst.afterLastFour(arrayWithout4);
    }

}
