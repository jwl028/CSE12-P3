import junit.framework.*;
import java.util.*;

/**
 * @author Jimmy Li cs12sdm
 *
 * This class tests LimCapList for properly functionality
 */

public class LimCapListTester extends junit.framework.TestCase
{

  private LimCapList<String> strList, strList2;
  private LimCapList<Integer> intList;
  
  /**
   * This method allows the tester to run in a graphical interface of Junit.
   */

  public static void main(String args[])
  {
    junit.swingui.TestRunner.main(new String[] {"LimCapListTester"});
  }
 
  /**
   * This method checks the capacity of the list when unmodified
   */

  public void testCapacityUnChanged()
  {
    assertTrue(strList.capacity() == 10000);
  }

  /**
   * This method checks that capacity does not change when elements are added
   * on to the list.
   */ 
 
  public void testAddCapacity()
  {
    strList.addFront("A");
    strList.addFront("B");
    assertTrue(strList.capacity() == 10000);
    strList2.addFront("A");
    strList2.addFront("B");
    assertTrue(strList.equals(strList2));
  }

  /**
   * This method checks that size does not change when elements are added
   * on to the list.
   */
 
  public void testSize()
  {
    assertTrue(strList.size() == 0);
    strList.addFront("A");
    strList.addFront("B");
    assertTrue(strList.size() == 2);
    strList2.addFront("A");
    strList2.addFront("B");
    assertTrue(strList.equals(strList2));
  }

 /**
   * This method checks to make sure that the correct elements are being added
   * to the front and also that the size is being incremented correctly
   */

  public void testAddFront()
  {
    for(int n = 1; n <= 10000; n++) {
      assertTrue(intList.addFront(new Integer(n)));
      assertTrue(intList.size() == n);
      assertTrue(intList.peekFront() == n);
      assertTrue(intList.peekBack() == 1);
    }
    assertFalse(intList.addFront(new Integer(1)));    
  }

  /**
   * This method checks that null elements are not permitted to be added from
   * the front.
   */

  public void testAddFrontNull()
  {
    for(int n = 1; n <= 5000; n++) {
      intList.addFront(new Integer(n));
    }
    try {
      intList.addFront(null);
      fail();
    }
    catch(NullPointerException e) {
      assertTrue(true);
    }
  }

  /**
   * This method checks to make sure that the correct elements are being added
   * to the back and also that the size is being incremented correctly
   */
  public void testAddBack()
  {
    for(int n = 1; n <= 10000; n++) {
      assertTrue(intList.addBack(new Integer(n)));
      assertTrue(intList.size() == n);
      assertTrue(intList.peekBack() == n);
      assertTrue(intList.peekFront() == 1);
    }
    assertFalse(intList.addBack(new Integer(1)));    
  }

  /**
   * This method checks that null elements are not permitted to be added from
   * the front.
   */

  public void testAddBackNull()
  {
    for(int n = 1; n <= 5000; n++) {
      intList.addBack(new Integer(n));
    }
    try {
      intList.addBack(null);
      fail();
    }
    catch(NullPointerException e) {
      assertTrue(true);
    }
  }

  /**
   * This method checks peekFront() and removeFront() return the correct 
   * values. 
   */

  public void testRemoveFrontPeekFront()
  {
    for(int n = 1; n <= 10000; n++) {
      intList.addFront(new Integer(n));
    }
    for(int n = 10000; n >= 1; n--) {
      assertTrue(intList.peekFront() == n);
      assertTrue(intList.size() == n);
      assertEquals(intList.removeFront(), new Integer(n));
    }
    assertTrue(intList.peekFront() == null);
    assertTrue(intList.size() == 0);
    assertTrue(intList.removeFront() == null);   
  }
 
  /**
   * This method checks peekBack() and removeBack() return the correct values. 
   */

  public void testRemoveBackPeekBack()
  {
    for(int n = 1; n <= 10000; n++) {
      intList.addBack(new Integer(n));
    }
    for(int n = 10000; n >= 1; n--) {
      assertTrue(intList.peekBack() == n);
      assertTrue(intList.size() == n);
      assertEquals(intList.removeBack(), new Integer(n));
    }
    assertTrue(intList.peekBack() == null);
    assertTrue(intList.size() == 0);
    assertTrue(intList.removeBack() == null);   
  }
   /**
   * This method checks peekFront() and removeBack() return the correct values. 
   */

  public void testRemoveBackPeekFront()
  {
    for(int n = 1; n <= 10000; n++) {
      intList.addBack(new Integer(n));
    }
    for(int n = 10000; n >= 1; n--) {
      assertTrue(intList.peekFront() == 1);
      assertTrue(intList.size() == n);
      assertEquals(intList.removeBack(), new Integer(n));
    }
    assertTrue(intList.peekFront() == null);
    assertTrue(intList.size() == 0);
    assertTrue(intList.removeBack() == null);   
  } 

  /**
   * This method checks peekBack() and removeFront() return the correct values. 
   */

  public void testRemoveFrontPeekBack()
  {
    for(int n = 1; n <= 10000; n++) {
      intList.addFront(new Integer(n));
    }
    for(int n = 10000; n >= 1; n--) {
      assertTrue(intList.peekBack() == 1);
      assertTrue(intList.size() == n);
      assertEquals(intList.removeFront(), new Integer(n));
    }
    assertTrue(intList.peekBack() == null);
    assertTrue(intList.size() == 0);
    assertTrue(intList.removeFront() == null);   
  }
  
  /**
   * This method checks that the equals method satisfy:
   * 1. Both lists are of the same type
   * 2. Both lists are of the same size
   * 3. Both lists contain the same pairs of elements.
   */

  public void testEquals()
  {
    LimCapList<String> strList3 = new Array12<String>(10000);
    //Empty lists are all equal regardless of type
    assertTrue(strList.equals(strList2));
    assertTrue(strList.equals(intList));
    for(int n = 1; n <= 10000; n++) {
      strList.addFront("A"); 
      strList2.addFront("A");
      strList3.addFront("A");
    }
    assertTrue(strList.equals(strList2));
    strList2.removeFront();
    assertFalse(strList.equals(strList2));
    //Lists with different capacities can be equal if they both contain the
    //same size
    LimCapList<Integer> intList2 = new Array12<Integer>(5000);
    for(int i = 1; i <= 5000; i++) {
      intList.addFront(i);
      intList2.addFront(i);
    }
    assertTrue(intList.equals(intList2));
    assertFalse(intList.equals(strList));
    //Checks that the equals method does not modify the list
    assertTrue(strList.equals(strList3));
  }

  /**
   * This method initializes the variables prior to each test.
   */

  protected void setUp()
  {
    strList = new Array12<String>(10000);
    strList2 = new Array12<String>(10000);
    intList = new Array12<Integer>(10000);
  }
 
  /**
   * This method sets the variables to null after each test.
   */

  protected void tearDown()
  {
    strList = null;
    intList = null;
  }

}
