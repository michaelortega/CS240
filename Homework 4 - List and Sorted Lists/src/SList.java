
public class SList<T extends Comparable<? super T>> extends LList<T> implements SortedListInterface<T> {

    public SList(){
        super();
    }
    /** Adds a new entry to this sorted list in its proper order.
     The list's size is increased by 1.
     @param newEntry  The object to be added as a new entry. */
    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry,null);
        Node nodeBefore = getNodeBefore(newEntry);

    }

    public Node getNodeBefore(T anEntry){
        Node current = getHead();
        Node nodeBefore = null;

        while ((current != null) ) {}
    }

    /** Removes the first or only occurrence of a specified entry
     from this sorted list.
     @param anEntry  The object to be removed.
     @return  True if anEntry was located and removed;
     otherwise returns false. */
    @Override
    public T remove(T anEntry) {

    }

    /**
     * Gets the position of an entry in this sorted list.
     *
     * @param anEntry The object to be found.
     * @return The position of the first or only occurrence of anEntry
     * if it occurs in the list; otherwise returns the position
     * where anEntry would occur in the list, but as a negative
     * integer.
     */
    @Override
    public int getPosition(T anEntry) {
        return 0;
    }



}
