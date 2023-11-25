package sems.sem_6;

import java.lang.reflect.Type;
import java.util.*;

class PhoneBook {
    private HashMap<String, ArrayList<String>> phonebook = new HashMap<>();

    public void add(String name, String phone_num) {
        if (phonebook.containsKey(name))
            phonebook.get(name).add(phone_num);
        else
            phonebook.put(name, new ArrayList<String>(List.of(phone_num)));
    }

    public void print() {
        Set<Map.Entry<String, ArrayList<String>>> entrySet = phonebook.entrySet();
        System.out.println(entrySet.stream().sorted(Comparator.comparingInt(entry -> 1 / entry.getValue().size())).toList());
    }
}

public class Printer {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Egor", "123223423");
        phoneBook.add("Egor", "14343");
        phoneBook.add("Egor", "14343");
        phoneBook.add("Anton", "32321");

        phoneBook.print();
    }
}
