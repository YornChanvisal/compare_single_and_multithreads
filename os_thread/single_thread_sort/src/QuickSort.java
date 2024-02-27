public class QuickSort {
    //Conquer and Combine
    public void quickSort(short[] arr, int start, int end) {
        if (start < end) {
            //Partitioning Index
            int p = partition(arr, start, end);

            //Recursive Call
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    //Divide
    public int partition(short[] arr, int start, int end) {
        // pivot element
        int pivot = arr[end];

        //Compare Element
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            // If smaller than pivot
            if (arr[j] < pivot) {
                i++; // increment index of smaller element
                swap(arr, i, j);    //swap element
            }
        }
        //swap element
        swap(arr, i+1, end);
        //return partitioning index
        return (i + 1);
    }

    //Swap Array Element Left to Right and Right to Left
    public void swap(short[] arr, int i, int j) {
        short temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Print All Element of the Array
    public void printArr(int[] arr, int length) {
        for (int i = 0; i < length; i++)
            System.out.print(arr[i] + " ");
    }

    //Check If The Array Is Sorted
    public boolean isSorted(short[] arr, int start, int end) {
        for (int i = start+1; i < end; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }
}
