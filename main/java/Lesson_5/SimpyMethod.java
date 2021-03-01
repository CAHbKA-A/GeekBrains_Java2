package Lesson_5;

import java.util.Arrays;

public class SimpyMethod implements Runnable {
    static final int size = 10000000;
    float[] arr = new float[size];

    @Override
    public void run() {
        Arrays.fill(arr, 1);
        long TimeStart = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("В 1 поток: " + (System.currentTimeMillis() - TimeStart) + " мс");
    }

}
