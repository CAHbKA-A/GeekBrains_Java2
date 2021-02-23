package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static Map<String, ArrayList<String>> numberList = new HashMap<>();

    public ArrayList<String> get(String name) {
        return numberList.get(name);
    }

    public void add(String firstName, String phone) {
        ArrayList<String> arrayListTemp;
        arrayListTemp = numberList.get(firstName);
        if (arrayListTemp == null) {
            arrayListTemp = new ArrayList<>();
        }
        arrayListTemp.add(phone);
        numberList.put(firstName, arrayListTemp);
    }
}
