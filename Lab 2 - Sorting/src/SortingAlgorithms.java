import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithms {

    public void selectionSort(int[] array) {

        for (int sortedIndex = 0; sortedIndex < array.length - 1; sortedIndex++) {
            for (int unsortedIndex = sortedIndex + 1; unsortedIndex < array.length; unsortedIndex++) {
                int minimumIndex = sortedIndex;
                if (array[unsortedIndex] < array[minimumIndex]) {
                    minimumIndex = unsortedIndex;
                }
                int temp = array[minimumIndex];
                array[minimumIndex] = array[sortedIndex];
                array[sortedIndex] = temp;

            }
        }
    }

    public void selectionSortR(int[] array, int first, int last) {
        int minimumIndex = first;
        if (first < last) {
            for (int unsortedIndex = first + 1; unsortedIndex < array.length; unsortedIndex++) {
                if (array[unsortedIndex] < array[minimumIndex]) {
                    minimumIndex = unsortedIndex;
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
    //***************************

    public void insertionSort(int[] array) {
        for (int unsortedIndex = 1; unsortedIndex < array.length; unsortedIndex++) {
            int indexToInsert = array[unsortedIndex];
            int sortedEnd = unsortedIndex - 1;
            while ((sortedEnd >= 0) && (indexToInsert < array[sortedEnd])) {
                array[sortedEnd + 1] = array[sortedEnd]; // move to right
                sortedEnd--;
            }
            array[sortedEnd + 1] = indexToInsert;
        }
    }

    public void insertionSortR(int[] array, int first, int last){
        if (first < last){
            insertionSortR(array,first,last - 1);
            insertInOrder(array[last], array, first, last - 1);
        }

    }

    private void insertInOrder(int nextToInsert, int[] array, int begin, int end) {
        if (nextToInsert >= array[end]){
            array[end + 1] = nextToInsert;
        } else if (begin < end){
            array[end + 1] = array[end];
            insertInOrder(nextToInsert,array,begin,end - 1);
        } else {
            array[end + 1] = array[end];
            array[end] = nextToInsert;
        }

    }
    //**********************
    /*       Merge Sort     */

    public void mergeSortR(int [] array, int [] temp, int left , int right){
        if (left < right){
            int center = (left + right) / 2;
            mergeSortR(array,temp,left, center);
            mergeSortR(array,temp, center + 1, right);
            merge(array,temp,left,center + 1,right);
        }
    }

    private void merge(int[] array, int[] temp, int leftPos, int rightPos , int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (array[leftPos] < array[rightPos]){
                temp[tempPos++] = array[leftPos++];

            } else{
                temp[tempPos] = array[rightPos];
            }
            while (leftPos <= leftEnd){
                temp[tempPos++] = array[leftPos++];
            }
            while (rightPos <= rightEnd)
                temp[tempPos++] = array[rightPos++];
            for (int i = 0; i < numElements; i++, rightEnd--){
                array[rightEnd] = temp[rightEnd];
            }
        }


    }
    /* *************************/


    public static void quickSortR(int[] array, int low, int right) {
        if (array == null || array.length == 0)
            return;

        if (low >= right)
            return;

        int middle = low + (right - low) / 2;
        int pivot = array[middle];

        int left = low, j = right;
        while (left <= j) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (left <= j) {
                int temp = array[left];
                array[left] = array[j];
                array[j] = temp;
                left++;
                j--;
            }
        }
        if (low < j)
            quickSortR(array, low, j);

        if (right > left)
            quickSortR(array, left, right);
    }

    private int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int smallestIndex = (low-1); // index of smaller element
        for (int j=low; j<=high-1; j++)
        {
            if (arr[j] <= pivot)
            {
                smallestIndex++;

                // swap arr[smallestIndex] and arr[j]
                int temp = arr[smallestIndex];
                arr[smallestIndex] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[smallestIndex+1];
        arr[smallestIndex+1] = arr[high];
        arr[high] = temp;

        return smallestIndex+1;
    }

    /*
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
    }
    //*****************
    public void radixsort(int[] input) {
        final int RAD = 10;
        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RAD];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }


        boolean maxLength = false;
        int temp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            for (Integer i : input) {
                temp = i / placement;
                bucket[temp % RAD].add(i);
                if (maxLength && temp > 0) {
                    maxLength = false;
                }
            }
            int a = 0;
            for (int b = 0; b < RAD; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= RAD;
        }
    }

}