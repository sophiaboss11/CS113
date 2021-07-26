package edu.miracosta.cs113;

import java.util.*;

public class CircularArrayQueue<T> implements Queue<String> {
    Queue<String> qu;
    int size;
    public CircularArrayQueue(int initialCapacity) {
        qu = new LinkedList<>();
//        for(int i = 0; i < initialCapacity; i++){
//            qu.add("");
//        }
        size = initialCapacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean r = false;
        if(size <1 ){
            r=true;
        }
        return r;
    }

    @Override
    public boolean contains(Object o) {
        boolean r = false;
        String[] arr = qu.toArray(new String[0]);
        String s = o.toString();

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i].equals(s)){
                r=true;
            }
        }
        return r;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        try{
            qu.add(s);
            return true;
        }catch(Exception e){
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(String s) {
        try{
            qu.offer(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public String remove() {
        try{
            String r = peek();
            qu.remove();
            return r;
        }catch (Exception e){
            throw new NoSuchElementException();
        }
    }

    @Override
    public String poll() {
        try{
            return qu.poll();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String element() {
        try{
            return qu.element();
        }catch (Exception e){
            throw new NoSuchElementException();
        }
    }

    @Override
    public String peek() {
        try{
            return qu.peek();
        }catch (Exception e){
            return null;
        }
    }
}
