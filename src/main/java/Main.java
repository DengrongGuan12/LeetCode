import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dengrongguan on 2017/2/18.
 */
public class Main {
    public static void main(String[] args){
        TestInnerClass testInnerClass = new TestInnerClass();
        TestInnerClass.Inner inner = testInnerClass.new Inner();
        TestInnerClass.InnerStatic innerStatic = new TestInnerClass.InnerStatic();
        System.out.println(test());
        System.out.println(x);

    }
    static int x = 1;
    public static int test(){
        try{
//            new Thread(){
//                @Override
//                public void run() {
//                    super.run();
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.start();
            assert x == 0;
            return x;

        }finally {
            ++x;
        }
    }
    interface A{
        int x = 0;
    }
    class B{
        int x = 1;
    }
    class C extends B implements A{
        void p(){
            System.out.println(A.x);
        }
    }
}
