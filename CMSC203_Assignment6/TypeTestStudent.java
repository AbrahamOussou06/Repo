import static org.junit.Assert.*;
import org.junit.Test;

public class TypeTestStudent {
    @Test
    public void testTypeValues() {
        Type[] types = Type.values();
        assertEquals(3, types.length);
        assertEquals(Type.COFFEE, types[0]);
        assertEquals(Type.SMOOTHIE, types[1]);
        assertEquals(Type.ALCOHOL, types[2]);
    }
}