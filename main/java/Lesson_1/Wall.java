package Lesson_1;


public class Wall {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Стена выстой " + height + "м. ";
    }

    public Boolean tryJump(JumpableRunnable jumper) {
        return (jumper.getMaxHeight() >= this.height);


    }
}