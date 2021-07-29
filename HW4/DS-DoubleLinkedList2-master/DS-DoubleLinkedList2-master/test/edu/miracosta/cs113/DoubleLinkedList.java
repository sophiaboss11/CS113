package edu.miracosta.cs113;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
        private Node<E> current = null;

    public DoubleLinkedList(){
        head = null; tail = null; size = 0;
    }
    public DoubleLinkedList(Node<E> h, Node<E> t, int s){
        head = h; tail = t; size = s;
    }

    @Override
  public void add(int index, E obj)
  { // Fill Here
      listIterator(index).add(obj);

  }

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
  {
      if((size() <= index) || (index < 0)){
          throw new IndexOutOfBoundsException("Invalid index " );
      }
      if( size() == 0 || head == null){
          throw new IndexOutOfBoundsException("Invalid index " );
      }
    try {
        ListIterator<E> iter = listIterator(index);
        return iter.next();
    }catch(Exception e){
        throw new IndexOutOfBoundsException("Invalid index " );
    }

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

    //roString methods
    public String stringToString(List<String> li){
        String s="";
        if(li.size() == 1) {
            s = "[" + li.get(0) + "]";
        }else{
            s="[";
            for(int i = 0; i<li.size(); i++){
                if (i < li.size() -1 ) {
                    s = s + li.get(i) + ", ";
                }else{
                    s = s + li.get(i);
                }
            }
            s = s + "]";
        }
        return s;
    }
    public String intToString(List<Integer> li){
        String s="";
        if(li.size() == 1) {
            s = "[" + li.get(0) + "]";
        }else{
            s="[";
            for(int i = 0; i<li.size(); i++){
                if (i < li.size() -1 ) {
                    s = s + li.get(i) + ", ";
                }else{
                    s = s + li.get(i);
                }
            }
            s = s + "]";
        }
        return s;
    }
    public String CharToString(List<Character> li){
        String s="";
        if(li.size() == 1) {
            s = "[" + li.get(0) + "]";
        }else{
            s="[";
            for(int i = 0; i<li.size(); i++){
                if (i < li.size() -1 ) {
                    s = s + li.get(i) + ", ";
                }else{
                    s = s + li.get(i);
                }
            }
            s = s + "]";
        }
        return s;
    }
    public String doubleToString(List<Double> li){
        String s="";
        if(li.size() == 1) {
            s = "[" + li.get(0) + "]";
        }else{
            s="[";
            for(int i = 0; i<li.size(); i++){
                if (i < li.size() -1 ) {
                    s = s + li.get(i) + ", ";
                }else{
                    s = s + li.get(i);
                }
            }
            s = s + "]";
        }
        return s;
    }

    public void clear(){
        head = null; tail = null; size = 0;
    }

    public int indexOf(Object o){
        for(int i=0; i< size; i++){
            ListIterator<E> iter = listIterator(i);
            String nx = iter.next().toString();
            if(nx.equals(o.toString())){
                return i;
            }else{
                continue;
            }
        }
        return -1;
    }

    //@Override
    public boolean contains(Object o) {
        //return super.contains(o);
        boolean c = false;
        for(int i=0; i< size; i++){
            if(get(i) == o || get(i).equals(o)){
                c=true;
            }
        }
        return c;
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
          tail.next = nn;
          nn.prev = tail;
          tail = nn;
      }else{
          nn.next = nextItem;
          nn.prev = nextItem.prev;
          nextItem.prev.next = nn;
          nextItem.prev = nn;
      }
        size++;
        index++;
        //lastItemReturned = null;
    }//end of method add()

  }// end of inner class ListIter


}// end of class DoubleLinkedList
