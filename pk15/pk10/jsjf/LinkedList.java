/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk15.pk10.jsjf;

import pk15.pkg10.jsjf.exceptions.EmptyCollectionException;
import pk15.pkg10.jsjf.exceptions.ElementNotFoundException;
import java.util.*;

/**
 * LinkedList represents a linked implementation of a list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public abstract class LinkedList<T> implements ListADT<T>, Iterable<T> {

    protected int count;
    protected LinearNode<T> head, tail;
    protected int modCount;

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        count = 0;
        head = tail = null;
        modCount = 0;
    }

    /**
     * Removes the first element in this list and returns a reference to it.
     * Throws an EmptyCollectionException if the list is empty.
     *
     * @return a reference to the first element of this list
     * @throws EmptyCollectionException if the list is empty
     */
    public T removeFirst() throws EmptyCollectionException {
        LinearNode<T> currentHead = head;

        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedList");
        }

        head = currentHead.getNext();
        count--;
        modCount++;

        return currentHead.getElement();
    }

    /**
     * Removes the last element in this list and returns a reference to it.
     * Throws an EmptyCollectionException if the list is empty.
     *
     * @return the last element in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public T removeLast() throws EmptyCollectionException {
        LinearNode<T> tempHead = head;
        LinearNode<T> oldTail = null;

        
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedList");
        }

        while (tempHead != null) {
            
                oldTail = tempHead;
                tempHead = tempHead.getNext();
                
            }
     
    
       
        tail = oldTail;
        tail.setNext(null);
        count--;
        modCount++;

        return tail.getElement();
    }

    /**
     * Removes the first instance of the specified element from this list and
     * returns a reference to it. Throws an EmptyCollectionException if the list
     * is empty. Throws a ElementNotFoundException if the specified element is
     * not found in the list.
     *
     * @param targetElement the element to be removed from the list
     * @return a reference to the removed element
     * @throws EmptyCollectionException if the list is empty
     * @throws ElementNotFoundException if the target element is not found
     */
    public T remove(T targetElement) throws EmptyCollectionException,
            ElementNotFoundException {
        if (isEmpty()) {
            try{
            throw new EmptyCollectionException("LinkedList");
            }catch(EmptyCollectionException e){
                System.out.println(e);
                return null;
            }
        }

        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current != null && !found) {
            if (targetElement.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            try{
            throw new ElementNotFoundException("LinkedList");
            }catch(ElementNotFoundException e){
                System.out.println(e);
                return null;
            }
        }

        if (size() == 1) // only one element in the list
        {
            head = tail = null;
        } else if (current.equals(head)) // target is at the head 
        {
            head = current.getNext();
        } else if (current.equals(tail)) // target is at the tail
        {
            tail = previous;
            tail.setNext(null);
        } else // target is in the middle
        {
            previous.setNext(current.getNext());
        }

        count--;
        modCount++;

        return current.getElement();
    }

    /**
     * Returns the first element in this list without removing it.
     *
     * @return the first element in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            try{
            throw new EmptyCollectionException("LinkedList");
            }catch(EmptyCollectionException e){
                System.out.println(e);
                return null;
            }
        }

        return head.getElement();
    }

    /**
     * Returns the last element in this list without removing it.
     *
     * @return the last element in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedList");
        }

        return tail.getElement();
    }

    /**
     * Returns true if the specified element is found in this list and false
     * otherwise. Throws an EmptyCollectionException if the list is empty.
     *
     * @param targetElement the element that is sought in the list
     * @return true if the element is found in this list
     * @throws EmptyCollectionException if the list is empty
     */
    public boolean contains(T targetElement) throws EmptyCollectionException {
        String specified = "";
        LinearNode<T> element = head;
        for (int i = 0; i < count; i++) {
            specified += element.getElement();
            if (specified.equals(targetElement)) {
                return true;
            }
            element = element.getNext();
        }

        return false;
    }

    /**
     * Returns true if this list is empty and false otherwise.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }

        return false;  // temp
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in the list
     */
    public int size() {

        return count;  // temp
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of the list
     */
    public String toString() {
        if (isEmpty()) {
            try {
                throw new EmptyCollectionException("queue");
            } catch (EmptyCollectionException e) {
                return e.toString() + "\n";
            }
        }

        String strlol = "";
        LinearNode<T> strElement = head;

        for (int i = 0; i < count; i++) {
          

                strlol += i+1 +". " + strElement.getElement() + "\n";
                strElement = strElement.getNext();

            
        }
        return strlol;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements of the list
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * LinkedIterator represents an iterator for a linked list of linear nodes.
     */
    private class LinkedListIterator implements Iterator<T> {

        private int iteratorModCount;  // the number of elements in the collection
        private LinearNode<T> current;  // the current position

        /**
         * Sets up this iterator using the specified items.
         *
         * @param collection the collection the iterator will move over
         * @param size the integer size of the collection
         */
        public LinkedListIterator() {
            current = head;
            iteratorModCount = modCount;
        }

        /**
         * Returns true if this iterator has at least one more element to
         * deliver in the iteration.
         *
         * @return true if this iterator has at least one more element to
         * deliver in the iteration
         * @throws ConcurrentModificationException if the collection has changed
         * while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException {
            if (iteratorModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            return (current != null);
        }

        /**
         * Returns the next element in the iteration. If there are no more
         * elements in this iteration, a NoSuchElementException is thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws ConcurrentModificationException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T result = current.getElement();
            current = current.getNext();
            return result;
        }

        /**
         * The remove operation is not supported.
         *
         * @throws UnsupportedOperationException if the remove operation is
         * called
         */
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }

}
