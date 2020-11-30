package Lesson2Except;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int x, int y) {
        super("The variable format in the array cell ["+ x + "х" + y + "] is incorrect!");
    }
}
