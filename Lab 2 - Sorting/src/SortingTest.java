import java.util.Arrays;
import java.util.Random;

public class SortingTest {
    private static int[] array1 = {3, -3, 0, 19, 35, 500, 5, 45, 45, 90};
    private static int[] correctArray1 = {-3, 0, 3, 5, 19, 35, 45, 45, 90, 500};
    private static int[] arrayToFill = new int[1000];


    public static void main(String[] args) {
        SortingAlgorithms sortingAlgoObj = new SortingAlgorithms();
        randomFill(arrayToFill);
       // sortingAlgoObj.selectionSortR(array1, 0, array1.length - 1);
        sortingAlgoObj.insertionSort(arrayToFill);

        System.out.println("number of moves: " + SortingAlgorithms.countMove + " " + " number of compares:" + SortingAlgorithms.countCompare);
        //sortingAlgoObj.insertionSortR(array1,0, array1.length -1);
        //sortingAlgoObj.mergeSortR(array1, array2,0, array1.length - 1 );
        //sortingAlgoObj.qSort(array1, 0 , array1.length - 1);
       // sortingAlgoObj.shellSort(array1);
        //sortingAlgoObj.mergeSortI(array1, array1.length -1);

        if (Arrays.equals(arrayToFill, correctArray1)) {
            System.out.println("Passed");
            printArrays(arrayToFill, correctArray1);
        } else {
            System.out.println("****Failed*****");
            printArrays(arrayToFill, correctArray1);
        }
    }

    private static void printArrays(int[] test, int[] correct) {
        System.out.println("Your array: ");

        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
        System.out.println();
        System.out.println("Correct sorted array should look like: ");
        for (int i = 0; i < correct.length; i++) {
            System.out.print(correct[i] + " ");
        }
    }

    private static void randomFill(int [] array){
        Random ran = new Random();
        for (int i = 0 ; i < array.length; i++){
            int randomNum = ran.nextInt(1000);
            array[i] = randomNum;
        }
    }



}