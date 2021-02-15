package Lesson_1;


public class RuningTrack {
    int length;
    private int height;

    public RuningTrack(int length) {

        this.length = length;
    }

    @Override
    public String toString() {
        return "Дорожка длиной " + length + "м. ";
    }

    public Boolean tryRun(JumpableRunnable runner) {
        return (runner.getMaxLength() >= this.length);
    }
}

