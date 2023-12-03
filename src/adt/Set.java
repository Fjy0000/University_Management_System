/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author fongj
 */
public class Set<T> implements SetInterface<T> {
    T[] setArray;
    int numberOfElements;
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

    // Remove object 
    @Override
    public boolean remove(T object) {

        int index = indexOf(object);
        if (index != -1) {

            // Shift elements to fill the gap
            for (int i = index; i < numberOfElements - 1; i++) {
                setArray[i] = setArray[i + 1];
            }

            // Set the last element to null and decrement the size
            setArray[numberOfElements - 1] = null;
            numberOfElements--;
            return true;
        } else {
            return false;
        }

    }

    // Find the index of an object in the array, returns -1 if not found
    private int indexOf(T object) {
        for (int i = 0; i < numberOfElements; i++) {
            if (setArray[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    // Check Array is Full or not
    private boolean isArrayFull() {
        return numberOfElements == setArray.length;
    }

    // Resize the array size
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

}
