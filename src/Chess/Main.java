package Chess;

import Matrix.Matrix;

/**
 * Created by Danil on 09.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        Matrix matrix = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix.setA(new int[n][n]);
                matrix.rec2(i, j, matrix.getA(), 0, k);
            }
        }
        System.out.println(matrix.getCount());
    }
}
