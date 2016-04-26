/**
 * Created by I322233 on 4/26/2016.
 */
public class CountBits {
    public int[] countBits(int num){
        int[] bits = new int[num+1];
        for(int i = 0;i<=num;i++){
            int tmp = 0;
            int a = i;
            while(a > 0){
                if(a%2 == 1){
                    tmp++;
                }
                a = a/2;
            }
            bits[i] = tmp;
        }
        return bits;
    }
}
