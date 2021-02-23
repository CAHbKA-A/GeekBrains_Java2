package Lesson_3;

import java.util.Map;
import java.util.TreeMap;

//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив
//        (дубликаты не считаем).
//        Посчитать сколько раз встречается каждое слово.
public class Task1 {
    public static void main(String[] args) {

        String[] arr = new String[]{"Создать", "массив", "с", "набором", "слов", "слов", "с", "встречаться",
                "с", "с", "набором", "слов", "слов", "должны", "встречаться", "повторяющиеся"};

        int count;
        Map<String, Integer> words = new TreeMap<>(); //for sorting

        for (int i = 0; i < arr.length; i++) {
            count = words.getOrDefault(arr[i], 0);
            if (count == 0) {
                words.put(arr[i].toLowerCase(), 1);
            } else {
                count++;
                words.put(arr[i], count);
            }
        }
        // не информативный вывод
        System.out.println(words);
        System.out.println();
        //информативный вывод
        System.out.println("Всего " + words.size() + " уникальных слов:");
        for (Map.Entry<String, Integer> setW : words.entrySet()) {
            System.out.println("Слово \"" + setW.getKey() + "\" встречается " + setW.getValue() + " раз(а).");

        }
    }
}
