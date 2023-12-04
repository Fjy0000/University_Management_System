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
public class arraySet<T> implements SetInterface<T>{
    T[] setArray;
    int numberOfElements;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;
    
    public arraySet(){
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    public arraySet(int initialCapacity){
        numberOfElements=0;
        setArray = (T[]) new Object[initialCapacity];
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
      boolean found = false;
      for (int index = 0; !found && (index < numberOfElements); index++) {
        if (anEntry.equals(setArray[index])) {
          found = true;
        }
      }
      return found;
    }
}
