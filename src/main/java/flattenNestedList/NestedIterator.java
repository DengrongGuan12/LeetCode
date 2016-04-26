package flattenNestedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by I322233 on 4/26/2016.
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> nestedList = new ArrayList<Integer>();
    private int position = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        init(nestedList);
    }
    private void init(List<NestedInteger> nestedList){
        for(NestedInteger nestedInteger:nestedList){
            if(nestedInteger.isInteger()){
                this.nestedList.add(nestedInteger.getInteger());
            }else{
                init(nestedInteger.getList());
            }
        }
    }
    public boolean hasNext() {
        if(nestedList.size()-1 >= position){
            return true;
        }
        return false;
    }

    public Integer next() {
        int a =  nestedList.get(position);
        position++;
        return a;
    }
}
