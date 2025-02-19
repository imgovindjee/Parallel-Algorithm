package ParallelAlgorithm.MergeSort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort {

    public static void parallelMergeSort(int[] array){
        SortTask sortTask = new SortTask(array);
        ForkJoinPool joinPool = new ForkJoinPool();
        joinPool.invoke(sortTask);
    }

    private static class SortTask extends RecursiveAction {

        private int[] array;

        public SortTask(int[] array){
            this.array = array;
        }

        @Override
        protected void compute() {
            if (array.length > 1){
                int mid = array.length / 2;

//            dividing the array into two equal half
//            first half -- leftHalf
                int[] leftHalf = new int[mid];
                System.arraycopy(array, 0, leftHalf, 0, mid);
//            second half -- rightHalf
                int[] rightHalf = new int[array.length - mid];
                System.arraycopy(array, mid, rightHalf, 0, array.length - mid);

//            DIVIDE THE ARRAY RECURSIVELY UNTIL THE BASE CONDITION MATCHES
                SortTask leftHalfTask = new SortTask(leftHalf);
                SortTask rightHalfTask = new SortTask(rightHalf);
//            INVOKE ALL THE TASKS
                invokeAll(leftHalfTask, rightHalfTask);

//            MERGE THEM AFTER DIVIDING THEM INTO EQUAL HALVES
                SerialMergeSort.merge(array, leftHalf, rightHalf);
            }
        }
    }


    public static void run(){
        int[] array = new int[10];
        for (int i = 0; i < 10; i++){
            array[i] = (int) (Math.random() * 10);
        }

        parallelMergeSort(array);
        for (int a:array){
            System.out.println(a);
        }
    }
}
