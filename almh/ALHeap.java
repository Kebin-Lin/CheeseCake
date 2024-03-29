/*****************************************************
* class ALHeap
* SKELETON
* Implements a min heap using an ArrayList as underlying container
*****************************************************/

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /*****************************************************
  * default constructor  ---  inits empty heap
  *****************************************************/
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }



  /*****************************************************
  * toString()  ---  overrides inherited method
  * Returns either
  * a) a level-order traversal of the tree (simple version)
  * b) ASCII representation of the tree (more complicated, more fun)
  *****************************************************/
  public String toString()
  {
    String output = "";
    for (int i:_heap) {
      output += i + " ";
    }
    return output;
  }//O(n)


  /*****************************************************
  * boolean isEmpty()
  * Returns true if no meaningful elements in heap, false otherwise
  *****************************************************/
  public boolean isEmpty()
  {
    return _heap.size() == 0;
  }//O(1)


  /*****************************************************
  * Integer peekMin()
  * Returns min value in heap
  * Postcondition: Heap remains unchanged.
  *****************************************************/
  public Integer peekMin()
  {
    if (isEmpty()) return null;
    return _heap.get(0);
  }//O(1)


  /*****************************************************
  * add(Integer)
  * Inserts an element in the heap
  * Postcondition: Tree exhibits heap property.
  * Algo:
  * 1) Add value to the end of the Array
  * 2) While the value's parent is greater than it, swap the parent with the value
  *****************************************************/
  public void add( Integer addVal )
  {
    int currPos = _heap.size();
    _heap.add(addVal);
    while (_heap.get(currPos) < _heap.get( (currPos - 1)/2 )) { //While child < parent
      swap(currPos,(currPos - 1)/2); //Swap child and parent
      currPos = (currPos - 1)/2;
    }
  }//O(logn)


  /*****************************************************
  * removeMin()  ---  means of removing an element from heap
  * Removes and returns least element in heap.
  * Postcondition: Tree maintains heap property.
  * Algo:
  * 0) Save value in first index
  * 1) Swap values at first and last index
  * 2) Remove element at the last index
  * 3) Until the value at the first index is less than both its children, swap it with its smaller child
  *****************************************************/
  public Integer removeMin()
  {
    if (isEmpty()) return null;
    int output = _heap.get(0);
    swap(0,_heap.size()-1);
    _heap.remove(_heap.size()-1);
    int currPos = 0;
    int minPos = minChildPos(currPos);
    while (minPos != -1) {
      if (_heap.get(currPos) > _heap.get(minPos)) swap(currPos,minPos);
      currPos = minPos;
      minPos = minChildPos(minPos);
    }
    return output;
  }//O(logn)


  /*****************************************************
  * minChildPos(int)  ---  helper fxn for removeMin()
  * Returns index of least child, or
  * -1 if no children, or if input pos is not in ArrayList
  * Postcondition: Tree unchanged
  *****************************************************/
  private int minChildPos( int pos )
  {
    if (pos * 2 + 1 > _heap.size() - 1) return -1; //No children
    if (pos * 2 + 1 == _heap.size() - 1) return pos * 2 + 1; //One child
    int min = minOf(_heap.get(pos * 2 + 1),_heap.get(pos * 2 + 2));
    //Return the position of the min
    return (min == _heap.get(pos * 2 + 1)) ? pos * 2 + 1 : pos * 2 + 2;
  }//O(1)


  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
    return a;
    else
    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {
    ALHeap pile = new ALHeap();

    pile.add(2);
    System.out.println(pile);
    pile.add(4);
    System.out.println(pile);
    pile.add(6);
    System.out.println(pile);
    pile.add(8);
    System.out.println(pile);
    pile.add(10);
    System.out.println(pile);
    pile.add(1);
    System.out.println(pile);
    pile.add(3);
    System.out.println(pile);
    pile.add(5);
    System.out.println(pile);
    pile.add(7);
    System.out.println(pile);
    pile.add(9);
    System.out.println(pile);

    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
