package Lesson_4;

import Lesson_4.intarface.SearchStringInterface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*6. Имея список строк, напишите метод, который возвращает список всех строк,
которые начинаются с буквы «а» (нижний регистр) и имеют ровно 3 буквы.
public List<String> search(List<String> list)
*/
public class Task6 {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>(Arrays.asList("reeg jlklgf", "мея", "анпп", "список kljl", "ара", "строк", "напишите", "ага", "метод", "который"));

        SearchStringInterface clear = n ->
        {
            String line;
            Iterator<String> iterator = n.listIterator();
            while (iterator.hasNext()) {
                line = iterator.next();
                if ((line.length() != 3) || (line.charAt(0) != 'а')) {
                    iterator.remove();
                }

            }
            return n;
        };

        System.out.println(clear.search(list));
    }
}
