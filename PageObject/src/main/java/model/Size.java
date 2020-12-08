package model;

public enum  Size {

    RU35("35"),
    RU36("36"),
    RU37("37"),
    RU38("38"),
    RU39("39"),
    RU40("40"),
    RU41("41"),
    RU42("42"),
    RU43("43"),
    RU44("44");

    private final String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}


