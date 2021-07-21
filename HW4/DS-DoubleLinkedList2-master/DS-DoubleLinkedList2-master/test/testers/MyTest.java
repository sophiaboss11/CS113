//package testers;
//import java.util.*;
//import edu.miracosta.cs113.DoubleLinkedList;
//
//public class MyTest {
//
//    public static void add(E obj) {
//        DoubleLinkedList.Node<E> head = null;   // points to the head of the list
//        DoubleLinkedList.Node<E> tail = null;   //points to the tail of the list
//        int size = 0;    // the number of items in the list
//        DoubleLinkedList.Node nn = new DoubleLinkedList.Node(obj);
//
//        if(head == null){
//            head = nn;
//            tail = head;
//        }else if(nextItem == head){
//            //Node<E> newNode = new Node<E>(obj);
//            //newNode.next = nextItem;
//            nextItem.prev = nn;
//            nn.next = nextItem;
//            head = nn;
//        }else if(nextItem == null){
//            //Node<E> newNode = new Node<E>(obj);
//            tail.next = nn;
//            nn.prev = tail;
//            tail = nn;
//        }else{
//            //Node<E> newNode = new Node<E>(obj);
//            nn.next = nextItem;
//            nn.prev = nextItem.prev;
//            nextItem.prev.next = nn;
//            nextItem.prev = nn;
//        }
//        size++;
//        index++;
//        lastItemReturned = null;
//    }//end of method add()
//}
