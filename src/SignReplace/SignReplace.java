package SignReplace;

public class SignReplace {
    private static Integer min = Integer.MAX_VALUE;
    private static String s = "";

    private static void rec(int i, int[] arr, Integer sum, String str) {
        if (i == arr.length) {
            Integer tmp = Math.abs(sum);
            if (tmp < min) {
                min = tmp;
                s = str;
            }
        } else {
            rec(i + 1, arr, sum + arr[i], str + " + " + arr[i]);
            rec(i + 1, arr, sum - arr[i], str + " - " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] ar = {9, 1, 4, 3, 5};
        rec(1, ar, ar[0], ar[0] + "");
        System.out.println(min);
        System.out.println(s);
    }
}
