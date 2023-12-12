/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author 60111
 */
public interface SetInterface<T> {
    public boolean add(T newElement);
//    public boolean addAll(SetInterface<T> otherSet);
    public boolean remove(T newElement);
    public boolean contains(T anEntry);
    public Iterator<T> getIterator();
//    public int getTotalEntries();
    public boolean isEmpty();
    public void union(SetInterface anotherSet);
    
//    public boolean add(T newElement);
    public boolean update(T newObject, int position);
//    public boolean remove(T newElement);
    public T getElements(int position);
    public int getSize();
//    public boolean isEmpty();
}
