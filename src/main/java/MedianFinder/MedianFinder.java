package MedianFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengrong on 2016/11/2.
 * Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.

 For example:

 add(1)
 add(2)
 findMedian() -> 1.5
 add(3)
 findMedian() -> 2
 */
public class MedianFinder {
    // Adds a number into the data structure.
    List<Integer> numbers = new ArrayList<Integer>();
    public static void main(String[] args){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
    public void addNum(int num) {
        int position = 0;
        for(int i = 0;i<=numbers.size();i++){
            position = i;
            if(i == numbers.size()){
                break;
            }
            if(num <= numbers.get(i)){
                break;
            }
        }
        numbers.add(position,num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(numbers.size()%2 == 0){
            //偶数
            return (numbers.get(numbers.size()/2)+numbers.get(numbers.size()/2-1))/2.0;
        }else{
            //奇数
            return numbers.get((numbers.size()-1)/2);
        }
    }
}
