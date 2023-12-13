package adt;

import java.util.Iterator;

/**
 *
 * @author 
 */
public interface SetInterface<T> {

    public boolean add(T newElement);

    public boolean remove(T newElement);

    public boolean contains(T anEntry);

    public Iterator<T> getIterator();

    public boolean isEmpty();

    public void union(SetInterface anotherSet);

    public boolean replace(T newObject, int position);

    public int getSize();

    //    public boolean addAll(SetInterface<T> otherSet);
    //    public int getTotalEntries();
}
