package edu.miracosta.cs113;

public class Term implements Comparable<Term>{

    int exponent;
    int coefficient;

    public Term(){
        exponent = 1;
        coefficient = 1;
    }

    public Term(int n1, int n2){
        exponent = n2;
        coefficient = n1;
    }

    public Term (String s){
    }

    public Term(Term t){
        exponent = t.getExponent();
        coefficient = t.getCoefficient();
    }

    public int getCoefficient(){
        return coefficient;
    }

    public int getExponent(){
        return exponent;
    }

    public void addTerm(String s){}

    public int getNumTerms(){
        return 1;
    }

    public void setCoefficient(int n){
        coefficient = n;
    }

    public void setExponent(int n){
        exponent = n;
    }

    public void setAll(int n, int n2){}

    public int compareTo(Term t){
        if(coefficient == t.getCoefficient() && exponent == t.getExponent()){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public String toString(){
        return getCoefficient() + "x^" + getExponent();
    }

}