package ua.ithillel;

public class EqualsExample {

    public static class EqualsClass {
        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }

    public static class AlwaysEqualsClass {
        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }



}
