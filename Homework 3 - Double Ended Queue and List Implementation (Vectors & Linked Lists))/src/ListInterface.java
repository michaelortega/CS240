/**
 * Created by Michael on 2/12/2017.
 */
public interface ListInterface <T> {
    /**
     *  Adds a new entry to the end of the list.
     * @param newEntry object to be added as a new entry
     */
    public void addToEnd(T newEntry);

    /**
     * Adds a new entry to the list at a given position.
     * @param newEntry object to be added as a new entry
     * @param givenPostion An integer that indicates the position of the entry to be added.
     */
    public void add(T newEntry, int givenPostion);

    /**
     * Removes an entry from the list at a given position
     * @param givenPosition An integer that indicates the position of the entry to be removed.
     * @return A reference to the entry removed
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPostion > {@link #getCount()}
     */
    public T remove(int givenPosition);

    /**
     * Removes all entries in the list
     */
    public void removeAll();

    /**
     * Replaces an entry given with a position given in the list.
     * @param givenPosition An integer that indicates the position of the entry to be replaced.
     * @param newEntry The object that will replace the entry at the givenPosition.
     * @return original entry that was replaced.
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > {@link #getCount()}
     */
    public T replace(int givenPosition, T newEntry);

    /**
     * Retries all entries that are in this list in the order in which they occur in t
     * @param givenPosition An integer that indicates the position of the entry to be returned.
     * @return A reference to the indicated entry.
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPosition > {@link #getCount()}
     */
    public T getEntry(int givenPosition);

    /**
     * Retries all entries that are in this list in the order in which they occur in the list.
     */
    public void display();

    /**
     * Checks weather this list contains a given entry.
     * @param anEntry The object that will be checked if it is inside this list
     * @return True if the list contains anEntry, or false if not.
     */
    public boolean contains(T anEntry);

    /**
     * Returns the number of entrys that are in this list.
     * @return An integer number representing the amount of entries in this list
     */
    public int getCount();

    /**
     * Checks weather this list is empty.
     * @return True if the list is empty, false if not.
     */
    public boolean isEmpty();


}
