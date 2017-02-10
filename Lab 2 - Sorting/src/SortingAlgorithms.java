import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private int partition(int[] a, int start, int end){
        Random ran = new Random();
        int index = start+ran.nextInt(end - start + 1); //set random index pivot value
        int pivot = a[index];//sets the random pivot value
        swap(a,index, end); // puts random pivot value at the end of array
        index = start; // set partition index to the beginning of the array
        for (int i= start; i < end; i++) {
            if (a[i]<pivot) {
                swap(a,index, i);
                index++;
            }
        }
        swap(a,index, end);
        return index;
    }


    public void qSort(int[] a, int start, int end){
        if(end > start){
            int index = partition(a,start,end);
            qSort(a, start, index - 1);
            qSort(a, index + 1, end);
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


    public void shellSort(int [] array) {
        int i, j, k, h, hCount, increments[] = new int[10];
        // create an number of increments h
        for (h = 1, i = 0; h < array.length; i++) {
            increments[i] = h;
            h = 2 * i + 1;
        }
        // loop on the number of different increments h
        for (i--; i >= 0; i--) {
            h = increments[i];

            for (hCount = h; hCount < 2 * h; hCount++) {
                for (j = hCount; j < array.length; ) {
                    int tmp =  array[j];
                    k = j;
                    while (k - h >= 0 && tmp <array[k - h] ) {
                        array[k] = array[k - h];
                        k -= h;
                    }
                    array[k] = tmp;
                    j += h;
                }
            }
        }
    }

}