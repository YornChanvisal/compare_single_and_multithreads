public class Main {
    public static void main(String[] args){
        //Declare An Array
        short[] arr;

        //Random Init Array
        ArrayToSort array = new ArrayToSort();
        arr = array.randomArr();

        //Start Timer
        long startTime = System.nanoTime();

        //Sorting Here
        QuickSort quickSortObj = new QuickSort();
        quickSortObj.quickSort(arr, 0, arr.length - 1);

        //End Timer
        long endTime = System.nanoTime();

        //Calculate Timer and Print it
        System.out.println("\nRun Time: " + (endTime - startTime) + " ns");

        //Check if it is sorted
        boolean isSorted = quickSortObj.isSorted(arr, 0, arr.length - 1);
        System.out.println("Is it Sorted: " + isSorted);
    }
}
