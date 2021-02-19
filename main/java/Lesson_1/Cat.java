package Lesson_1;

public class Cat implements JumpableRunnable {
    int maxHeight;
    int maxLength;
    String name;
    boolean winner = false;


    public Cat() {
        this.name = "Безымянный";
        this.maxHeight = 2;
        this.maxLength = 50;
    }

    public Cat(String name, int maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    public void run() {
        System.out.println("Кот бежит!");

    }

    public void jump() {
        System.out.println("Кот прыгает!");

    }

    @Override
    public String toString() {
        return "Кот " + " (ТТХ: может пробежать = " + maxLength + " м. может прыгнуть на " + maxHeight + "м.) ";
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxLength() {
        return maxLength;
    }
}
