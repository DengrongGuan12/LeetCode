/**
 * Created by dengrongguan on 2017/3/29.
 */
public class Fib {
    private static final int ERROR = -1;
    public static int fib(int i){
        if(i == 0 || i == 1){
            return i;
        }else{
            return ERROR;
        }
    }
}
