package Homework3;

import Homework2.EmptyQueueException;

// Michael Ortega HWK - 3 (PART 1)
public class Dequeue<T> implements DequeueInterface<T> {
    private Node head;
    private Node tail;
    public Dequeue(){
        head = null;
        tail = null;
    }

    /**
     * Adds a nw entry to the front/back of this deque
     *
     * @param newEntry An object to be added.
     */
    @Override
    public void addToFront(T newEntry) {
        Node newNode = new Node(null, newEntry, head);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPreviousNode(newNode);
        }
        head = newNode;
    }

    @Override
    public void addToBack(T newEntry) {
        Node newNode = new Node(tail, newEntry, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }
        tail = newNode;
    }

    /**
     * Removes and returns the front/back entry of this deque.
     *
     * @throws EmptyQueueException if the deque is empty before the operation.
     */
    @Override
    public T removeFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            T tempData = getFront();
            head = head.getNextNode();
            if (head == null) {
                tail = null;
            } else {
                head.setPreviousNode(null);
            }
            return tempData;
        }
    }

    @Override
    public T removeBack() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            T tempData = getBack();
            tail = tail.getPreviousNode();
            if (tail == null) {
                head = null;
            } else {
                tail.setNextNode(null);
            }
            return tempData;
        }
    }

    /**
     * Retrieves the front/back entry of this deque.
     *
     * @return The object at the front/back of the deque.
     * @throws EmptyQueueException if the deque is empty.
     */
    @Override
    public T getFront() {
        return head.getData();
    }

    @Override
    public T getBack() {
        return tail.getData();
    }

    /**
     * Detects weather this deque is empty.
     *
     * @return True if the deque is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    /**
     * Removes all entries from this deque
     */
    @Override
    public void clear() {
        head = null;
        tail = null;

    }

    private class Node {
        private T data;
        private Node next;
        private Node prev;

        public Node(Node previousNode , T newEntry, Node nextNode){
            data = newEntry;
            prev = previousNode;
            next = nextNode;

        }

        public void setPreviousNode(Node previous){
            prev = previous;
        }

        public void setNextNode(Node nextNode) {
            next = nextNode;
        }

        public T getData() {
            return data;
        }

        public Node getPreviousNode() {
            return prev;
        }

        public Node getNextNode() {
            return next;
        }
    }
}

