import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str: strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String k = String.valueOf(cs);
            if (map.containsKey(k)){
                List<String> res = map.get(k);
                res.add(str);
            }else{
                List<String> res = new ArrayList<String>();
                res.add(str);
                map.put(k, res);
            }
        }
        List<List<String>> results = new ArrayList<List<String>>();
        for (String k:map.keySet()) {
            results.add(map.get(k));
        }
        return results;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

    }
}
