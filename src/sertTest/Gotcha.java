package sertTest;

import java.io.IOException;

public class Gotcha {

    public static void main(String[] args) {
        new Gotcha().go();

//        try {
//            new Gotcha().go();
//        } catch (Error e) {
//            System.out.println("ouch");
//        }

//        try {
//            new Gotcha().go();
//        } catch (Exception e) {
//            System.out.println("ouch");
//        }
    }

    void go() {
        go();
    }
}

class Frisbie {
    public static void main(String[] args) throws IOException {
        int x = 0;
        System.out.println(7/x);
    }
}
