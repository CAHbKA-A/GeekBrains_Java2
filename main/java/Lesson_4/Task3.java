package Lesson_4;

/*Напишите метод, переворачивающий строку.
        Например, «java interview» превращается в «weivretni avaj».
public String reverse(String s)*/

import Lesson_4.intarface.RevertWordInterface;

public class Task3 {
    public static void main(String[] args) {

 String string = "java interview";

        RevertWordInterface revert = s ->  new StringBuilder(s).reverse().toString();


        System.out.println(revert.reverse(string));
        System.out.println(revert.reverse("абра кадабра"));

    }
}
