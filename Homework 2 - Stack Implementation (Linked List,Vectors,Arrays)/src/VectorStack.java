import java.util.Vector;

/**
 * Created by Michael on 2/6/2017.
 */
public class VectorStack<T> implements StackInterface<T> {
    private final Vector<T> stack;

    public VectorStack() {
        stack = null;
    }

    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry An object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {

    }

    /**
     * Removes and returns this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty before the operation.
     */
    @Override
    public T pop() {
        return null;
    }

    /**
     * Retrieves this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T peek() {
        return null;
    }

    /**
     * Detects whether this stack is empty.
     *
     * @return True if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() {

    }
}
