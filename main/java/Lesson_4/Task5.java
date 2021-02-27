package Lesson_4;

import Lesson_4.intarface.AverageInterface;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*Напишите метод, который возвращает среднее значение из списка целых чисел.
public Double average(List<Integer> list)*/
public class Task5 {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(1000));
        }

        AverageInterface totalAvg = n -> {
            int avg = 0;
            for (Integer num : n) {
                avg = avg + num;
            }
            return (double) (avg / (n.size()));
        };

        System.out.println(totalAvg.average(list));

    }
}
