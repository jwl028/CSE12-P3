/**
 * @author Jimmy Li cs12sdm
 *
 * An Queue12 is a sequential structure with restricted access and
 * limited capacity. Queue12 adapts Array12.
 * <p>
 * Access is available only at the ends of the structure:
 * <tt>dequeue()</tt> and <tt>E peek</tt>
 * operate on the front of the list; 
 * <tt>enqueue(E)</tt> 
 * operate on the back of the list.
 */

public class Queue12<E> implements LimCapQueue<E>
{

  private Array12<E> queue;

  /**
   * Constructor uses an Array12 object with a certain capacity to store 
   * the Queue12 structure
   */

  public Queue12(int capacity)
  {
    queue = new Array12<E>(capacity);
  }

  /**
   * Returns the capacity of this Queue12, that is,
   * the maximum number of elements it can hold.  
   * <br>PRECONDITION: none 
   * <br>POSTCONDITION: the Queue12 is unchanged.  
   * @return the capacity of this Queue12 
   */

  public int capacity()
  {
    return queue.capacity();
  }

  /**
   * Returns the number of elements in this Queue12. 
   * <br>PRECONDITION: none 
   * <br>POSTCONDITION: the Queue12 is unchanged. 
   * @return the number of elements in this Queue12 
   */ 

  public int size()
  {
    return queue.size();
  }

   /**
   * Adds the specified element to the tail of this Queue12.
   * Returns true if the operation succeeded, else false.
   * <br>PRECONDITION: the Queue12's size is less than its capacity.
   * <br>POSTCONDITION: the element is now the tail element in this
   * Queue12, none of the other elements have been changed, and
   * the size is increased by 1.
   * @param e the element to add to the queue
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */


  public boolean enqueue(E e) 
  {
    return queue.addBack(e);
  }

 /**
   * Removes the element at the head of this Queue12.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Queue12's size is greater than zero.
   * <br>POSTCONDITION: the head element in this Queue12 has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */

  public E dequeue()
  {
    return queue.removeFront();
  }

  /**
   * Returns the element at the head of this Queue12,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Queue12's size is greater than zero.
   * <br>POSTCONDITION: The Queue12 is unchanged.
   * @return  the element at the head, or <tt>null</tt> if the size was zero.
   */

  public E peek()
  {
    return queue.peekFront();
  }

 /**
   * Compares the specified object with this Queue12 for equality.
   * Returns true if and only if the specified object is
   * also a Queue12 of the same type, both have the same size, and the
   * corresponding pairs of elements in the two are
   * equal. Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of head elements,
   * the pair of next-to-head elements, and so on through to
   * the pair of tail elements.
   * @return true if the specified Object is equal to this Queue12 
   * @param  o the Object to compare to this Queue12 for equality
   */

  public boolean equals(Object o)
  {
    if(o instanceof Queue12) {
      //Passes in the Array12 object in Object o into equals
      return queue.equals(((Queue12)o).queue);
    }
    else {
      return false;
    }
  }

}
