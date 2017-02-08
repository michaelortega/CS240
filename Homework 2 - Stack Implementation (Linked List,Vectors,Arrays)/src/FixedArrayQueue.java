import java.util.Queue;

/**
 * Created by Michael on 2/7/2017.
 */
public class FixedArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 50;

    public FixedArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    public FixedArrayQueue(int initialCapacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[initialCapacity + 1];
        queue = temp;
        frontIndex = 0;
        backIndex = initialCapacity;
    }

    /**
     * Adds a new entry to the back of this queue.
     *
     * @param newEntry An object to be added.
     */
    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();


    }

    private void ensureCapacity() {
        
    }

    /**
     * Removes and returns the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    @Override
    public T dequeue() {
        return null;
    }

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    @Override
    public T getFront() {
        return null;
    }

    /**
     * Detects whether this queue is empty.
     *
     * @return True if the queue is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Removes all entries from this queue.
     */
    @Override
    public void clear() {

    }
}
