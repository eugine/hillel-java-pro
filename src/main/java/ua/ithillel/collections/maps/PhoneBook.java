package ua.ithillel.collections.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    /*

8. * У класі Телефонний Довідник реалізувати метод findAll(). Метод здійснює пошук записів на ім'я. Якщо записи знайдені, тоді їх необхідно повернути, інакше повертається null.
Така реалізація викликана тим, що під одним прізвищем може зберігатися кілька телефонів і при запиті по конкретному імені необхідно повертати всі записи, що є в наявності.
     */

    private final Map<String, List<String>> records = new HashMap<>();

    public void add(String name, String phoneNumber) {
        if (records.containsKey(name)) {
            records.get(name).add(phoneNumber);
        } else {
            var phoneNumbers = new ArrayList<String>();
            phoneNumbers.add(phoneNumber);
            records.put(name, phoneNumbers);
        }
    }

    public String find(String name) {
        if (records.containsKey(name)) {
            return records.get(name).get(0);
        }
        return null;
    }

    public List<String> findAll(String name) {
        return records.getOrDefault(name, List.of());
    }

    public static void main(String[] args) {
        var phoneBook = new PhoneBook();

        phoneBook.add("Evgeniy", "123");
        phoneBook.add("Evgeniy", "456");

        System.out.println(phoneBook.records);

        System.out.println(phoneBook.find("Evgeniy"));
        System.out.println(phoneBook.findAll("Evgeniy"));

        System.out.println(phoneBook.findAll("Unknown"));



    }

}
