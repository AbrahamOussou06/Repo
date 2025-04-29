import static org.junit.Assert.*;
import org.junit.Test;

public class SizeTestStudent {
    @Test
    public void testSizeValues() {
        Size[] sizes = Size.values();
        assertEquals(3, sizes.length);
        assertEquals(Size.SMALL, sizes[0]);
        assertEquals(Size.MEDIUM, sizes[1]);
        assertEquals(Size.LARGE, sizes[2]);
    }
}