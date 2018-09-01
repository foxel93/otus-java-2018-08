import org.junit.jupiter.api.Test;
import ru.otus.MathNew;

import static org.junit.jupiter.api.Assertions.*;

public class MathTest {

    @Test
    public void testAdd(){
        System.out.println("Add");
        int a = 3;
        int b = 3;
        int expResult = 5;
        int result = MathNew.add(a,b);
        assertEquals(expResult,result);
    }

    @Test
    public void testDiv(){
        System.out.println("Div");
        int a = 4;
        int b = 2;
        int expResult = 2;
        int result = MathNew.div(a,b);
        assertEquals(expResult,result);
    }
}
