import java.util.ArrayList;
public class DriverOne{
    public static void main(String[] args){
    ArrayList<String> list = new ArrayList<String>();
    String item = "hello";
    String item2 = "world";
    replace(list, item, item2);
    delete(list, item2);
    }

    public static String replace(ArrayList<String> aList, String oldItem, String newItem){
       //placeholder
        //System.out.println("replace called");
        return "replace called";
    }

    public static String delete(ArrayList<String> aList, String target){
        //placeholder
        //System.out.println("delete called");
        return "delete called";
    }
}
/*
time/space complexity,smaller
linked list
stack
queues
recurseion
trees
extra credit

*/
