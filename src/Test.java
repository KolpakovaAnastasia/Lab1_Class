import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class Test
{
    Lab.Table t = new Lab.Table();
    @org.junit.jupiter.api.Test
    void addPair()
    {
        t.addPair(4, -0.7568);
        t.addPair(1, 0.8415);
        assertEquals(0, t.addPair(8,0.95));
        assertThrows(NullPointerException.class, () -> {
            t.addPair(4, -0.7568);
        });
    }

    @org.junit.jupiter.api.Test
    void removePairByX()
    {
        t.addPair(4, -0.7568);
        t.addPair(1, 0.8415);
        t.addPair(2, 0.9093);
        assertEquals(0, t.removePairByX(1));
        assertThrows(NullPointerException.class, () -> {
            t.removePairByX(8);
        });
    }

    @org.junit.jupiter.api.Test
    void findCloseValue()
    {
        assertThrows(NullPointerException.class, () -> {
            t.findCloseValue(4);
        });
        t.addPair(1, 0.8415);
        t.addPair(2, 0.9093);
        t.addPair(8000, 19.2);
        t.addPair(3, 0.1411);
        assertEquals(0,t.findCloseValue(0));
        assertEquals(0,t.findCloseValue(2.4));
        assertEquals(0,t.findCloseValue(2.6));
        assertEquals(0,t.findCloseValue(9000));
    }

    @org.junit.jupiter.api.Test
    void calculateValue()
    {
        t.addPair(4, 0.7568);
        t.addPair(1, 0.8415);
        t.addPair(2, 0.9093);
        t.addPair(8000, 19.2);
        t.addPair(3, 0.1411);
        t.addPair(6000, 15.5);
        assertEquals(16.1993,t.calculateValue(6378));
        assertEquals(0.85506,t.calculateValue(1.2));
        assertEquals(0.8718736757838559,t.calculateValue(50.8));
        assertEquals(15.500185,t.calculateValue(6000.1));
        assertThrows(NullPointerException.class, () -> {
            t.calculateValue(9000);
        });
        assertThrows(NullPointerException.class, () -> {
            t.calculateValue(0);
        });
    }

    @org.junit.jupiter.api.Test
    void printTable()
    {
        assertThrows(NullPointerException.class, () -> {
            t.printTable();
        });
        t.addPair(1, 0.8415);
        t.addPair(8000, 19.2);
        t.addPair(0, 0);
        t.addPair(6000, 15.5);
        t.removePairByX(8000);
        t.removePairByX(0);
        t.addPair(3, 0.1411);
        t.addPair(4, -0.7568);
        t.addPair(2, 0.9093);
        t.removePairByX(2);
        t.addPair(0, 9000);
        assertEquals(0,t.printTable());
    }

}