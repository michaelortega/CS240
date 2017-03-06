import java.util.EmptyStackException;

/**
 * Created by Michael on 3/6/2017.
 */
public class ArrList<T> implements ListInterface<T> {
    private final static int DEFAULT_MAX_SIZE = 10;
    private T[] arr;
    private int numberOfEntries;
    private int currentIndex;

    public ArrList(int size){
        if (size <= DEFAULT_MAX_SIZE){
            numberOfEntries = 0;
            currentIndex = -1;
            @SuppressWarnings("unchecked")
            T[] temp = (T[]) new Object[DEFAULT_MAX_SIZE];
            arr = temp;
        }
    }

    public ArrList(){
       this(DEFAULT_MAX_SIZE);
    }

    public boolean isFull(){
        return currentIndex == DEFAULT_MAX_SIZE - 1;
    }
    /**
     * Adds a new entry to the end of this list.
     * Entries currently in the list are unaffected.
     * The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        if (!isFull()){
            arr[currentIndex++] = newEntry;
            numberOfEntries++;
        } else {
            throw new EmptyStackException();
        }
    }

    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position
     * are at the next higher position within the list.
     * The list's size is increased by 1.
     *
     * @param newPosition An integer that specifies the desired
     *                    position of the new entry.
     * @param newEntry    The object to be added as a new entry.
     * @throws IndexOutOfBoundsException if either
     *                                   newPosition < 1 or newPosition > getLength() + 1.
     */
    @Override
    public void add(int newPosition, T newEntry) {
        if (newPosition >= 1 && newPosition < numberOfEntries + 1){
           if (newPosition <= numberOfEntries){
               makeRoom(newPosition);
           }
           arr[newPosition] = newEntry;
            numberOfEntries++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private void makeRoom(int newPosition) {
        int lastIndex = numberOfEntries;
        for (int index = lastIndex; index >= newPosition; index--){
            arr[index + 1] = arr[index];
        }
    }

    /**
     * Removes the entry at a given position from this list.
     * Entries originally at positions higher than the given
     * position are at the next lower position within the list,
     * and the list's size is decreased by 1.
     *
     * @param givenPosition An integer that indicates the position of
     *                      the entry to be removed.
     * @return A reference to the removed entry.
     * @throws IndexOutOfBoundsException if either
     *                                   givenPosition < 1 or givenPosition > getLength().
     */
    @Override
    public T remove(int givenPosition) {
        if (givenPosition >= 1 && givenPosition < numberOfEntries){
            T originalEntry = getEntry(givenPosition);
            if (givenPosition < numberOfEntries){
                removeGap(givenPosition);
            }
            numberOfEntries--;
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private void removeGap(int givenPosition ) {
        for (int startOfGap = givenPosition; startOfGap < numberOfEntries; startOfGap++){
            arr[startOfGap] = arr[startOfGap + 1];
        }
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        for (int index =0; index < arr.length; index++){
            arr[index] = null;
            numberOfEntries--;
        }
    }

    /**
     * Replaces the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of
     *                      the entry to be replaced.
     * @param newEntry      The object that will replace the entry at the
     *                      position givenPosition.
     * @return The original entry that was replaced.
     * @throws IndexOutOfBoundsException if either
     *                                   givenPosition < 1 or givenPosition > getLength().
     */
    @Override
    public T replace(int givenPosition, T newEntry) {
        if (givenPosition >= 1 && givenPosition < numberOfEntries){
           T originalEntry = getEntry(givenPosition);
            arr[givenPosition] = newEntry;
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of
     *                      the desired entry.
     * @return A reference to the indicated entry.
     * @throws IndexOutOfBoundsException if either
     *                                   givenPosition < 1 or givenPosition > getLength().
     */
    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition >= 1 && givenPosition < numberOfEntries){
            return arr[givenPosition];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Retrieves all entries that are in this list in the order in which
     * they occur in the list.
     *
     * @return A newly allocated array of all the entries in the list.
     * If the list is empty, the returned array is empty.
     */
    @Override
    public T[] toArray() {
        T[] copy = arr;
        return copy;
    }

    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        for (T item: arr){
            if (item.equals(anEntry)){
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }

    /**
     * Sees whether this list is empty.
     *
     * @return True if the list is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        return currentIndex < 0;
    }
}
