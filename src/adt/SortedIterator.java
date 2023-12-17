package adt;


import java.util.Iterator;

/**
 *
 * @author fongj
 */
public interface SortedIterator<T> extends Iterator<T> {

    T sortedNext();
}