import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
        assertThrows(IllegalArgumentException.class, () -> {
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
        assertThrows(IllegalArgumentException.class, () -> {
            t.removePairByX(8);
        });
    }

    @org.junit.jupiter.api.Test
    void findCloseValue()
    {
        assertThrows(NegativeArraySizeException.class, () -> {
            t.findCloseValue(4);
        });
        t.addPair(1, 0.8415);
        t.addPair(2, 0.9093);
        t.addPair(8000, 19.2);
        t.addPair(3, 0.1411);
        double[] expected = new double[2];
        expected[0] = 1;
        expected[1] = 0.8415;
        assertArrayEquals(expected,t.findCloseValue(0));
        expected[0] = 2;
        expected[1] = 0.9093;
        assertArrayEquals(expected,t.findCloseValue(2.4));
        expected[0] = 3;
        expected[1] = 0.1411;
        assertArrayEquals(expected, t.findCloseValue(2.6));
        expected[0] = 8000;
        expected[1] = 19.2;
        assertArrayEquals(expected,t.findCloseValue(9000));
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
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            t.calculateValue(9000);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            t.calculateValue(0);
        });
    }

    @org.junit.jupiter.api.Test
    void printTable()
    {
        assertEquals("Table is empty!",t.toString());
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
        assertEquals("x     |    y" + "\n" +
                "0.0        9000.0" +"\n"  +
                "1.0        0.8415" +"\n" +
                "3.0        0.1411" + "\n" +
                "4.0        -0.7568" + "\n" +
                "6000.0        15.5" + "\n",t.toString());
    }

}