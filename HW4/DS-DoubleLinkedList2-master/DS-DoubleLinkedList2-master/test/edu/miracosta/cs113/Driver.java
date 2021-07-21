package edu.miracosta.cs113;

import java.util.List;

public class Driver {
    public static void main (String[] args){
        String[] arr = {"first", "second", "third", "fourth" , "fifth"};
        List<String> stringList = new DoubleLinkedList<String>();
        stringList.add(0, arr[1]);
        //DoubleLinkedList dll = new DoubleLinkedList();

        System.out.println("" + stringList);
    }
}
