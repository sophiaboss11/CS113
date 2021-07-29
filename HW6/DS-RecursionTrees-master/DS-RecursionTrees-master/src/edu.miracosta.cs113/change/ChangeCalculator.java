package edu.miracosta.cs113.change;
//package change;
//package edu.miracosta.cs113;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;
import java.util.ArrayList;

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
    public static int[] coins = {0,0,0,0};
    public static int[] coinVals = {25,10,5,1};
    public static int[] pMaxVals= {1,1,1,1};
    public static int numCombos = 0;
    public static int remaining;// make perminent so it is not reset
    public static String printElement;
    public static ArrayList<String> printArray = new ArrayList<>();

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


    public static int calculateChange(int cents) {
        //reset values
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
                }else{continue;}
            }
        }


        if(numCombos < 4){      //decrement max values
            pMaxVals[numCombos] = pMaxVals[numCombos] -1;
        }else if (numCombos >=4 && numCombos <= 7){
            pMaxVals[numCombos - 4] = pMaxVals[numCombos-4] -1;
        }else{
            pMaxVals[numCombos%4] = pMaxVals[numCombos%4] -1;
        }

        //populate array for printing
        printElement = "" + coins[0]+"Q, " + coins[1]+"D, "+ coins[2]+"N, "+ coins[3]+"P.\n";
        if(!(printElement.equals(printArray.get(printArray.size()-1)))){
            numCombos ++;
            System.out.println("combos: "+ numCombos);
            printArray.add(printElement);
        }

        for(int i=0; i<4; i++){     //call method again if max values are 0
            if(pMaxVals[i] > 0){
                calculateChange(cents);
            }else{
                // if(i== numCombos%4)
//                for(int j =0; j<printArray.size(); j++){
//                    System.out.println("[" + j + "]\t" + printArray.get(j) );
//                }
            }
        }

        return numCombos;
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
//        try {
//            ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream filename));
//                            out.writeObject (nameOfObject);
//        } catch (Exception ex) {
//            ex.printStackTrace()
//            System.exit
//
//        }
    }

} // End of class ChangeCalculator