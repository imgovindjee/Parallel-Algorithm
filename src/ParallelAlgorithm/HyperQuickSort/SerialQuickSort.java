package ParallelAlgorithm.HyperQuickSort;

public class SerialQuickSort {

    public static void quickSort(int[] array, int leftIdx, int rightIdx){
        if (leftIdx < rightIdx){
            int pivotIdx = getPivot(array, leftIdx, rightIdx);

            quickSort(array, leftIdx, pivotIdx - 1);
            quickSort(array, pivotIdx + 1, rightIdx);
        }
    }

    public static int getPivot(int[] array, int leftIdx, int rightIdx){
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

    public static void run() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++){
            array[i] = (int) (Math.random() * 100);
        }

        quickSort(array, 0, array.length - 1);
        for (int a:array){
            System.out.println(a);
        }
    }
}
