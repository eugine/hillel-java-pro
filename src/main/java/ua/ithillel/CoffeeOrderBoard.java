package ua.ithillel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoffeeOrderBoard {

    private final List<Order> orders = new ArrayList<>();


    public class Order {
        private String name;
        private String order;

        public Order(String name, String order) {
            this.name = name;
            this.order = order;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "name='" + name + '\'' +
                    ", order='" + order + '\'' +
                    '}';
        }
    }

    public void add(String name, String order) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Name must not be null");
        }
        orders.add(new Order(name, order));
    }


    public void finishOrder(String name) {
        orders.remove(null);
    }

    public List<Order> getAll() {
        return new ArrayList<>(orders);
    }





}
