import java.util.*;

public class Lab
{
    public static class Table
    {
        private TreeMap<Double, Double> tableMap = new TreeMap<Double, Double>();

        public int addPair(double x, double y)
        {
            if (tableMap.containsKey(x))
            {
                System.out.println("Table already have value for x = " + x);
                throw new NullPointerException();
            }
            else
            {
                tableMap.put(x, y);
                return 0;
            }
        }

        public int removePairByX(double x)
        {
            if (tableMap.containsKey(x))
            {
                tableMap.remove(x);
                return 0;
            }
            else
            {
                System.out.println("Table doesn't contain x = " + x);
                throw new NullPointerException();
            }
        }

        public int findCloseValue(double x0)
        {
            if (tableMap.isEmpty())
            {
                System.out.println("Table is empty");
                throw new NullPointerException();
            }
            else if (x0 <= tableMap.firstKey())
            {
                Map.Entry<Double, Double> entry = tableMap.firstEntry();
                System.out.println("Closest pair for " + x0 + ": x = " + entry.getKey() + " y = " + entry.getValue());
                return 0;
            }
            else if (x0 >= tableMap.lastKey())
            {
                Map.Entry<Double, Double> entry = tableMap.lastEntry();
                System.out.println("Closest pair for " + x0 + ": x = " + entry.getKey() + " y = " + entry.getValue());
                return 0;
            }
            else
            {
                Map.Entry<Double, Double> curEntry, prevEntry;
                prevEntry = curEntry = tableMap.firstEntry();
                for (Map.Entry<Double, Double> entry : tableMap.entrySet())
                {
                    curEntry = entry;
                    if (x0 >= prevEntry.getKey() && x0 < curEntry.getKey())
                    {
                        if (x0 - prevEntry.getKey() <= (curEntry.getKey() - prevEntry.getKey())/2)
                        {
                            System.out.println("Closest pair for " + x0 + ": x = " + prevEntry.getKey() + " y = " + prevEntry.getValue());
                            return 0;
                        }
                        else
                        {
                            System.out.println("Closest pair for " + x0 + ": x = " + curEntry.getKey() + " y = " + curEntry.getValue());
                            return 0;
                        }
                    }
                    prevEntry = curEntry;
                }
            }
            throw new NullPointerException();
        }

        public double calculateValue(double x)
        {
            double result = 0;
            if (x < tableMap.firstKey() || x > tableMap.lastKey())
            {
                System.out.println("x goes beyond boundaries of keys");
                throw new NullPointerException();
            }
            else
            {
                Map.Entry<Double, Double> curEntry, prevEntry;
                prevEntry = curEntry =  tableMap.firstEntry();
                for (Map.Entry<Double, Double> entry : tableMap.entrySet())
                {
                    curEntry = entry;
                    if (x >= prevEntry.getKey() && x < entry.getKey())
                    {
                        break;
                    }
                    prevEntry = curEntry;
                }

                result = prevEntry.getValue() + (curEntry.getValue() - prevEntry.getValue())/
                        (curEntry.getKey() - prevEntry.getKey())*(x - prevEntry.getKey());
            }
            return result;
        }

        public int printTable()
        {
            if (!tableMap.isEmpty())
            {
                System.out.println("x     |    y  ");
                for (Map.Entry<Double, Double> entry : tableMap.entrySet())
                {
                    System.out.println(entry.getKey() + "        " + entry.getValue());
                }
                return 0;
            }
            else
            {
                System.out.println("Table is empty!");
                throw new NullPointerException();
            }
        }
    }
}
