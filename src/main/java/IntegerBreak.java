/**
 * Created by I322233 on 4/26/2016.
 */
public class IntegerBreak implements InterfaceTest,InterfaceTest2{
    public int integerBreak(int n){
        if(n < 4)return n-1;
        int res = 1;
        while(n > 2){//看n包含多少个3,把他们相乘,直到n<=2
            res *= 3;
            n -= 3;
        }
        if(n == 0) return res;//n可以整除3，res就是各个3相乘
        if(n == 1) return (res / 3 ) * 4;//除3余1，把其中的一个3加1变为4再相乘
        if(n == 2) return res * 2;//除3余2,则可直接把2与res相乘
        return 1;
    }
    public void test1(){

    }
    public static synchronized void test(){
        for(int i = 0;i<10;i++){
            System.out.println("test");
        }
        test2();
    }

    public static void test2(){
        for(int i = 0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":test2");
        }
    }
    public static void main(String[] args){

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IntegerBreak.test();
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                IntegerBreak.test2();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
