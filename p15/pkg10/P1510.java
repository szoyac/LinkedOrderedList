
package p15.pkg10;

import java.util.Scanner;
import pk15.pk10.jsjf.LinkedOrderedList;
/**
 *@author Stephen Zoyac
 * @Date: 10/18/20
 * Fall 2020
 * Project 15.10
 * This program runs a menu for a LinkedOrderedList, which implements the 
 * ListADT, and extends the LinkedList class. The menu has 5 options, 
 * 1 to add an element to the list, 2 to remove a specific element on the list
 * 3 to see the first element in the list, 4 to list all the elements of the 
 * list, and 5 to close the program. The LinkedList follows the protocol of an
 * ordered list, meaning each element added to the list will be added based on
 * alphabetical order. This is done with the use of Comparable to compare each 
 * element. Any errors of this program will be caught, and the program will 
 * continue.
 */

public class P1510 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedOrderedList<String> lol = new LinkedOrderedList<>(); //list
        int menu = 0;
        

        do {//menu
            System.out.println("List Menu Selections\n1.add element "
                    + "\n2.remove element \n3.head element \n4.display \n5.Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            menu = Integer.parseInt(input.next());
            switch (menu) {
                case 1:
                    System.out.print("Enter element: ");
                    String element = input.next();
                    lol.add(element);
                    break;

                case 2:

                    System.out.print("Enter the specific element: ");
                    element = input.next();
                    String removeE = lol.remove(element);
                    System.out.println(removeE + " element removed");
                    break;

                case 3:
                    System.out.println("Element @ head: " + lol.first());
                    break;

                case 4:
                    System.out.println(lol.toString()); //in numeric order
                    break;

                case 5:
                    System.exit(0); //end
                    break;
            }
        } while (menu <= 5);
    }

}
