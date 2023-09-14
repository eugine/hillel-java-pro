package ua.ithillel.lombok;

public record RecordExample(String name, int age) {

    public RecordExample withName(String name) {
        return new RecordExample(name, age);
    }
}

