import java.util.*;
class CompLastNames implements Comparator <String>{

    @Override
    //founf index from which the lastname was started

    public int compare(String o1, String o2) {
        int i,j;
        i = o1.lastIndexOf(' ');
        j = o2.lastIndexOf(' ');

        return o1.substring(i).compareToIgnoreCase(o2.substring(j));
    }
}
class CompThenByFirstName implements Comparator<String>{

    @Override
    //found ,if lastnames was similar, by name
    public int compare(String o1, String o2) {

        return o1.compareToIgnoreCase(o2);
    }
}
public class TreeMapDemo2A {
    public static void main(String[] args) {
        CompLastNames compLN = new CompLastNames();
        Comparator<String> compLastThenFirst = compLN.thenComparing(new CompThenByFirstName());
        TreeMap<String,Double> tm = new TreeMap(compLastThenFirst);

        tm.put("John Dou",new Double (3423.98));
        tm.put("Tom Smith", new Double(123.34));
        tm.put("Jain Vaker", new Double (1378.98));
        tm.put("Tod Hall", new Double(99.02));
        tm.put("Ralph Smith", new Double(-19.08));

        Set<Map.Entry<String,Double>> set = tm.entrySet();

        for (Map.Entry<String, Double> val: set)
            System.out.println(val.getKey()+": "+ val.getValue());

        double balance = tm.get("Jain Vaker");
        tm.put("Jain Vaker", balance + 1300);
        System.out.println("Jain Vaker: "+ tm.get("Jain Vaker"));
    }
}
