package edu.miracosta.cs113.change;
//package change;
//package edu.miracosta.cs113;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculator {

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */

    public static int[] coins = {0,0,0,0};
    public static int[] coinVals = {25,10,5,1};
    public static int[] pMaxVals= {1,1,1,1};
    public static int numCombos = 0;
    public static int remaining;// make perminent so it is not reset
    public static String printElement;
    public static ArrayList<String> printArray = new ArrayList<>();
    public static int numIterations =0;

    public static void calculateChange(int cents) {
        if(pMaxVals[3] == 0){
            printCombinationsToFile( cents);
            return;}


        //reset values
        numIterations++;
        remaining = cents;
        for(int i = 0; i < 4; i++){
            coins[i] = 0;
        }

        if( numCombos == 0){    //populate permanent max values
            int a = cents/25; int b = cents/10; int c = cents/5; int d = cents;
            int[] maxVals = {a,b,c,d};
            printArray.add("");
            for(int i=0;i<4; i++){
                pMaxVals[i] = maxVals[i];
            }
        }

        while(remaining > 0){       //find coin combos
            for(int i = 0; i<4 ; i++){
                if((remaining >= coinVals[i]) && pMaxVals[i] >0){
                    coins[i] ++;
                    remaining = remaining - coinVals[i];

                    pMaxVals[i] = pMaxVals[i] - 1;
                    // if(i == 0)   //reset previous max vals
                    //pMaxVals[3] = cents;
                    if(i==1)
                        pMaxVals[0] = cents/25;
                    else if(i==2)
                        pMaxVals[1] = cents/10;
                    else if(i==3)
                        pMaxVals[2] = cents/5;
                }else{continue;}
            }
        }


        //populate array for printing
        printElement = "" + coins[0]+"Q, " + coins[1]+"D, "+ coins[2]+"N, "+ coins[3]+"P.\n";
        //boolean repeat=false;
        //for(in)
        if(!( printArray.contains(printElement) )){
            numCombos ++;
            System.out.println("combos: "+ numCombos);
            printArray.add(printElement);
        }

        /*
        if(numCombos < 4){      //decrement max values
            pMaxVals[numCombos] = pMaxVals[numCombos] -1;
            if(numCombos >= 1)
                pMaxVals[numCombos-1] = 0;
        }else if (numCombos >=4 && numCombos <= 7){
            pMaxVals[numCombos - 4] = pMaxVals[numCombos-4] -1;

            if(numCombos > 5)
                pMaxVals[numCombos-5] = 0;
        }else{
            pMaxVals[numCombos%4] = pMaxVals[numCombos%4] -1;

            if(numCombos%4 != 0)
                pMaxVals[numCombos%4 -1] = 0;
        }
        */


        calculateChange(cents);

    }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents) {
        // TODO:
        // This when calculateChange is complete. Note that the text file must be created within this directory.
        try {
//            File file = new File("E:/School/cs-113/CS113/HW6/DS-RecursionTrees-master/DS-RecursionTrees-master/src" +
//                    "/edu.miracosta.cs113/change/out.txt");
            File file = new File("out.txt");
//            Scanner in = new Scanner(printArray);
            PrintWriter pr = new PrintWriter("file");
            for(int i = 0 ; i < printArray.size(); i++){
                pr.println(printArray.get(i) );
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }

} // End of class ChangeCalculator