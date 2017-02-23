import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by dengrongguan on 2017/2/23.
 */
public class TestCountDownLatch {
    private static final int THREAD_NUM = 5;
    public static class WorkerThread implements Runnable{

        private final CountDownLatch countDownLatch;
        WorkerThread(CountDownLatch countDownLatch){
            this.countDownLatch =countDownLatch;

        }


        public void run() {
            // TODO Auto-generated method stub
            try{
                System.out.println("Worker's waiting");
                //线程在这里等待，直到所有线程都到达barrier。
                countDownLatch.await();
                System.out.println("ID:"+Thread.currentThread().getId()+" Working");
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
        for(int i=0;i<10;i++){
            new Thread(new WorkerThread(countDownLatch)).start();
        }
        for(int i = 0;i<4;i++){
            countDownLatch.countDown();
        }
    }
}
