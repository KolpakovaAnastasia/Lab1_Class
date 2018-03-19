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
                throw new IllegalArgumentException();
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
                throw new IllegalArgumentException();
            }
        }

        public double[] findCloseValue(double x0)
        {
            if (tableMap.isEmpty())
            {
                throw new NegativeArraySizeException();
            }
            else if (x0 <= tableMap.firstKey())
            {
                double[] pair = new double[2];
                pair[0] = tableMap.firstEntry().getKey();
                pair[1] = tableMap.firstEntry().getValue();
                return pair;
            }
            else if (x0 >= tableMap.lastKey())
            {
                double[] pair = new double[2];
                pair[0] = tableMap.lastEntry().getKey();
                pair[1] = tableMap.lastEntry().getValue();
                return pair;
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
                            double[] pair = new double[2];
                            pair[0] = prevEntry.getKey();
                            pair[1] = prevEntry.getValue();
                            return pair;
                        }
                        else
                        {
                            double[] pair = new double[2];
                            pair[0] = curEntry.getKey();
                            pair[1] = curEntry.getValue();
                            return pair;
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
                throw new ArrayIndexOutOfBoundsException();
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

        @Override
        public String toString()
        {
            if (!tableMap.isEmpty())
            {
                String table = "";
                table += "x     |    y\n";
                for (Map.Entry<Double, Double> entry : tableMap.entrySet())
                {
                    table += entry.getKey() + "        " + entry.getValue() + "\n";
                }
                return table;
            }
            else
            {
                return "Table is empty!";
            }
        }
    }
}
