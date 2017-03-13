package Final;


public class LinkedList<V> implements ListInterface<V> {
    private Node head;
    private int numberOfEntries;

    public LinkedList(){
        head =null;
        numberOfEntries = 0;
    }


    private Node getNodeAt(int position) {
        if (position == 1) {
            return head;
        } else {
            return getNodeBefore(position).getNextNode();
        }
    }

    private Node getNodeBefore(int position){
        Node currentNode = head;
        int count = 1;
        while (count + 1 < position){
            currentNode= currentNode.getNextNode();
            count++;
        }
        return currentNode;
    }


    /**
     * Adds a new entry to the end of this list.
     * Entries currently in the list are unaffected.
     * The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(V newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            head = newNode;
        } else if (numberOfEntries == 1) {
            Node lastNode = head;
            lastNode.setNextNode(newNode);
        } else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode);
        }
        numberOfEntries++;
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
    public V remove(int givenPosition) {
        if (givenPosition >= 1 && givenPosition < numberOfEntries) {
            Node nodeToRemove = getNodeAt(givenPosition);
            V removedData = nodeToRemove.getValue();
            nodeToRemove.setValue(null);

            if (givenPosition == 1) {
                head = head.getNextNode();
            } else {
                Node nodeBefore = getNodeBefore(givenPosition);
                nodeBefore.setNextNode(nodeToRemove.getNextNode());
                nodeToRemove.setNextNode(null);
            }
            numberOfEntries--;
            return removedData;
        } else {
            throw new IndexOutOfBoundsException("Given position is out of List range.");
        }
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        head =null;
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
    public V getEntry(int givenPosition) {
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            return getNodeAt(givenPosition).getValue();
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
    public V[] toArray() {
        @SuppressWarnings("unchecked")
        V[] result = (V[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = head;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getValue();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    @Override
    public boolean contains(V anEntry) {
        Node currentNode = head;
        while (currentNode != null) {
            if ((currentNode.getValue()).equals(anEntry)) {
                return true;
            }
            currentNode = currentNode.getNextNode();
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
        return head == null;
    }

    private class Node{
        private V value;
        private Node next;

        public Node(V value, Node next){
            this.value = value;
            this.next = next;
        }

        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }

        public Node getNextNode() {
            return next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }
}
