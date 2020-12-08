/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk15.pkg10.jsjf.exceptions;
/**
 * ElementNotFoundException represents the situation in which a target element 
 * is not present in a collection
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ElementNotFoundException extends RuntimeException
{
	/**
	 * Sets up this exception with an appropriate message.
	 */
	public ElementNotFoundException (String collection)
	{
		super ("The target element is not in this " + collection);
	}
}