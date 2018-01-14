package sertTest;

public class House extends Building {
    public House() {
        System.out.println("h ");
    }

    public House(String s) {
        this();
        System.out.println("hn " + s);
    }

    public static void main(String[] args) {
        new House("x");
    }
}

class Building {
    public Building() {
        System.out.println("b ");
    }

    public Building(String s) {
        this();

        System.out.println("bn" + s);
    }
}
