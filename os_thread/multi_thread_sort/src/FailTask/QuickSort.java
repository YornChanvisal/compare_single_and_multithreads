package FailTask;

public class QuickSort implements Runnable{
    private final short[] arr;
    private final int start;
    private final int end;

    //Constructor
    public QuickSort(short[] arr, int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    //Conquer and Combine
    public void threadQuickSort(short[] arr, int start, int end) {
        if (start < end) {
            //Partitioning Index
            int p = partition(arr, start, end);

            //Recursive Call Threads
            QuickSort left = new QuickSort(arr, start, p - 1);
            Thread leftTh = new Thread(left, "t-1");

            QuickSort right = new QuickSort(arr, p + 1, end);
            Thread rightTh = new Thread(right, "t-2");

            //Threads Start
            leftTh.start();
            rightTh.start();

            //Threads Join
            try {
                leftTh.join();
                rightTh.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
    public void printArr(short[] arr, int length) {
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

    @Override   //Run Method
    public void run() {
        threadQuickSort(arr, start, end);
    }
}
