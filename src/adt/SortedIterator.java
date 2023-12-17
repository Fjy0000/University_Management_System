package adt;

import java.util.Iterator;

/**
 *
 * @author Fong Jun Yi
 */
public interface SortedIterator<T> extends Iterator<T> {

    T sortedNext();
}
