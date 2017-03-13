package Final;

import java.util.NoSuchElementException;

/**
 * Created by Michael on 3/10/2017.
 */
public class MyIterator<T> implements IteratorInterface {
    private ListInterface<T> list;
    private int nextPosition;
    private boolean wasNextCalled;

    public MyIterator(ListInterface<T> newList){
        list = newList;
        nextPosition = 0;
        wasNextCalled = false;
    }

    @Override
    public boolean hasNext() {
        return nextPosition < list.getLength(); // get length returns the number of entries in the list
    }

    @Override
    public T next() {
        if (hasNext()){
            wasNextCalled = true;
            nextPosition++;
            return list.getEntry(nextPosition);
        }
        else{
            throw new NoSuchElementException("iterator is after end of list");
        }
    }

    @Override
    public void remove() {
        if (wasNextCalled){ // checks in case we try to do a remove to a entry that is not in the list aka 0
            list.remove(nextPosition);
            nextPosition--;
            wasNextCalled = false;
        }
        else{
            throw new IllegalStateException("Next() was not called");
        }
    }

}
