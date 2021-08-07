package edu.miracosta.cs113;
import java.io.*;
import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable {
    protected Node<E> root;

    public class Node<E>{
        Node<E> left;
        Node<E> right;
        E data;
        public Node(E myData){
            data = myData;
        }
        public String toString(){
            return ""+data;
        }
    }

    public BinaryTree(){root=null;}
    public BinaryTree(Node<E> root){this.root=root;}
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
        root = new Node<E>(data);
        if (leftTree != null) {
                root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
                root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    public E getData(){ return root.data;}

    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    public String toString() {
        StringBuilder
                sb = new StringBuilder();
        preOrderTraverse(root, 1,sb);
        return sb.toString();
    }
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append(" ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString() + "\n" );
            preOrderTraverse (node.left , depth + 1, sb);
            preOrderTraverse (node.right , depth + 1,sb);
        }
    }

    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        String data = scan.next();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }

    //Write a Serializable object to a file:
    public void Output( String filename, E nameOfObject ){
        try {
            ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream( filename));
            out.writeObject(nameOfObject);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    //Read a Serializable object from a file:
    public void Input( String filename, E objectName ){
        try {
            ObjectInputStream in = new ObjectInputStream (new FileInputStream ( filename));
            objectName = (E )in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }


    /*
    @Override
    public ExpressionTree getLeftOperand() {
        return null;
    }

    @Override
    public ExpressionTree getRightOperand() {
        return null;
    }

    @Override
    public Kind getKind() {
        return null;
    }

    @Override
    public <R, D> R accept(TreeVisitor<R, D> visitor, D data) {
        return null;
    }
     */


}
