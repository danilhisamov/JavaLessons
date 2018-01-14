package Matrix;

/**
 * Created by Danil on 09.09.2017.
 */
public class Matrix {
    private int[][] a;
    private int rows;
    private int cols;
    private int count;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.a = new int[rows][cols];
        this.count = 0;
    }

    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public int getCount() {
        return count;
    }

    void print() {
        for (int i = 0; i < rows; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                s.append("\t").append(a[i][j]);
            }
            System.out.println(s);
        }
    }

    void fill() {
        fillRowOrCol(0, 0, 1, 0);
    }

    private void fillRowOrCol(int i, int j, int direct, int lastValue) {
        if (lastValue == rows * cols) {
            return;
        }
        a[i][j] = lastValue + 1;
        lastValue++;
        if (direct == 1) { //вправо
            if (j + 1 < cols && a[i][j + 1] == 0) {
                fillRowOrCol(i, j + 1, direct, lastValue);
            } else {
                fillRowOrCol(i + 1, j, directAdd(direct), lastValue);
            }
        } else if (direct == 2) { //вниз
            if (i + 1 < rows && a[i + 1][j] == 0) {
                fillRowOrCol(i + 1, j, direct, lastValue);
            } else {
                fillRowOrCol(i, j - 1, directAdd(direct), lastValue);
            }
        } else if (direct == 3) { //влево
            if (j - 1 >= 0 && a[i][j - 1] == 0) {
                fillRowOrCol(i, j - 1, direct, lastValue);
            } else {
                fillRowOrCol(i - 1, j, directAdd(direct), lastValue);
            }
        } else if (direct == 4) { //вверх
            if (i - 1 >= 0 && a[i - 1][j] == 0) {
                fillRowOrCol(i - 1, j, direct, lastValue);
            } else {
                fillRowOrCol(i, j + 1, directAdd(direct), lastValue);
            }
        }
    }

    private int directAdd(int prev) {
        if (prev == 4) {
            return 1;
        } else {
            return prev + 1;
        }
    }

    public void rec2(int i, int j, int[][] a, int k, int all) {
        if (intersects(i, j, a, a.length)) {
            return;
        } else {
            a[i][j] = 1;
            k++;
            if (k == all) {
                count++;
                return;
            }
            for (int y = j + 1; y < cols; y++) {
                int[][] b = copyTrueArray(a);
                rec2(i, y, b, k, all);
            }
            for (int x = i + 1; x < rows; x++) {
                for (int y = 0; y < cols; y++){
                    int[][] b = copyTrueArray(a);
                    rec2(x, y, b, k, all);
                }
            }
        }
    }

    private boolean intersects(int i, int j, int[][] a, int size) {
        for (int x = 0; x < size; x++) {
            if (a[x][j] == 1) {
                return true;
            }
        }

        for (int y = 0; y < size; y++) {
            if (a[i][y] == 1) {
                return true;
            }
        }

        return false;
    }

    private int[][] copyTrueArray(int[][] a) {
        int n = a.length;
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = a[i][j];
            }
        }
        return b;
    }
}
