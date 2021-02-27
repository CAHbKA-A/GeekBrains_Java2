package Lesson_4;

/*2. Напишите метод, который возвращает индекс первого вхождения данного целого числа в списке.
        Предположим, что индекс первого элемента в списке равен нулю.
        Если числа не существует в списке, верните -1.
public int search(Integer n, Integer[] list)*/

import Lesson_4.intarface.SearchInterface;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{3, 3, 5, 2, 1, 4, 555, 22, 244, 22, 34, 545, 22, 111, 333, 34};

        SearchInterface find = (n, Alist) -> {
            List<Integer> newList = Arrays.asList(Alist);
            return newList.indexOf(n);
        };


        System.out.println(find.search(5, list));
        System.out.println(find.search(0, list));
        System.out.println(find.search(555, list));
        System.out.println(find.search(6,new Integer[]{2,45,6,6,7}));


    }


}

