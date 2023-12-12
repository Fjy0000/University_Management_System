/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author fongj
 */
public interface SetInterface<T> {

    public boolean add(T newElement);

    public boolean update(T newObject, int position);

    public boolean remove(T newElement);

    public Iterator<T> getIterator();

    public int getSize();

    public boolean isEmpty();
}
