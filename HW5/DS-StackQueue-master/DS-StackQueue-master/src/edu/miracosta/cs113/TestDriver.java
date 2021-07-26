package edu.miracosta.cs113;

import java.util.*;

public class TestDriver {
    public static void main (String[] args){
        String ac = "AC";
        String[] SIMPLE_TRUE = { "", " ", "A", "7", "%", "  ", "BB", "33", "**" };
        String[] SIMPLE_FALSE = { "AC", "71", "@+" };
        for (int i = 0; i < SIMPLE_TRUE.length; i ++) {
            System.out.println( isPalindrome(SIMPLE_TRUE[i]));
        }

        //System.out.println( isPalindrome("aa") );

    }

    public static boolean isPalindrome(String s) {
        Boolean returnVal = true;
        // TODO:
        // Implement this method body using your ArrayListStack. Be mindful of your algorithm!
        Stack<String> myStack = new Stack<>();
        ArrayList<String> myList = new ArrayList<>();
        if((s != null) ){
            //populate stack
            for(int i = 0 ; i < s.length() ; i ++){
                String c = s.charAt(i) + "";
                //c = Character.toLowerCase(c);
                if(!( c.equals(" ") )) {
                    System.out.println(i + " " + c);
                    myStack.push(c);
                    myList.add(c);
                }
            }
        }else{
            throw new IllegalArgumentException();
        }

        //check if values at s = values at stack
        for(int i = 0 ; i < myList.size() ; i++){

            if(!( myList.get(i).equals( myStack.pop() ) )){
                returnVal = false;
            }
        }
        return returnVal;
    } // End of method isPalindrome
}

// javac StackInterface.java ArrayListStack.java TestDriver.java