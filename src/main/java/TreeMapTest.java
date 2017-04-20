import java.util.TreeMap;

/**
 * Created by dengrongguan on 2017/3/3.
 */
public class TreeMapTest {
    static TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();
    static {
        treeMap.put("12",12);
        treeMap.put("14",14);
        treeMap.put("10",18);
    }
    public static void main(String[] args){
        System.out.println(treeMap.toString());
    }
}
