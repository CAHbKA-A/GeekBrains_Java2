package Lesson_2;

public class MyArrayDataException extends Exception{
   private int i;
    private int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }


    public MyArrayDataException() {
    }

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;

    }
}
