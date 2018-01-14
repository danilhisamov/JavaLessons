package sertTest;

public class Ouch {
    static int ouch = 4;

    void go(int ouch) {
        ouch++;
//        for (int ouch = 3; ouch < 6; ouch++) ; comp error
        System.out.println(" " + ouch);
    }

    public static void main(String[] args) {
        new Ouch().go(ouch);
        System.out.println(" " + ouch);
    }
}
