package test;

class A {
    int x = 10;
    static int y = 20;

    public static int m() {
        return 10;
    }
}

class B extends A {
    int x = 30;
    static int y = 40;

    public static int m() {
        return 20;
    }
}

public class C {
    public static void main(String[] args) {
        System.out.println(new A().x + " " + new B().y + " " + ((A) new B()).x);
        B b = new B();
        System.out.println("");
    }
}
