/**
 * Created by Michael on 2/8/2017.
 */
public class CircularLinkedList<T> implements QueueInterface<T> {

    private final int MAX_SIZE = 10;
    private int numberOfNodes;
    private Node head;
    private Node emptyNode;

    public CircularLinkedList(){
        emptyNode = new Node(null);
        emptyNode.setNext(emptyNode);
        head = emptyNode;
        numberOfNodes = 1;
    }
    /**
     * Adds a new entry to the back of this queue.
     *
     * @param newEntry An object to be added.
     */
    @Override
    public void enqueue(T newEntry) {
        if (numberOfNodes < MAX_SIZE) {
            emptyNode.setData(newEntry);
            if (isChainFull()) {
                Node newNode = new Node(null);
                newNode.setNext(head.getNext());
                emptyNode.setNext(newNode);
            }
            emptyNode = emptyNode.getNext();
            numberOfNodes++;
        }
    }

    /**
     * Removes and returns the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T temp = head.getData();
            head.setData(null);
            head = head.getNext();
            return temp;
        }
        throw new EmptyQueueException();
    }

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    @Override
    public T getFront() {
        if (isEmpty()){
            throw new EmptyQueueException();
        } else {
            return head.getData();
        }
    }

    /**
     * Detects whether this queue is empty.
     *
     * @return True if the queue is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return head == emptyNode;
    }

    /**
     * Removes all entries from this queue.
     */
    @Override
    public void clear() {
        while (!isEmpty()){
            dequeue();
        }
    }

    public boolean isChainFull() {
        return head == emptyNode.getNext();
    }

    private class Node{
        private T data;
        private Node next;

        public Node(T newData){
            data = newData;
        }


        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
