package ParallelAlgorithm;

public class SerialMergeSort {

    public static void mergeSort(int[] array){
        if(array.length > 1){
            int mid = array.length / 2;

//            dividing the array into two equal half
//            first half -- leftHalf
            int[] leftHalf = new int[mid];
            System.arraycopy(array, 0, leftHalf, 0, mid);
//            second half -- rightHalf
            int[] rightHalf = new int[array.length - mid];
            System.arraycopy(array, mid, rightHalf, 0, array.length - mid);

//            DIVIDE THE ARRAY RECURSIVELY UNTIL THE BASE CONDITION MATCHES
            mergeSort(leftHalf);
            mergeSort(rightHalf);

//            MERGE THEM AFTER DIVIDING THEM INTO EQUAL HALVES
            merge(array, leftHalf, rightHalf);
        }
    }

    public static void merge(int[] array, int[] leftHalf, int[] rightHalf){
        int currentIndexArray=0;
        int currentLeftHalfIndex = 0, currentRightHalfIndex = 0;

        while (currentLeftHalfIndex < leftHalf.length && currentRightHalfIndex < rightHalf.length){
            if (leftHalf[currentLeftHalfIndex] < rightHalf[currentRightHalfIndex]){
                array[currentIndexArray++] = leftHalf[currentLeftHalfIndex++];
            } else {
                array[currentIndexArray++] = rightHalf[currentRightHalfIndex++];
            }
        }

        while (currentLeftHalfIndex < leftHalf.length){
            array[currentIndexArray++] = leftHalf[currentLeftHalfIndex++];
        }
        while (currentRightHalfIndex < rightHalf.length){
            array[currentIndexArray++] = rightHalf[currentRightHalfIndex++];
        }
    }

    public static void run(){
        int[] array = new int[10];
        for (int i = 0; i < 10; i++){
            array[i] = (int) (Math.random() * 10);
        }

        mergeSort(array);
        for (int a:array){
            System.out.println(a);
        }
    }
}
