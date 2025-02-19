package ParallelAlgorithm.HyperQuickSort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort {

    public static void parallelQuickSort(int[] array){
        SortTask sortTask = new SortTask(array, 0, array.length - 1);
        ForkJoinPool joinPool = new ForkJoinPool();
        joinPool.invoke(sortTask);
    }

    private static class SortTask extends RecursiveAction{

        private int[] array;
        int leftIdx, rightIdx;

        public SortTask(int[] array, int leftIdx, int rightIdx){
            this.array = array;
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
        }

        @Override
        protected void compute() {
            if (leftIdx < rightIdx){
//                int pivotIdx = getPivot(array, leftIdx, rightIdx);
                int pivotIdx = SerialQuickSort.getPivot(array, leftIdx, rightIdx);

//                DIVIDING THE ARRAY INTO TWO PARTS BASED ON PIVOT FIND
                SortTask leftTask = new SortTask(array, leftIdx, pivotIdx - 1);
                SortTask rightTask = new SortTask(array, pivotIdx + 1, rightIdx);
//                INVOKES ALL THE TASK
                invokeAll(leftTask, rightTask);
            }
        }

        private int getPivot(int[] array, int leftIdx, int rightIdx){
            int pivotElement = array[rightIdx];
            int idx = leftIdx - 1;
            for (int i = leftIdx; i < rightIdx; i++){
                if (array[i] < pivotElement){
                    idx++;
                    swap(array, idx, i);
                }
            }
            swap(array, idx + 1, rightIdx);
            return idx + 1;
        }

        private static void swap(int[] array, int idx1, int idx2){
            int temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
        }
    }


    public static void run() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++){
            array[i] = (int) (Math.random() * 100);
        }

        parallelQuickSort(array);
        for (int a:array){
            System.out.println(a);
        }
    }
}
