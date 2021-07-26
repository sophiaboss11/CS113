package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<T> implements StackInterface<Integer> {
    ArrayList<Integer> myList;

    public ArrayListStack(){
        myList = new ArrayList();
    }

    @Override
    public boolean empty() {
        if(myList.size() < 1 ){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Integer peek() {
        if(empty()){
            throw new EmptyStackException();
        }else {
            return (Integer) myList.get(0);
        }
    }

    @Override
    public Integer pop() {
        if(empty()){
            throw new EmptyStackException();
        }else {
            int x = myList.get(0);
            myList.remove(myList.get(0));
            return x;
        }

    }

    @Override
    public Integer push(Integer obj) {
        myList.add(obj);
        int size = myList.size();
        for(int i = size - 1; i>0 ; i--){
            int temp = myList.get(i-1) ;
            myList.set(i-1, myList.get(i));
            myList.set(i, temp);
        }
        return null;
    }

//    //@Override
//    public Integer push(Character obj) {
//        myList.add(obj);
//        int size = myList.size();
//        for(int i = size - 1; i>0 ; i--){
//            T temp = myList.get(i-1) ;
//            myList.set(i-1, myList.get(i));
//            myList.set(i, temp);
//        }
//        return null;
//    }
}
