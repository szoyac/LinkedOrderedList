/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk15.pk10.jsjf;

import java.util.Iterator;
import pk15.pkg10.jsjf.exceptions.EmptyCollectionException;
import pk15.pkg10.jsjf.exceptions.ElementNotFoundException;
import pk15.pkg10.jsjf.exceptions.NonComparableElementException;

/**
 * LinkedOrderedList represents a singly linked implementation of an ordered
 * list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedOrderedList<T> extends LinkedList<T>
        implements OrderedListADT<T> {

    /**
     * Creates an empty list.
     */
    public LinkedOrderedList() {
        super();
    }

    /**
     * Adds the specified element to this list at the location determined by the
     * element's natural ordering. Throws a NonComparableElementException if the
     * element is not comparable.
     *
     * @param element the element to be added to this list
     * @throws NonComparableElementException if the element is not comparable
     */
    public void add(T element) throws NonComparableElementException {
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("LinkedOrderList");
        }

        Comparable<T> comparableElement = (Comparable<T>) element;

        LinearNode<T> current = head;
        LinearNode<T> previous = null;
        LinearNode<T> newNode = new LinearNode<T>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (comparableElement.compareTo(head.getElement()) <= 0) {
            previous = head;
            head = newNode; 
            head.setNext(previous); //All good, don't touch!
  
        } else if ((comparableElement.compareTo(head.getElement()) >= 0) &&
                head == tail){
          tail = newNode;
          head.setNext(tail);
        }  
        else if (comparableElement.compareTo(tail.getElement()) >= 0){
            previous = tail;
            tail = newNode;
            previous.setNext(tail);
        } else{
        int value;
          LinearNode<T> currentBefore = current;
       for(int i = 0; i < count; i++){
       
       value = comparableElement.compareTo(current.getElement());
      
        if (value <= 0)
        {
            previous = current;
            current = newNode;
            currentBefore.setNext(current);
           current.setNext(previous);
           
           break;
        }
        currentBefore = current;
       current = current.getNext();
       previous = tail;
       
       }
        }
        
        count++;
        modCount++;
    }

}
