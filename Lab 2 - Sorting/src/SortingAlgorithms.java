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
}