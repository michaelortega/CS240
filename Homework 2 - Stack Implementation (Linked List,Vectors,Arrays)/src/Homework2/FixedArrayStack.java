package Homework2;

import java.util.EmptyStackException;

public final class FixedArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private final int MAX_CAPACITY = 10;

    public FixedArrayStack() {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[MAX_CAPACITY];
        stack = tempStack;
        topIndex = -1;

    }


    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry An object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {
        if (topIndex < MAX_CAPACITY) {
            stack[++topIndex] = newEntry;
        }

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

            T temp = stack[topIndex];
            stack[topIndex--] = null;
            return temp;
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
            return stack[topIndex];
        }
    }

    /**
     * Detects whether this stack is empty.
     *
     * @return True if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() {
        for (int index = 0; index < stack.length; index++) {
            stack[index] = null;
        }
        topIndex = -1;
    }
}
