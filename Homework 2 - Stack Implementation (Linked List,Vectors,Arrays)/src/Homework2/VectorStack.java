package Homework2;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * Created by Michael on 2/6/2017.
 */
public class VectorStack<T> implements StackInterface<T> {
    private final Vector<T> stack;
    private static final int MAX_CAPACITY = 10000;
    private static final int DEFAULT_CAPACITY = 50;

    public VectorStack() {
        this(DEFAULT_CAPACITY);
    }

    public VectorStack(int initialCapacity) {
        stack = new Vector<>(initialCapacity);
    }


    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry An object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {
        stack.add(newEntry);
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
            return stack.remove(stack.size() - 1);
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
            return stack.lastElement();
        }
    }

    /**
     * Detects whether this stack is empty.
     *
     * @return True if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() {
        stack.clear();
    }
}
