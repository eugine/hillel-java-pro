package ua.ithillel.strings;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class StringExample {

    public static void main(String[] args) {
        // creation a string
        var name = "Hillel";
        var fullName = "Hillel School";

        var multilineString =
                "This is a text block\n" +
                        "Containing multiple lines";

        var textBlock =
                """
                        This is a text block
                        Containing multiple lines
                """;

        //methods
        var v1 = name.length();
        var v2 = name.toLowerCase(Locale.ROOT);
        var v3 = name.toUpperCase(Locale.ROOT);
        var v4 = name.equalsIgnoreCase(fullName);
        var v5 = name.getBytes(StandardCharsets.UTF_8);

        var v6 = name.charAt(0);

        var v7 = name.contains("lel");
        var v8 = name.indexOf("lel");
        var v9 = name.startsWith("Hil");

        var v10 = name.matches(".*"); //regex - regular expressions

        String[] v11 = "String1,String2,String3".split(",");

//        Arrays.stream("String1,String2,String3".split(",")).count()

        var v12 = name.substring(3);

        // concatenation
        var concatenation1 = name.concat("test"); // Hilleltest
        var concatenation2 = name + "test";
        var concatenation3 = name + new StringPersonRecord(1, "name", "year", "address"); //HillelPersonRecord[1,name,year

        System.out.println(String.format("Hello %s, test", name));
        //string pool
        // -> new StringPool();

        // Immutable & mutable String
        StringBuilder builder = new StringBuilder()
                .append(name)
                .append(" ")
                .append("something else");


    }
}
