package Homework2;

public class FixedArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

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
        backIndex = (backIndex + 1 ) % queue.length;
        queue[backIndex] = newEntry;
    }

    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = oldSize * 2;
            checkCapacity(newSize);
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

    private void checkCapacity(int newSize) {
        if (newSize > MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a new queue whose capacity exceeds allowed maximum of "+ MAX_CAPACITY);
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
        if (isEmpty()){
           throw new EmptyQueueException();
        } else {
            T temp = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return  temp;
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
        if (isEmpty()){
            throw new EmptyQueueException();
        } else {
            return queue[frontIndex];
        }
    }

    /**
     * Detects whether this queue is empty.
     *
     * @return True if the queue is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    /**
     * Removes all entries from this queue.
     */
    @Override
    public void clear() {
        for (int index = 0; index < queue.length; index++){
            queue[index] = null;
        }
        frontIndex = 0;
        backIndex = queue.length - 1;

    }
}
