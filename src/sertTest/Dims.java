package sertTest;

import java.lang.reflect.Array;

public class Dims {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[] b = (int[]) a[1];
        Object o1 = a;
//        Array.get(o1, 1);
        int[][] a2 = (int[][]) o1;
        int[] b2 = (int[]) o1;
        System.out.println(b[1]);
    }
}