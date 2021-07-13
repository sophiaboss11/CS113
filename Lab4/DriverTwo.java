public class DriverTwo {
    public static void main(String[] args){
        String s = "hello";
        String s2 = "1234";

        addOrChangeEntry(s,s2);
        removeEntry(s);
    }

    public static String addOrChangeEntry(String name, String newNumber){
        System.out.println("addOrChangeEntry() called.");
        return "addOrChangeEntry() called.";
    }

    public static String removeEntry(String name){
        System.out.println("removeEntry() called.");
        return "removeEntry() called.";
    }
}
