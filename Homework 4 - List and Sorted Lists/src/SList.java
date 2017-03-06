
public class SList<T extends Comparable<? super T>> extends LList<T> implements SortedListInterface<T> {

    public SList() {
        super();
    }

    /**
     * Adds a new entry to this sorted list in its proper order.
     * The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry, null);
        Node nodeBefore = getNodeBefore(newEntry);
        if (isEmpty() || nodeBefore == null) {
            //add to head
            newNode.setNextNode(getHead());
            setHead(newNode);
        } else {
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
        }
        incrementEntries();
    }

    public Node getNodeBefore(T anEntry) {
        Node currentNode = getHead();
        Node nodeBefore = null;

        while ((currentNode != null) && (anEntry.compareTo(currentNode.getData()) > 0)) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return nodeBefore;
    }

    /**
     * Removes the first or only occurrence of a specified entry
     * from this sorted list.
     *
     * @param anEntry The object to be removed.
     * @return True if anEntry was located and removed;
     * otherwise returns false.
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        int position = getPosition(anEntry);
        if (position > 0) {
            remove(position);
            result = true;
        }
        return result;
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
        int position = 1;
        int length = getLength();
        while ((position <= length) && anEntry.compareTo(getEntry(position)) > 0) {
            position++;
        }
        if ((position > length) || anEntry.compareTo(getEntry(position)) != 0) {
            position = -position;
        }
        return position;
    }
}
