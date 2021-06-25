package edu.miracosta.cs113;
import java.io.IOException;
import java.util.*;

public class Driver {
    public static Scanner in = new Scanner(System.in);
    Polynomial p1 = new Polynomial();

    public static void main (String args[]) throws IOException{
        menu();
    }

    public static void menu() throws IOException {
        int x = 0;
        while(x==0) {
            System.out.println("Select one of the following options:" +
                            "\n[1] edit first polynomial" +
                            "\n[2] edit second polynomial" +
                            "\n[3] display the result of adding the current first and second polynomial"+
                            "\n[4] exit the program");
            try {
                int input2 = in.nextInt();
//                Scanner.nextLine();
                if(input2 == 1){
                    System.out.println("Editing first polynomial...");
                    editPolynomial();
                } else if (input2 == 2) {
                    System.out.println("Editing second polynomial...");
                    editPolynomial();
                }else if(input2 == 3){
                    System.out.println("insert display");
                }else if(input2 == 4){
                    System.out.println("Exiting...");
                    System.exit(0);
                }
            }catch(Exception e){
                System.out.println("wrong input");
            }
        }
    }

    public static void editPolynomial() throws IOException {
//        LinkedList<Polynomial> polyList= new LinkedList<Polynomial>();
//        Term t1 = new Term(3,4);
//        Term t2 = new Term(2,2);
//        LinkedList<Term> termList= new LinkedList<Term>();
//        termList.add(t1);
//        termList.add(t2);
        Polynomial p1 = new Polynomial();

        int x = 0;
        while(x==0) {
            System.out.println("Select one of the following options:" +
                    "\n[1] clear polynomial" +
                    "\n[2] create polynomial" +
                    "\n[3] add terms to the polynomial" +
                    "\n[4] go back a step");

            try {
                String user = in.nextLine();
                int input = in.nextInt();
                if (input == 1) {
                    System.out.println("clearing first polynomial...");
                } else if (input == 2) {
                    System.out.println("creating polynomial..." );
                    System.out.println("enter coefficient:");
                    int coefficient = in.nextInt();
                    System.out.println("enter exponent");
                    int exponent = in.nextInt();

                    //create polynomial
                    Term t = new Term(coefficient, exponent);
                    LinkedList<Term> termList= new LinkedList<Term>();
                    termList.add(t);
                    Polynomial p2 = new Polynomial(termList);
                    p1 = p2;

                    System.out.println("Your Polynomial: " + p1.toString() );

                } else if (input == 3) {
                    //accept input
                    System.out.println("adding terms...");
                    System.out.println("enter coefficient:");
                    int coefficient = in.nextInt();
                    System.out.println("enter exponent");
                    int exponent = in.nextInt();

                    //add polynomial
                    Term t2 = new Term(coefficient, exponent);
                    p1.addTerm(t2);
                    System.out.println("Your Polynomial: " + p1.toString() );

                } else if (input == 4) {
                    System.out.println("Exiting...");
//                    System.exit(0);
                    break;
                }
            } catch (Exception e) {
                System.out.println("wrong input");
                continue;
            }
        }
    }



}
