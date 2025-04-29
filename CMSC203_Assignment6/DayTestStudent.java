import static org.junit.Assert.*;
import org.junit.Test;

public class DayTestStudent {
    @Test
    public void testDayValues() {
        Day[] days = Day.values();
        assertEquals(7, days.length);
        assertEquals(Day.MONDAY, days[0]);
        assertEquals(Day.TUESDAY, days[1]);
        assertEquals(Day.WEDNESDAY, days[2]);
        assertEquals(Day.THURSDAY, days[3]);
        assertEquals(Day.FRIDAY, days[4]);
        assertEquals(Day.SATURDAY, days[5]);
        assertEquals(Day.SUNDAY, days[6]);
    }
}