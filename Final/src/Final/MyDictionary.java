package Final;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyDictionary<K, V> implements DictionaryInterface<K, V> {
    private KeyNode keyHead;
    private int numberOfKeys;



    public MyDictionary() {
        keyHead = null;
        numberOfKeys = 0;
    }

    /**
     * Adds a new entry to this dictionary. If the given search key already
     * exists in the dictionary, replaces the corresponding value.
     *
     * @param key   An object search key of the new entry.
     * @param value An object associated with the search key.
     * @return Either null if the new entry was added to the dictionary
     * or the value that was associated with key if that value
     * was replaced.
     */
    @Override
    public V add(K key, V value) {
        LinkedList<V> newValueList = new LinkedList<>();
        newValueList.add(value);
        KeyNode newKeyNode = new KeyNode(key, newValueList);
        if (isEmpty()) { // list is empty
            keyHead = newKeyNode;
            numberOfKeys++;
        } else if (!contains(key)) { // if there is no existing key
            KeyNode lastNode = getLastKeyNode();
            lastNode.setNextNode(newKeyNode);
            numberOfKeys++;
        } else {
            KeyNode currentKey = getKeyNodeAt(key);
            currentKey.addValue(value);
        }
        return value;

    }

    private KeyNode getNodeBefore(K key) {
        KeyNode currentNode = keyHead;
        KeyNode nodeBefore = null;
        while (currentNode != null && !key.equals(currentNode.getKey())) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return nodeBefore;
    }

    private KeyNode getKeyNodeAt(K key) {
        if (numberOfKeys == 1 || key.equals(keyHead.getKey())) {
            return keyHead;
        } else {
            return getNodeBefore(key).getNextNode();
        }
    }

    /**
     * Removes a specific entry from this dictionary.
     *
     * @param key An object search key of the entry to be removed.
     * @return Either the value that was associated with the search key
     * or null if no such object exists.
     */
    @Override
    public V[] remove(K key) {
        if (contains(key)) {
            KeyNode keyToRemove = getKeyNodeAt(key);

            V[] values = keyToRemove.getValuesList().toArray();
            keyToRemove.getValuesList().clear();

            if (keyToRemove.getKey().equals(keyHead.getKey())) {
                keyHead = keyHead.getNextNode();
                keyToRemove.setNextNode(null);
            } else {
                KeyNode nodeBefore = getNodeBefore(key);
                nodeBefore.setNextNode(keyToRemove.getNextNode());
                keyToRemove.setNextNode(null);
            }
            numberOfKeys--;
            return values;
        }
        return null;
    }

    /**
     * Retrieves from this dictionary the value associated with a given
     * search key.
     *
     * @param key An object search key of the entry to be retrieved.
     * @return Either the value that is associated with the search key
     * or null if no such object exists.
     */
    @Override
    public V[] getValue(K key) {
        if (contains(key)) {
            KeyNode keyNode;
            if (key.equals(keyHead.getKey())) {
                keyNode = keyHead;
            } else {
                keyNode = getKeyNodeAt(key);
            }

            V[] values = keyNode.getValuesList().toArray();
            return values;
        } else {
            return null;
        }
    }

    /**
     * Sees whether a specific entry is in this dictionary.
     *
     * @param key An object search key of the desired entry.
     * @return True if key is associated with an entry in the dictionary.
     */
    @Override
    public boolean contains(K key) {
        KeyNode currentKey = keyHead;
        boolean found = false;
        while (currentKey != null && !found) {
            if (currentKey.getKey().equals(key)) {
                found = true;
            } else {
                currentKey = currentKey.getNextNode();
            }
        }
        return found;
    }

    /**
     * Creates an iterator that traverses all search keys in this dictionary.
     *
     * @return An iterator that provides sequential access to the search
     * keys in the dictionary.
     */
    @Override
    public Iterator<K> getKeyIterator() {
        return new KeyIterator();
    }

    /**
     * Creates an iterator that traverses all values in this dictionary.
     *
     * @return An iterator that provides sequential access to the values
     * in this dictionary.
     */
    @Override
    public Iterator<V> getValueIterator(ListInterface<V> list) {
        return new ValueIterator(list);
    }

    /**
     * Sees whether this dictionary is empty.
     *
     * @return True if the dictionary is empty.
     */
    @Override
    public boolean isEmpty() {
        return getSize() < 1;
    }

    /**
     * Gets the size of this dictionary.
     *
     * @return The number of entries (key-value pairs) currently
     * in the dictionary.
     */
    @Override
    public int getSize() {
        return numberOfKeys;
    }

    /**
     * Removes all entries from this dictionary.
     */
    @Override
    public void clear() {
        Iterator kIterator = getKeyIterator();
        KeyNode currentKey = keyHead;
        while (kIterator.hasNext()) {
            currentKey.getValuesList().clear();
            currentKey = currentKey.getNextNode();
        }
        keyHead = null;
    }


    public KeyNode getLastKeyNode() {
        KeyNode prevNode = keyHead;
        KeyNode currentNode = keyHead;
        while (currentNode != null) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return prevNode;
    }

    public void displayValues(K key) { // for testing
        KeyNode keyNode = getKeyNodeAt(key);
        Iterator vIterator = getValueIterator(keyNode.getValuesList());
        while (vIterator.hasNext()) {
            System.out.print(vIterator.next() + " ");
        }
    }

    private class KeyIterator implements Iterator<K> {
        private KeyNode nextNode;

        public KeyIterator() {
            nextNode = keyHead;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public K next() {
            K result;
            if (hasNext()) {
                result = nextNode.getKey();
                nextNode = nextNode.getNextNode();
            } else {
                throw new NoSuchElementException();
            }
            return result;
        }


    }

    private class ValueIterator implements Iterator<V> {
        private ListInterface<V> valueList;
        private int nextPosition;
        private boolean wasNextCalled;

        public ValueIterator(ListInterface<V> list) {
            valueList = list;
            nextPosition = 0;
            wasNextCalled = false;
        }

        @Override
        public boolean hasNext() {
            return nextPosition < valueList.getLength();
        }

        @Override
        public V next() {
            if (hasNext()) {
                wasNextCalled = true;
                nextPosition++;
                return valueList.getEntry(nextPosition);
            } else {
                throw new NoSuchElementException("iterator is after end of list");
            }
        }
    }

    private class KeyNode {
        private K key;
        private KeyNode nextKeyNode;
        private LinkedList<V> values;

        public KeyNode(K key, LinkedList<V> newValue) {
            this.key = key;
            this.nextKeyNode = null;
            values = newValue;
        }


        public KeyNode getNextNode() {
            return nextKeyNode;
        }

        public K getKey() {
            return key;
        }

        public void setNextNode(KeyNode nextNode) {
            this.nextKeyNode = nextNode;
        }

        public void addValue(V value) {
            values.add(value);
        }

        public LinkedList<V> getValuesList() {
            return values;
        }
    }

}
