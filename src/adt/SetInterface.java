/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author fongj
 */
public interface SetInterface<T> {
    public boolean add(T newElement);
    public boolean contains(T anEntry);
    public Iterator<T> getIterator();
    public int getTotalEntries();
}
