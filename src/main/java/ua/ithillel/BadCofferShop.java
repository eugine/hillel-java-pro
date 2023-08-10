package ua.ithillel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BadCofferShop {

    public static void main(String[] args) {
        var board = new CoffeeOrderBoard();
        board.add("Evgeniy", "Latte");

        System.out.println("before: " + board.getAll());
        bad(board);
        System.out.println("after: " + board.getAll());

        var map = new HashMap<String, List<String>>();
        map.put("path", new ArrayList<>());

        List<String> value = map.remove("path");

    }

    public static void bad(CoffeeOrderBoard board) {
        List<CoffeeOrderBoard.Order> all = board.getAll();
        var firstOrder = all.get(0);
        firstOrder.setOrder("Not Latte");
//
//        all.clear();

    }
}
