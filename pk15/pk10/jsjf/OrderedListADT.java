/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk15.pk10.jsjf;
/**
 * OrderedListADT defines the interface to an ordered list collection. Only
 * Comparable elements are stored, kept in the order determined by
 * the inherent relationship among the elements.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface OrderedListADT<T> extends ListADT<T>
{
	/**
	 * Adds the specified element to this list at the proper location
	 *
	 * @param element the element to be added to this list
	 */
	public void add(T element);

}
