package sertTest;

public class Fishing {
    byte b1 = 4;
    int i1 = 123456;
    long L1 = (long) i1;
    short s2 = (short) i1;
    byte b2 = (byte) i1;
    int i2 = (int) 123.956;


    public static void main(String[] args) {
        System.out.println(new Fishing().i2);
    }
}

