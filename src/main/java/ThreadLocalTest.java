import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by dengrongguan on 2017/2/27.
 */
public class ThreadLocalTest extends AbstractClassTest{
    public static void main(String[] args){
        final ThreadLocal<Boolean> threadLocal = new ThreadLocal<Boolean>();
        threadLocal.set(false);
        new Thread(new Runnable() {
            public void run() {
                threadLocal.set(true);
                System.out.print(Thread.currentThread().getName()+":"+threadLocal.get());
            }
        }).start();
        System.out.println("main thread:"+threadLocal.get());
        new ThreadLocalTest().test();

    }

    public void test() {
        new AbstractClassTest() {
            public void test() {
                System.out.println("what");
            }
        }.test();

    }
}
