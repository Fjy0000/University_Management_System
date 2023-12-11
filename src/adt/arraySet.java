/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.Iterator;


/**
 *
 * @author 60111
 */
public class arraySet<T extends Comparable<T>> implements SetInterface<T>{
    T[] setArray;
    int numberOfElements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;
    
    public arraySet(){
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    public arraySet(int initialCapacity){
        numberOfElements=0;
        setArray = (T[]) new Comparable[initialCapacity];
    }
    
    @Override
    public boolean add(T newEntry){
        for(int i=0; i<numberOfElements; ++i){
            if(setArray[i].equals(newEntry)){
                return false;
            }
        }
        
        if(isArrayFull()){
            doubleArray();
        }
        setArray[numberOfElements] = newEntry;
        numberOfElements++;
        return true;
    }
//    @Override
//    public boolean addAll(SetInterface<T> otherSet) {
//        Iterator<T> iterator = otherSet.getIterator();
//        while (iterator.hasNext()) {
//            add(iterator.next());
//        }
//        return true;
//    }
    

    public boolean isArrayFull(){
        return numberOfElements == setArray.length;
    }
    

    public void doubleArray(){
        T[] oldArray = setArray;
        int oldSize = oldArray.length;
        
        setArray =(T[]) new Object[2 * oldSize];
        for (int index=0; index<oldSize; index++){
            setArray[index] = oldArray[index];
        }
        
    }
    @Override
    public Iterator<T> getIterator(){
        return new IteratorForArraySet();
    }
    
    private class IteratorForArraySet implements Iterator<T>{
        
        private int nextIndex;
        public IteratorForArraySet(){
            nextIndex=0;     
        } 
        
      @Override 
      public boolean hasNext(){
      return nextIndex<numberOfElements;
      }
      
      @Override 
        public T next(){
            if(hasNext()){
            T nextElement = (T) setArray[nextIndex++];
            return nextElement;
            }else{
            return null;
            }
        }
    }
    
    @Override
    public String toString(){
        String outputStr = "";
        for (int i = 0; i<numberOfElements; ++i ){
            outputStr += setArray[i] + "\n";
        }
        return outputStr;
    }

    @Override
    public int getTotalEntries() {
        return numberOfElements;
    }
    @Override
    public boolean contains(T anEntry) {

    int i = 0;
    while (i < numberOfElements && setArray[i].compareTo(anEntry) < 0) {
      i++;
    }// linear search
        if (anEntry.equals(setArray[i])){
            return true;
        }
     return false;
  }
    
    @Override
    public boolean remove(T object) {
        int index = indexOf(object);
        if (index != -1) {
            for (int i = index; i < numberOfElements - 1; i++) {
                setArray[i] = setArray[i + 1];
            }
            setArray[numberOfElements - 1] = null;
            numberOfElements--;
            return true;
        } else {
            return false;
        }

    }

    private int indexOf(T object) {
        for (int i = 0; i < numberOfElements; i++) {
            if (setArray[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public boolean isEmpty(){
        return numberOfElements == 0;
    }
    @Override
    public void union (SetInterface anotherSet){
        if(anotherSet instanceof arraySet){
            arraySet aSet = (arraySet) anotherSet;
            for(int i=0; i<aSet.numberOfElements; ++i){
                add((T) aSet.setArray[i]);
            }
        }
    }
    
}