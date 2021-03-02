package Lesson_5;

import java.util.Arrays;

public class DualMethod  {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];
    float[] arr1 = new float[h];
    float[] arr2 = new float[h];

    public void go() {

        Arrays.fill(arr, 1);

        long TimeStart = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread tr1 = new Thread1();
        Thread tr2 = new Thread2();
        tr1.start();
        tr2.start();

        try {
            tr1.join();
            tr2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("В 2 потока: " + (System.currentTimeMillis() - TimeStart) + " мс");
    }

    public class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    public class Thread2 extends Thread {
        @Override
        public void run() {
            int iCorrect;
            for (int i = 0; i < arr2.length; i++) {
                iCorrect = i + h; //индекс изначального массва
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + iCorrect / 5) * Math.cos(0.2f + iCorrect / 5) * Math.cos(0.4f + iCorrect / 2));
            }
        }
    }
}