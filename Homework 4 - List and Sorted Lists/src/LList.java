public class LList<T extends Comparable<? super T>> implements ListInterface<T> {
    private Node head;
    private int numberOfEntries;

    public LList(){
        head = null;
        numberOfEntries =0;
    }
    public void incrementEntries(){
        numberOfEntries++;
    }
    public Node getNodeBefore(int givenPosition) {
        Node currentNode = head;
        int count = 1;
        while (count + 1 < givenPosition) {
            currentNode = currentNode.getNextNode();
            count++;
        }
        return currentNode;
    }

    public Node getNodeAt(int givenPosition) {
        return getNodeBefore(givenPosition).getNextNode();
    }

    public void emptyAdd(T newEntry){
        Node newNode = new Node(newEntry, null);
        head = newNode;
        numberOfEntries++;
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
        if (isEmpty()){
            emptyAdd(newEntry);
        } else{
        Node lastNode = getNodeAt(numberOfEntries);
        Node newNode = new Node(newEntry, null);
        lastNode.setNextNode(newNode);
        numberOfEntries++;
        }
    }

    public Node getHead(){
        return head;
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

        if (newPosition >= 1 && newPosition < numberOfEntries) {

            if (newPosition == 1) {
                emptyAdd(newEntry);
            } else {
                Node newNode = new Node(newEntry, null);
                Node nodeBefore = getNodeBefore(newPosition);
                Node nodeAt = getNodeAt(newPosition);
                nodeBefore.setNextNode(newNode);
                newNode.setNextNode(nodeAt);
                numberOfEntries++;
            }
        } else {
            throw new IndexOutOfBoundsException();
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
        if (givenPosition >= 1 && givenPosition < numberOfEntries) {
            Node nodeToRemove = getNodeAt(givenPosition);
            T removedNodeData = nodeToRemove.getData();
            nodeToRemove.setData(null);
            if (givenPosition == 1){ // remove at head
                head = head.getNextNode();
                nodeToRemove.setNextNode(null);
            } else{ // remove middle and tail
                Node nodeBefore = getNodeBefore(givenPosition);
                nodeBefore.setNextNode(nodeToRemove.getNextNode());
                nodeToRemove.setNextNode(null);
            }
            numberOfEntries--;
            return removedNodeData;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        head = null;
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
        if (givenPosition >= 1 && givenPosition < numberOfEntries) {
            Node replaceNode = getNodeAt(givenPosition);
            T originalData = replaceNode.getData();
            replaceNode.setData(newEntry);
            return originalData;
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
        if (givenPosition >= 1 && givenPosition < numberOfEntries) {
            return getNodeAt(givenPosition).getData();
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
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index =0;
        Node currentNode= head;
        while ((index < numberOfEntries) && (currentNode !=null)){
            result[index] = currentNode.getData();
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
    public boolean contains(T anEntry) {
        Node currentNode = head;
        while (currentNode != null){
            if ((currentNode.getData()).equals(anEntry)){
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
    public class Node {
        private Node next;
        private T data;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }


        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }

        public Node getNextNode() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
