package Lesson2Except;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("The size of the entered array does not match the condition!");
    }
}
