package Analysis;

import ParallelAlgorithm.HyperQuickSort.ParallelQuickSort;
import ParallelAlgorithm.HyperQuickSort.SerialQuickSort;

import java.util.Arrays;

public class QuickSortAnalysis {
    public static void main(String[] args) {
        long sortingStartTime, sortingEndTime;

        int[] array1 = new int[7000000];
        int[] array2 = new int[7000000];
        for (int i = 0; i < 7000000; i++){
            array1[i] = array2[i] = (int)(Math.random() * 1000000);
        }

        sortingStartTime = System.currentTimeMillis();
        ParallelQuickSort.parallelQuickSort(array1);
        sortingEndTime = System.currentTimeMillis();

        System.out.println("Parallel Quick Sorting Algorithm Time is: "+(sortingEndTime - sortingStartTime)+"ms");

        sortingStartTime = System.currentTimeMillis();
        SerialQuickSort.quickSort(array2, 0, array2.length - 1);
        sortingEndTime = System.currentTimeMillis();

        System.out.println("Serial Quick Sorting Algorithm Time is: "+(sortingEndTime - sortingStartTime)+"ms");

//        TEST CHECK
        System.out.println("Are the arrays sorted equal: "+ Arrays.equals(array1, array2));
    }
}
