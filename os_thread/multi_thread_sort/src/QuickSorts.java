import java.util.concurrent.RecursiveAction;

public class QuickSorts extends RecursiveAction {
    private final short[] arr;
    private final int start;
    private final int end;

    //Constructor
    public QuickSorts(short[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    //Divide
    public int partition (short[] arr, int start, int end) {
        int pivot = arr[end]; // pivot element
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++; // increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, end);
        return (i + 1);
    }

    //Swap Array Element Left to Right and Right to Left
    public void swap(short[] arr, int i, int j) {
        short temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Print All Element of the Array
    public void printArr(int[] arr, int n) {
        int i;
        for (i = 0; i < n; i++)
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

    @Override
    protected void compute() {
        if(start < end){
            //Partitioning Index
            int p = partition(arr, start, end);

            //Divide Array To 2 Sub Array
            QuickSorts left = new QuickSorts(arr, start, p-1);
            QuickSorts right = new QuickSorts(arr, p+1, end);

            //Split left Sub-tasks
            left.fork();

            //Recursively run
            right.compute();

            //Join Result
            left.join();
        }
    }
}
