package adt;

/**
 *
 * @author @param <T>
 */
public class Set<T extends Comparable<T>> implements SetInterface<T> {

    T[] setArray;
    T[] sortedSetArray;
    int numberOfElements;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public Set() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public Set(int initialCapacity) {
        numberOfElements = 0;
        setArray = (T[]) new Comparable[initialCapacity];
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

    @Override
    public String toString() {
        String outputStr = "";
        for (int i = 0; i < numberOfElements; ++i) {
            outputStr += setArray[i] + "\n";
        }
        return outputStr;
    }

    @Override
    public SortedIterator<T> getIterator() {
        return new IteratorForArraySet();
    }

    private class IteratorForArraySet implements SortedIterator<T> {

        private int nextIndex;

        public IteratorForArraySet() {
            nextIndex = 0;
        }

        @Override
        // Checks if there are more elements to iterate over.
        public boolean hasNext() {
            return nextIndex < numberOfElements;
        }

        @Override
        public T next() {
            if (hasNext()) {
                // Retrieves the next element in the iteration.
                T nextElement = (T) setArray[nextIndex++];
                // Retrieves the element at the current index and increments the index for the next call.
                return nextElement;
            } else {
                // Returns null if there are no more elements to iterate.
                return null;
            }
        }

        // Custom method for sorted iteration
        @Override
        public T sortedNext() {
            if (hasNext()) {
                T nextElement = (T) sortedSetArray[nextIndex++];
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
                return found = true;
            }
        }
        return found;
    }

    @Override
    public void union(SetInterface anotherSet) { // use for merge two tutorial group student
        // Check if the provided set is an instance of the Set class
        if (anotherSet instanceof Set) {
            // If it is, cast it to a Set
            Set aSet = (Set) anotherSet;
            // Iterate through each element in the 'aSet'
            for (int i = 0; i < aSet.numberOfElements; ++i) {
                // Add each element from 'aSet' to the current set (this set)
                add((T) aSet.setArray[i]);
            }
        }
    }

    @Override
    public boolean selectionSort() {

        //Check Array is empty or not
        if (numberOfElements == 0) {
            return false;
        } else {
            // Create a new array to store the sorted entries
            sortedSetArray = (T[]) new Comparable[numberOfElements];
            for (int i = 0; i < numberOfElements; i++) {
                sortedSetArray[i] = setArray[i];
            }

            for (int i = 0; i < numberOfElements - 1; i++) {
                int minIndex = i; // Save the current object index

                // Compare the sizes one by one. If it is checked that there is a smaller object than the currently indexed object, then save the smaller object index.
                for (int j = i + 1; j < numberOfElements; j++) {
                    if (sortedSetArray[j].compareTo(sortedSetArray[minIndex]) < 0) {
                        minIndex = j;
                    }
                }

                // Swap the found minimum element with the first element
                T object = sortedSetArray[i];
                sortedSetArray[i] = sortedSetArray[minIndex];
                sortedSetArray[minIndex] = object;
            }
            return true;
        }
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
}
