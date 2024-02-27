import java.util.Scanner;

public class ArrayToSort {
    //Scanner
    Scanner input = new Scanner(System.in);

    //Auto Generate Array
    public short[] randomArr(){
        int size;

        //User Input Size of Array
        System.out.print("Input Array Size: ");
        size = input.nextInt();

        //Init Array With Inputted Size
        short[] arr = new short[size];

        //Generate Value of Each Elements
        for (int i = 0; i < arr.length; i++){
            arr[i] = (short) (Math.random() * (1500-1+1)+1);
        }

        //Return array
        return arr;
    }
}
