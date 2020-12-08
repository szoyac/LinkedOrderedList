/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk15.pkg10.jsjf.exceptions;
/**
 * NonComparableElementException  represents the situation in which an attempt 
 * is made to add an element that is not comparable to an ordered collection
 *
 * @author Java Foundations
 * @version 4.0
 */
public class NonComparableElementException extends RuntimeException
{
	/**
	 * Sets up this exception with an appropriate message.
	 * 
	 * @param collection  the exception message to deliver
	 */
	public NonComparableElementException (String collection)
	{
		super ("The " + collection + " requires Comparable elements.");
	}

}
