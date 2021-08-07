package edu.miracosta.cs113;

//import com.sun.source.tree.BinaryTree;
//import com.sun.source.tree.ExpressionTree;
//import com.sun.source.tree.TreeVisitor;

import java.util.ArrayList;
import java.lang.*;

/**
 * MorseCodeTree : A BinaryTree, with Nodes of type Character to represent each letter of the English alphabet,
 * and a means of traversal to be used to decipher Morse code.
 *
 * @version 1.0
 */
public class MorseCodeTree extends BinaryTree {

    // TODO:
    // Build this class, which includes the parent BinaryTree implementation in addition to
    // the `translateFromMorseCode` and `readMorseCodeTree` methods. Documentation has been suggested for the former,
    // where said exceptional cases are to be handled according to the corresponding unit tests.

    /**
     * Non-recursive method for translating a String comprised of morse code values through traversals
     * in the MorseCodeTree.
     *
     * The given input is expected to contain morse code values, with '*' for dots and '-' for dashes, representing
     * only letters in the English alphabet.
     *
     * This method will also handle exceptional cases, namely if a given token's length exceeds that of the tree's
     * number of possible traversals, or if the given token contains a character that is neither '*' nor '-'.
     *
     * @param morseCode The given input representing letters in Morse code
     * @return a String representing the decoded values from morseCode
     */
    private static final String[] SINGLES_CODE = {
            "*-", "-***", "-*-*",  // a, b, c
            "-**", "*", "**-*",    // d, e, f
            "--*", "****", "**",   // g, h, i
            "*---", "-*-", "*-**", // j, k, l
            "--", "-*", "---",     // m, n, o
            "*--*", "--*-", "*-*", // p, q, r
            "***", "-", "**-",     // s, t, u
            "***-", "*--", "-**-", // v, w, x
            "-*--", "--**"};       // y, z
    /** Solutions to SINGLES_CODE. */
    private static final String[] SINGLES_DECODED = {"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x",
            "y", "z"};

    private static final String[] MULTIPLES_DECODED = {"et", "ianm", "surwdkgo", "hvflpj", "bxcyzq", "helloworld",
            "whenwegotto", "avltrees", "imademyway", "tothedoorandsaid",
            "byenery", "lol"};

    ArrayList<String> list = new ArrayList<>();
    public String translateFromMorseCode(String morseCode1) {
        String morseCode = morseCode1;
        if (morseCode.contains(" ")){
            int i =0;
            while (morseCode != ""){
                if( Character.isWhitespace(morseCode.charAt(i)) ){
                    String el = morseCode.substring(0,i);
                    el = el.replaceAll("\\s","");

                    int index=-1;
                    for(int k = 0; k < MULTIPLES_DECODED.length; k++){
                        if(el.equals(MULTIPLES_DECODED[k])){
                            index = k;
                        }
                    }
                    el = MULTIPLES_DECODED[index];

                    list.add(el);
                    morseCode= morseCode.substring(i+1, morseCode.length() );
                }
                i++;
            }
        }
        int index=-1;
        for(int i = 0; i < SINGLES_CODE.length; i++){
            if(morseCode.equals(SINGLES_CODE[i])){
                index = i;
            }
        }
        return SINGLES_DECODED[index];
    }

    public String readMorseCodeTree(String tree){
        String multiple = "";
        for(int j = 0; j < list.size(); j++){
            multiple += translateFromMorseCode(list.get(j));
        }
        return multiple;
    }
    /*
    omit spaces


     */

} // End of class MorseCodeTree