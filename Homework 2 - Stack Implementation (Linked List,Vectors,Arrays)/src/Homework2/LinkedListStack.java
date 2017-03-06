package Homework2;

import java.util.EmptyStackException;

/**
 * Created by Michael on 2/7/2017.
 */
public final class LinkedListStack<T> implements StackInterface<T> {
    private Node head;

    public LinkedListStack() {
        head = null;
    }

    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry An object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.setNext(head);
        head = newNode;

    }

    /**
     * Removes and returns this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            T tempData = peek();
            head = head.getNext();
            return tempData;
        }
    }

    /**
     * Retrieves this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return head.getData();
        }
    }

    /**
     * Detects whether this stack is empty.
     *
     * @return True if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() {
        head = null;
    }


    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
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
    }

}
