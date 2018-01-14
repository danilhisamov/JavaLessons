package MultiThreadSort;

import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int j = 32;
        ExecutorService threadPool = Executors.newFixedThreadPool(j);

        int[] a = new int[j];
        for (int i = 0; i < a.length; i++) {
            a[i] = j;
            j--;
        }

        divideArray(a, 0, a.length, threadPool, new ArrayList<>());

        System.out.println(Arrays.toString(a));

        threadPool.shutdown();
    }

    private static String divideArray(int[] array, int start, int end, ExecutorService threadPool, List<Future<String>> futures) {
        if (end - start == 2) {
            if (array[start] > array[end - 1]) {
                int c = array[start];
                array[start] = array[end - 1];
                array[end - 1] = c;
            }
        } else {
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> divideArray(array, start, (start + end) / 2, threadPool, new ArrayList<>()),
                            threadPool)
            );
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> divideArray(array, (start + end) / 2, end, threadPool, new ArrayList<>()),
                            threadPool)
            );
//            divideArray(array, start, (start + end) / 2);
//            divideArray(array, (start + end) / 2, end);

            for (Future<String > future : futures) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            int i1 = start;
            int i2 = (start + end) / 2;

            int[] b = new int[end - start];

            for (int i = 0; i < b.length; i++) {
                if (i1 != (start + end) / 2 && (i2 == end || array[i1] < array[i2])) {
                    b[i] = array[i1];
                    i1++;
                } else if (i2 != end && (i1 == (start + end) / 2 || array[i1] > array[i2])) {
                    b[i] = array[i2];
                    i2++;
                }
            }

            int bi = 0;
            for (int i = start; i < end; i++) {
                array[i] = b[bi];
                bi++;
            }
        }

        return null;
    }
}
