package Lesson_4;
/*4 Напишите метод, который возвращает наибольшее целое число в списке.
public Integer maximum(Integer[] list)*/

import Lesson_4.intarface.MaxOfListInterface;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{3, 3, 5, 2, 1, 4, 555, 22, 244, 22, 34, 545, 22, 111, 333, 34};
      /*  Integer[] list = new Integer[1000000];
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            list[i] = random.nextInt(10000);
        }*/

        MaxOfListInterface max = n -> {
            int maxTmp = n[0];
            for (Integer num : n) {
                if (maxTmp < num) {
                    maxTmp = num;
                }
            }
            return maxTmp;
        };
        System.out.println(max.maximum(list));


/*
        max = n -> {
            Set<Integer> arList = new TreeSet<Integer>();
            arList.addAll(Arrays.asList(n));
            return arList.stream().max(Comparator.naturalOrder()).get();
        };
        System.out.println(max.maximum(list));

        max = n -> {
            Set<Integer> arList = new TreeSet<Integer>(Comparator.reverseOrder());
            arList.addAll(Arrays.asList(n));
            return arList.stream().findFirst().get();
        };
        System.out.println(max.maximum(list));

*/

    }
}
