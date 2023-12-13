package adt;

import java.util.Iterator;

/**
 *
 * @author 
 */
public class Set<T> implements SetInterface<T> {

    T[] setArray;
    int numberOfElements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public Set() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public Set(int initialCapacity) {
        numberOfElements = 0;
        setArray = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T newEntry) {
        for (int i = 0; i < numberOfElements; ++i) {
            if (setArray[i].equals(newEntry)) {
                return false;
            }
        }

        if (isArrayFull()) {
            doubleArray();
        }
        setArray[numberOfElements] = newEntry;
        numberOfElements++;
        return true;
    }

    public boolean replace(T newObject, int position) {
        if (position >= 0 && position <= numberOfElements) {
            setArray[position - 1] = newObject;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(T object) {
        int index = getElementIndex(object);
        if (index != -1) {
            // Shift elements to fill the gap
            for (int i = index; i < numberOfElements; i++) {
                setArray[i] = setArray[i + 1];
            }
            numberOfElements--;
            return true;
        } else {
            return false;
        }

    }

    public int getSize() {
        return numberOfElements;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    private int getElementIndex(T object) {
        for (int i = 0; i < numberOfElements; i++) {
            if (setArray[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isArrayFull() {
        return numberOfElements == setArray.length;
    }

    private void doubleArray() {
        T[] oldArray = setArray;

        setArray = (T[]) new Object[2 * oldArray.length];
        for (int index = 0; index < oldArray.length; index++) {
            setArray[index] = oldArray[index];
        }

    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int i = 0; i < numberOfElements; ++i) {
            outputStr += setArray[i] + "\n";
        }
        return outputStr;
    }

    @Override
    public Iterator<T> getIterator() {
        return new IteratorForArraySet();
    }

    private class IteratorForArraySet implements Iterator<T> {

        private int nextIndex;

        public IteratorForArraySet() {
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < numberOfElements;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T nextElement = (T) setArray[nextIndex++];
                return nextElement;
            } else {
                return null;
            }
        }
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; index < numberOfElements; index++) {
            if (anEntry.equals(setArray[index])) {
                found = true;
                break; // exit the loop since the target is found
            }
        }
        return found;
    }

    @Override
    public void union(SetInterface anotherSet) {
        if (anotherSet instanceof Set) {
            Set aSet = (Set) anotherSet;
            for (int i = 0; i < aSet.numberOfElements; ++i) {
                add((T) aSet.setArray[i]);
            }
        }
    }

}
