package edu.miracosta.cs113;
import java.util.*;

public class Polynomial{
    LinkedList<Term> termList = new LinkedList<Term>();
    public Polynomial(Polynomial p){//fill in
        termList = getTerm();
    }
    public Polynomial(LinkedList<Term> tl){//fill in
        termList = tl;
    }

    public Polynomial(){
        termList = new LinkedList<Term>();
        this.termList = termList;
    }

    public int getNumTerms(){
        int terms = 0;
        for(int i = 0 ; i < getTerm().size() ; i++){
            terms++;
        }
        return terms;
    }

    public void setTermList(LinkedList<Term> t){
        termList = t;
    }

    public void addTerm(Term t){
//        LinkedList<Term> tl = getTerm();
//        setTermList( tl.add(t) );
        termList.add(t);
    }

    public void add(Polynomial p){
        LinkedList<Term> tl = p.getTerm();
        for(int i = 0; i < tl.size(); i++){
            termList.add(tl.get(i));
        }
    }

    public LinkedList<Term> getTerm(){
        return termList;
    }

    public Term getTerm(int i){
        return termList.get(i);
    }

    public void clear(){
        termList.clear();
    }

    @Override
    public String toString(){
        //test it?
        String s ="";
        for(int i = 0 ; i < termList.size(); i++){
            if(i < termList.size() -1){
                s = s + termList.get(i).toString() + "+";
            }else{
                s = s + termList.get(i).toString();
            }
        }
        return s;
    }
}