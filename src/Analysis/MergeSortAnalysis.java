package Analysis;

import ParallelAlgorithm.ParallelMergeSort;
import ParallelAlgorithm.SerialMergeSort;

public class MergeSortAnalysis {

    public static void main(String[] args) {
        long sortingStartTime, sortingEndTime;

        int[] array1 = new int[7000000];
        int[] array2 = new int[7000000];
        for (int i = 0; i < 7000000; i++){
            array1[i] = array2[i] = (int)(Math.random() * 1000000);
        }

        sortingStartTime = System.currentTimeMillis();
        ParallelMergeSort.parallelMergeSort(array1);
        sortingEndTime = System.currentTimeMillis();

        System.out.println("Parallel Merge Sorting Algorithm Time is: "+(sortingEndTime - sortingStartTime)+"ms");

        sortingStartTime = System.currentTimeMillis();
        SerialMergeSort.mergeSort(array2);
        sortingEndTime = System.currentTimeMillis();

        System.out.println("Serial Merge Sorting Algorithm Time is: "+(sortingEndTime - sortingStartTime)+"ms");
    }
}
