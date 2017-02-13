
public class LinkedBasedList<T> implements ListInterface<T> {
    private Node head;
    private Node tail;
    private int numberOfEntries;

    public LinkedBasedList(){
        head = null;
        tail = null;
        numberOfEntries = 0;
    }

    /**
     * Adds a new entry to the end of the list.
     *
     * @param newEntry object to be added as a new entry
     */
    @Override
    public void addToEnd(T newEntry) {
        Node newNode = new Node(newEntry, null);
        numberOfEntries++;
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    /**
     * Adds a new entry to the list at a given position.
     *
     * @param newEntry      object to be added as a new entry
     * @param givenPosition An integer that indicates the position of the entry to be added.
     */
    @Override
    public void add(T newEntry, int givenPosition) {

        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            head = newNode;
            numberOfEntries++;
        } else if (givenPosition == 1 && !(isEmpty())) {
            newNode.setNextNode(head);
            head = newNode;
            numberOfEntries++;
        } else {
            checkValidIndex(givenPosition);
            Node nodeBefore = getNodeBefore(givenPosition);
            newNode.setNextNode(getNodeAt(givenPosition));
            nodeBefore.setNextNode(newNode);
            numberOfEntries++;
        }

    }
    private Node getNodeAt(int givenPosition){
        return getNodeBefore(givenPosition).getNextNode();
    }
    private Node getNodeBefore(int givenPosition) {
        Node currentNode = head;
        int count = 1;
        while (count + 1 < givenPosition) {
            currentNode = currentNode.getNextNode();
            count++;
        }
        return currentNode;
    }

    private void checkValidIndex(int givenPosition){
        if (givenPosition < 0 || givenPosition > getCount())
            throw new IndexOutOfBoundsException();
    }

    /**
     * Removes an entry from the list at a given position
     *
     * @param givenPosition An integer that indicates the position of the entry to be removed.
     * @return A reference to the entry removed
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPostion > {@link #getCount()}
     */
    @Override
    public T remove(int givenPosition) {
        checkValidIndex(givenPosition);
        if (givenPosition == 1) {
            Node tempNode = head;
            T tempData = tempNode.getData();
            head = head.getNextNode();
            tempNode.setNextNode(null);
            return tempData;
        } else {

            Node nodeBefore = getNodeBefore(givenPosition);
            Node nodeToRemove = getNodeAt(givenPosition);
            T tempData = getEntry(givenPosition);
            nodeBefore.setNextNode(nodeToRemove.getNextNode());
            numberOfEntries--;
            return tempData;
        }
    }

    /**
     * Removes all entries in the list
     */
    @Override
    public void removeAll() {
        Node currentNode = head;
        while (currentNode != null) {
            currentNode.setData(null);
        }
        head = null;
        numberOfEntries = 0;
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
        checkValidIndex(givenPosition);
        Node nodeBefore = getNodeBefore(givenPosition);//
        Node nodeToReplace = nodeBefore.getNextNode();
        T tempData = nodeToReplace.getData();
        nodeToReplace.setData(newEntry);
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
        checkValidIndex(givenPosition);
        Node nodeToReturn = getNodeBefore(givenPosition).getNextNode(); //
        return nodeToReturn.getData();
    }

    /**
     * Retries all entries that are in this list in the order in which they occur in the list.
     */
    @Override
    public void display() {
        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    /**
     * Checks weather this list contains a given entry.
     *
     * @param anEntry The object that will be checked if it is inside this list
     * @return True if the list contains anEntry, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        Node current = head;
        while (current != null){
            if (current.getData().equals(anEntry)){
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    /**
     * Returns the number of entrys that are in this list.
     *
     * @return An integer number representing the amount of entries in this list
     */
    @Override
    public int getCount() {
        return numberOfEntries;
    }

    /**
     * Checks weather this list is empty.
     *
     * @return True if the list is empty, false if not.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private class Node{
        private Node next;
        private T data;

        public Node(T data, Node next){
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
