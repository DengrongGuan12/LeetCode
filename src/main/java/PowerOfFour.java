/**
 * Created by I322233 on 4/26/2016.
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num){
        if(num == 1){
            return true;
        }
        int left = num%4;
        if(left != 0){
            return false;
        }
        int k = num/4;
        if(k == 0){
            return false;
        }
        return isPowerOfFour(k);
    }
}
