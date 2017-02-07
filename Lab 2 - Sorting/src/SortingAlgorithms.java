/**
 * Created by Michael on 2/4/2017.
 */
public class SortingAlgorithms {

    public void selctionSort(){
       // int minimumIndex = first;
    }

    public void selectionSortR(int[] array, int first, int last) {
        int minimumIndex = first;
        if (first < last) {
            for (int index = first + 1; index < array.length; index++) {
                if (array[first] < array[index]) {
                    minimumIndex = index;
                }
            }
            swap(array, first, minimumIndex);
            selectionSortR(array, first + 1, last);
        }

    }


    public void swap(int[] array, int index, int lowestIndex) {
        int temp = array[lowestIndex];
        array[lowestIndex] = array[index];
        array[index] = temp;
    }
}