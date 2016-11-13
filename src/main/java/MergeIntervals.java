import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengrong on 2016/11/13.
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    class Interval{
        int start;
        int end;
        Interval(){
            start = 0;end = 0;
        }
        Interval(int s,int e){
            start = s;
            end = e;
        }
    }
    public static void main(String[] args){

    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> intervals1 = new ArrayList<Interval>();
        return intervals1;
    }

}
