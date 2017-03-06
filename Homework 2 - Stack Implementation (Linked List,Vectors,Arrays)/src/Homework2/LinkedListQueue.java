package Homework2;

/**
 * Created by Michael on 2/8/2017.
 */
public class LinkedListQueue<T> implements QueueInterface<T> {
    private Node tail;
    private Node head;

    public LinkedListQueue(){
        tail = null;
        head = null;
    }

    /**
     * Adds a new entry to the back of this queue.
     *
     * @param newEntry An object to be added.
     */
    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }

        tail = newNode;
    }

    /**
     * Removes and returns the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new EmptyQueueException();
        } else {
            T temp = getFront();
            head.setData(null);
            head = head.getNext();
            if (head == null){
                tail = null;
            }
            return temp;
        }
        
    }

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    @Override
    public T getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return head.getData();
    }

    /**
     * Detects whether this queue is empty.
     *
     * @return True if the queue is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (head == null) && (tail == null);
    }

    /**
     * Removes all entries from this queue.
     */
    @Override
    public void clear() {
        tail = null;
        head = null;

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
