package ua.ithillel;

import java.util.Map;
import java.util.Set;

public class CoffeeOrderBoard {

    //private final Map
    //private final Set

    /*
6. Реалізувати метод draw у класі CoffeeOrderBoard.
Цей метод виводить у консоль інформацію про поточний стан черги

у порядку найближчого до видачі замовлення.

Наприклад:
=============
Num | Name
4 | Alen
27 | Yoda
33 | Obi-van
34 | John Snow
     */

//    public Map<Integer, String> draw() {
    public Set<CoffeeOrder> draw() {

        return null;
    }

    public record CoffeeOrder(Integer num, String name) {

    }

    public void print() {
        System.out.println("=============");
        System.out.println("Num | Name");
        for(var item: draw()) {
            System.out.println(item.num() + " | " + item.name());
        }

    }

}
