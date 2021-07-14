package edu.miracosta.cs113;
import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
//        private Node<E> current = null;

    public DoubleLinkedList(){
        head = null; tail = null; size = 0;
    }
//    public DoubleLinkedList(Node<E> h, Node<E> t, int s){
//        head = h; tail = t; size = s;
//    }

    @Override
  public void add(int index, E obj)
  { // Fill Here
      listIterator(index).add(obj);
  }

//    @Override
//  public boolean add(E obj)
//  { // Fill Here
//      listIterator(0).add(obj);
//      return false;
//  }

//  @Override
//    public boolean add( E obj)
//    { // Fill Here
//        Node<E> nextItem = new Node<E>(obj); //?
//
//        if(head == null){
//            head = new Node<E>(obj);
//            tail = head;
//            add(size(), (E) nextItem);
//
//        }
//        else if(nextItem == head){
//            Node<E> newNode = new Node<E>(obj);
//            newNode.next = nextItem;
//            nextItem.prev = newNode;
//            head = newNode;
//        }else if(nextItem == null){
//            Node<E> newNode = new Node<E>(obj);
//            tail.next = newNode;
//            newNode.prev = tail;
//            tail = newNode;
//        }else{
//            Node<E> newNode = new Node<E>(obj);
//            newNode.prev = nextItem.prev;
//            nextItem.prev.next = newNode;
//            newNode.next = nextItem;
//            nextItem.prev = newNode;
//        }
//
//        return true;
//    }

  public void addFirst(E obj) { // Fill Here
/*      ListIterator<E> iter = listIterator(0);
      iter.add(obj);
      Node new_Node = new Node(obj);
      new_Node.next = head;
      new_Node.prev = null;
      if (head != null)
          head.prev = new_Node;
      head = new_Node;
      */

//      head = new Node<E>(obj, head);
//      size++;
  }
  public void addLast(E obj) { // Fill Here
      add(size, obj);
  }

  public E get(int index) 
  { 	ListIterator<E> iter = listIterator(index); 
      	return iter.next();
  }  
  public E getFirst() { return head.data;  }
  public E getLast() { return tail.data;  }

  public int size() {  return size;  } // Fill Here

  public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }

  public Iterator iterator() { return new ListIter(0);  }
  public ListIterator listIterator() { return new ListIter(0);  }
  public ListIterator listIterator(int index){return new ListIter(index);}
  public ListIterator listIterator(ListIterator iter)
  {     return new ListIter( (ListIter) iter);  }

   // @Override
    public String toString(List<E> li){
//        ListIter lii = new ListIter;
        int s = li.size();
        String out ="";
        if( s > 0 ){
//            for(int i =0; i<s;i++){
////                System.out.println(li.get(i));
//                out = out + li.get(i);
//            }
            out="list has elements(change later)";
        }else{
//            System.out.println("[]");
            out = "[]";
        }
        return out;
    }

  // Inner Classes
  public static class Node<E>
  {      E data;
         Node<E> next = null;
         Node<E> prev = null;

         Node(E dataItem)  //constructor
        {   data = dataItem;   }
  }  // end class Node


  public class ListIter implements ListIterator<E>
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

    public ListIter(int i)  // constructor for ListIter class
    {   if (i < 0 || i > size)
        {     throw new IndexOutOfBoundsException("Invalid index " + i); }
        lastItemReturned = null;
 
        if (i == size)     // Special case of last item
        {     index = size;     nextItem = null;      }
        else          // start at the beginning
        {   nextItem = head;
            for (index = 0; index < i; index++)  nextItem = nextItem.next;   
        }// end else
    }  // end constructor

    public ListIter(ListIter other)
    {   nextItem = other.nextItem;
        index = other.index;    }

    public boolean hasNext() {
        if(nextItem != null){
            return true;
        }else{
            return false;
        }
    } // Fill Here
    public boolean hasPrevious(){
        if(lastItemReturned != null){
            return true;
        }else{
            return false;
        }
    } // Fill Here
    public int previousIndex() {  return index - 1;   } // Fill Here
    public int nextIndex() {  return index;    } // Fill here
    public void set(E o) {throw new UnsupportedOperationException("Not supported yet.");}  // not implemented
    public void remove(){throw new UnsupportedOperationException("Not supported yet.");}      // not implemented

    public E next() {
//        return lastItemReturned.data; // Fill Here
        if (hasNext()){
            return nextItem.data;
        }else{
            return null;
        }
    }

    public E previous()
    {  return lastItemReturned.data; // Fill Here 
    }

    @Override
    public void add(E obj) {
        Node nn = new Node(obj);

      if(head == null){
          head = nn;
          tail = head;
      }else if(nextItem == head){
          //Node<E> newNode = new Node<E>(obj);
          //newNode.next = nextItem;
          nextItem.prev = nn;
          nn.next = nextItem;
          head = nn;
      }else if(nextItem == null){
          //Node<E> newNode = new Node<E>(obj);
          tail.next = nn;
          nn.prev = tail;
          tail = nn;
      }else{
          //Node<E> newNode = new Node<E>(obj);
          nn.next = nextItem;
          nn.prev = nextItem.prev;
          nextItem.prev.next = nn;
          nextItem.prev = nn;
      }
        size++;
        index++;
        lastItemReturned = null;
    }//end of method add()

  }// end of inner class ListIter


}// end of class DoubleLinkedList
