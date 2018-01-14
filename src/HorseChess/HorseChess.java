package HorseChess;

public class HorseChess {
    private final static int[] X_MOVE = {-1, 1, 2, 2, 1, -1, -2, -2};
    private final static int[] Y_MOVE = {-2, -2, -1, 1, 2, 2, 1, -1};

    private static int allCount = 0;

    private final int size;
    private int[][] arr;

    public HorseChess(int size) {
        this.size = size;
        this.arr = new int[size][size];
    }

    private void printArray(int[][] ar) {
        System.out.println("------NEW PRINT-----");
        for (int i = 0; i < size; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < size; j++) {
                s.append("\t").append(ar[i][j]);
            }
            System.out.println(s);
        }
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

    public void rec(int i, int j, int[][] array, int count) {
        array[i][j] = 1;
        if (count == size * size - 1) {
            allCount++;
        }
        for (int direction = 0; direction < X_MOVE.length; direction++) {
            if ((i + X_MOVE[direction] < size) && (i + X_MOVE[direction] >= 0) &&
                    (j + Y_MOVE[direction] < size) && (j + Y_MOVE[direction] >= 0) &&
                    array[i + X_MOVE[direction]][j + Y_MOVE[direction]] == 0) {
                rec(i + X_MOVE[direction], j + Y_MOVE[direction], copyTrueArray(array), count + 1);
            }
        }
    }

    public static void main(String[] args) {
        int size = 5;
        HorseChess horseChess = new HorseChess(size);
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
                horseChess.arr = new int[size][size];
                horseChess.rec(2,2, horseChess.arr, 0);
//            }
//        }
        System.out.println(allCount);
    }
}