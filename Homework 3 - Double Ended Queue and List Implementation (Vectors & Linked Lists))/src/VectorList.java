import java.util.Vector;

public class VectorList<T> implements ListInterface<T> {
    private Vector<T> list;
    private final int MAX_CAPACITY = 10000;
    private static final int DEFAULT_CAPACITY = 50;
    private int numberOfEntries;
    
    public  VectorList (){
       this(DEFAULT_CAPACITY);
    }
    public VectorList(int initialCapacity){
        list = new Vector<>(initialCapacity);
        
    }
    /**
     * Adds a new entry to the end of the list.
     *
     * @param newEntry object to be added as a new entry
     */
    @Override
    public void addToEnd(T newEntry) {
        list.add(newEntry);
    }

    /**
     * Adds a new entry to the list at a given position.
     *
     * @param newEntry     object to be added as a new entry
     * @param givenPostion An integer that indicates the position of the entry to be added.
     */
    @Override
    public void add(T newEntry, int givenPostion) {
        list.add(givenPostion,newEntry);
    }

    /**
     * Removes an entry from the list at a given position
     *
     * @param givenPosition An integer that indicates the position of the entry to be removed.
     * @return A reference to the entry removed
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > {@link #getCount()}
     */
    @Override
    public T remove(int givenPosition) {
        if (isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }
        T tempEntry = getEntry(givenPosition);
        list.removeElementAt(givenPosition);
        return tempEntry;
    }

    /**
     * Removes all entries in the list
     */
    @Override
    public void removeAll() {
        list.removeAllElements();
    }

    /**
     * Replaces an entry given with a position given in the list.
     *
     * @param givenPosition An integer that indicates the position of the entry to be replaced.
     * @param newEntry      The object that will replace the entry at the givenPosition.
     * @return original entry that was replaced.
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > {@link #getCount()}
     */
    @Override
    public T replace(int givenPosition, T newEntry) {
        T tempData = getEntry(givenPosition);
        list.set(givenPosition,newEntry);
        return tempData;
    }

    /**
     * Retries all entries that are in this list in the order in which they occur in t
     *
     * @param givenPosition An integer that indicates the position of the entry to be returned.
     * @return A reference to the indicated entry.
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > {@link #getCount()}
     */
    @Override
    public T getEntry(int givenPosition) {
        if (isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }
        return list.get(givenPosition);
    }

    /**
     * Retries all entries that are in this list in the order in which they occur in the list.
     */
    @Override
    public void display() {
        for (Object entry: list){
            System.out.print(entry + " ");
        }
    }

    /**
     * Checks weather this list contains a given entry.
     *
     * @param anEntry The object that will be checked if it is inside this list
     * @return True if the list contains anEntry, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    /**
     * Returns the number of entrys that are in this list.
     *
     * @return An integer number representing the amount of entries in this list
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * Checks weather this list is empty.
     *
     * @return True if the list is empty, false if not.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
