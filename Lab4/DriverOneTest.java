import org.testng.annotations.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverOneTest {
    ArrayList<String> list = new ArrayList<String>();
    String item = "hello";
    String item2 = "world";
    DriverOne test = new DriverOne();

    @Test
    public void testReplace(){
        assertEquals(test.replace(list, item, item2), "replace called", "replace() method should be called");
    }

    @Test
    public void testDelete(){
        assertEquals(test.delete(list, item2), "delete called", "delete() method should be called");
    }
}