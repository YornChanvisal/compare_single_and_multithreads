import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args){
        //Available Threads
//        int MAX_THREAD = Runtime.getRuntime().availableProcessors();

        //Declare An Array
        short[] arr;

        //Random Init Array
        ArrayToSort array = new ArrayToSort();
        arr = array.randomArr();

        //Start Timer
        long startTime = System.nanoTime();

        //Fork/Join Thread Pool
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        //Invoke
        forkJoinPool.invoke(new QuickSorts(arr, 0, arr.length - 1));

//        //Thread Pool
//        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD);
//
//        //FailTask.QuickSort Obj Reference
//        Runnable sorting = new FailTask.QuickSort(arr, 0, arr.length - 1);
//
//
//        //Start Timer
//        long startTime = System.nanoTime();
//
//        //Sorting Here
//        executor.execute(sorting);
//        //quickSortObj.quickSort(arr, 0, arr.length - 1);
//
//        //Shut Down Thread
//        executor.shutdown();
//        //Check if threads are done
//        while(!executor.isTerminated());

        //End Timer
        long endTime = System.nanoTime();

        //Calculate Timer and Print it
        System.out.println("\nRun Time: " + (endTime - startTime) + " ns");

        //Check If Sorted
        QuickSorts quickSortsObj = new QuickSorts(arr, 0, arr.length - 1);
        boolean isSorted = quickSortsObj.isSorted(arr, 0, arr.length - 1);
        System.out.println("\nIs it Sorted: " + isSorted);
    }
}
