package Lesson_3;
/*Написать простой класс ТелефонныйСправочник,который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add()можно добавлять записи.С помощью метода get()искать номер телефона по фамилии.
Следует учесть,что под одной фамилией может быть несколько телефонов(в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.*/

public class Task2 {
    public static void main(String[] args) {


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петров", "+124563");
        phoneBook.add("Петров", "+223456");
        phoneBook.add("Петров", "+43456");
        phoneBook.add("Петров", "+534456");
        phoneBook.add("Иванов", "+6897");
        phoneBook.add("Сидоров", "+779142564");
        phoneBook.add("Петров", "+8336 Добавочный 03");

        System.out.println("Список номеров Петрова: " + phoneBook.get("Петров"));


    }
}
