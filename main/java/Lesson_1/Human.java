package Lesson_1;

public class Human implements   RunnableJumpable {
    int maxHeight;
    int maxLength;
    String name;


    public Human() {
        this.name = "Мужик";
        this.maxHeight = 2;
        this.maxLength = 200;
    }

    public Human(String name, int maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    public void run() {
        System.out.println("Он бежит!");

    }


    public void jump() {
        System.out.println("Он прыгает!");

    }

    @Override
    public String toString() {
        return name + " (ТТХ: может пробежать = " + maxLength + " м. может прыгнуть на " + maxHeight + "м.) ";
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxLength() {
        return maxLength;
    }
}
