import java.util.Arrays;

public class SortingTest {
    private static int[] array1 = {3, -3, 0, 19, 35, 500, 5, 45, 45, 90};
    private static int[] array2 = {3, -3, 0, 19, 35, 500, 5, 45, 45, 90};
    private static int[] array3 = {3, -3, 0, 19, 35, 500, 5, 45, 45, 90};
    private static int[] correctArray1 = {-3, 0, 3, 5, 19, 35, 45, 45, 90, 500};


    public static void main(String[] args) {
        SortingAlgorithms sortingAlgoObj = new SortingAlgorithms();
       // sortingAlgoObj.selectionSortR(array1, 0, array1.length - 1);
        //sortingAlgoObj.selectionSort(array1);
        sortingAlgoObj.insertionSortR(array1,0, array1.length -1);
        sortingAlgoObj.mergeSortR(array1, array2,0, array1.length - 1 );
        sortingAlgoObj.quickSort(array1, 0 , array1.length - 1);

        if (Arrays.equals(array1, correctArray1)) {
            System.out.println("Passed");
            printArrays(array1, correctArray1);
        } else {
            System.out.println("****Failed*****");
            printArrays(array1, correctArray1);
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





}