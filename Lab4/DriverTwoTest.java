import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverTwoTest {
    DriverTwo test = new DriverTwo();
    String s = "hello";
    String s2 = "1234";

    @Test
    void testAddOrChangeEntry(){
        assertEquals(test.addOrChangeEntry(s,s2), "addOrChangeEntry() called.", "method called");
    }

    @Test
    void testRemoveEntry(){
        assertEquals(test.removeEntry(s), "removeEntry() called.", "method called");
    }

}