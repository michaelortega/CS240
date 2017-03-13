package Final;

/**
 * Created by Michael on 3/10/2017.
 */
public interface IteratorInterface<T> {

    public boolean hasNext();
    public T next();
    public void remove();
}
