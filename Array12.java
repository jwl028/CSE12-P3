/**
 * @author Jimmy Li cs12sdm
 *
 * An Array12 is a sequential structure with restricted access and
 * limited capacity.
 * <p>
 * Access is available only at the ends of the structure:
 * <tt>addFront(E)</tt>, <tt>E removeFront()</tt>, and <tt>E peekFront()</tt>
 * operate on the front of the list; 
 * <tt>addBack(E)</tt>, <tt>E removeBack()</tt>, and <tt>E peekBack()</tt>
 * operate on the back of the list.
 * <p>
 * (A sequential structure which, like Array12, permits access
 * and modification only at the ends is sometimes called a "deque",
 * pronounced "deck", which is short for "double-ended queue.")
 * <p>
 */

public class Array12<E> implements LimCapList<E>
{
  
  private int size;
  private int capacity;
  private int front;
  private int rear;
  private E[] array;  

  /**
   * Constructor for Array12 with a passed in capacity.
   *
   */

  public Array12(int capacity)
  {
    if(capacity < 0) {
      throw new IllegalArgumentException();
    }
    //Create array object
    array = (E[]) new Object[capacity];
    //Initialize variables
    size = 0;
    front = capacity-1;
    rear = 0;
    this.capacity = capacity;
  } 

  /**
   * Returns the capacity of this Array12, that is,
   * the maximum number of elements it can hold.  
   * <br>PRECONDITION: none 
   * <br>POSTCONDITION: the Array12 is unchanged.  
   * @return the capacity of this Array12 
   */

  public int capacity() 
  {
    return capacity;
  }

  /**
   * Returns the number of elements in this Array12. 
   * <br>PRECONDITION: none 
   * <br>POSTCONDITION: the Array12 is unchanged. 
   * @return the number of elements in this Array12 
   */ 

  public int size()
  {
    return size;
  }
  
  /**
   * Adds the specified element to the front of this Array12.
   * Returns true if the operation succeeded, else false. 
   * <br>PRECONDITION: the Array12's size is less than its capacity. 
   * <br>POSTCONDITION: the element is now the first element in this 
   * Array12, none of the other elements have been changed, and
   * the size is increased by 1. 
   * @param e the element to add to the front of the list
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */

  public boolean addFront(E e)
  {
    if(size >= capacity) {
      return false;
    }
    else {
      if(e == null) {
        throw new NullPointerException();
      }
      //set front to element
      array[front] = e;
      //decrement front
      front = (front-1+capacity)%capacity;
      size++;
      return true;
    }
  }

  /**
   * Adds the specified element to the back of this Array12.
   * Returns true if the operation succeeded, else false. 
   * <br>PRECONDITION: the Array12's size is less than its capacity. 
   * <br>POSTCONDITION: the element is now the last element in this 
   * Array12, none of the other elements have been changed, and
   * the size is increased by 1. 
   * @param e the element to add to the back of the list
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */

  public boolean addBack(E e)
  { 
    if(size >= capacity) {
      return false;
    }
    else {
      if(e == null) {
        throw new NullPointerException();
      }
      //set rear to element
      array[rear] = e;
      //increment rear
      rear = (rear+1)%capacity;
      size++;
      return true;
    }
  }

   /**
   * Removes the element at the front of this Array12.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Array12's size is greater than zero.
   * <br>POSTCONDITION: the first element in this Array12 has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */

  public E removeFront()
  {
    if(size <= 0) {
      return null;
    }
    else {
      //increment front
      front = (front+1)%capacity;
      size--;
      return array[front];
    }
  }

  /**
   * Removes the element at the back of this Array12.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Array12's size is greater than zero.
   * <br>POSTCONDITION: the last element in this Array12 has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */

  public E removeBack()
  {
    if(size <= 0) {
      return null;
    }
    else {
      //decrement rear
      rear = (rear-1+capacity)%capacity;
      size--;
      return array[rear];
    }
  }
  
  /**
   * Returns the element at the front of this Array12,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Array12's size is greater than zero.
   * <br>POSTCONDITION: The Array12 is unchanged.
   * @return  the element at the front, or <tt>null</tt> if the size was zero.
   */

  public E peekFront()
  {
    if(size <= 0) {
      return null;
    }
    else {
      return array[(front+1)%capacity];
    }
  }
  /**
   * Returns the element at the back of this Array12,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Array12's size is greater than zero.
   * <br>POSTCONDITION: The Array12 is unchanged.
   * @return  the element at the back, or <tt>null</tt> if the size was zero.
   */
  public E peekBack()
  {
    if(size <= 0) {
      return null;
    }
    else {
      return array[(rear-1+capacity)%capacity];
    }
  }

  /**
   * Compares the specified object with this Array12 for equality.
   * Returns true if and only if the specified object is
   * also a Array12 of the same type, both have the same size, and the
   * corresponding pairs of elements in the two are
   * equal. Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of front elements,
   * the pair of next-to-front elements, and so on through to
   * the pair of back elements.
   * @return true if the specified Object is equal to this Array12 
   * @param  o the Object to compare to this Array12 for equality
   *
   */ 

  public boolean equals(Object o)
  {
    if(!(o instanceof Array12)) {
      return false;
    }
    else {
    int frontCopy = front;
      //Make sure sizes of both objects are equal
      if(((Array12)o).size() == this.size()) {
        //Compares object elements to array elements
        for(int i = 0; i < ((Array12)o).size(); i++) {
          frontCopy = (frontCopy+1)%capacity;
          if(!(((Array12)o).peekFront().equals(array[frontCopy]))) {
            return false;
          }
          ((Array12)o).removeFront();
        }
      return true;
      }
    return false;
    }  
  }

}

