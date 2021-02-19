package Lesson_1;

public class Droid implements JumpableRunnable {
    int maxHeight;
    int maxLength;
    String name;


    public Droid() {
        this.name = "R2D2";
        this.maxHeight = 4;
        this.maxLength = 400;
    }

    public Droid(String name, int maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    public void run() {
        System.out.println("Робот бежит!");

    }


    public void jump() {
        System.out.println("Робот прыгает!");

    }
    

    @Override
    public String toString() {
        return "Робот " + name + " (ТТХ: может пробежать = " + maxLength + " м. может прыгнуть на " + maxHeight + "м.) ";
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxLength() {
        return maxLength;
    }

}
