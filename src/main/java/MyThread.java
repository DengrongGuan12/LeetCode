/**
 * Created by dengrongguan on 2017/2/23.
 */
class ViewData {

    private Object lock=new Object();

    public void viewData(String data){
//        synchronized (lock){
            for(int i=0;i<10;i++) {

                System.out.println(data);

//            }
        }

    }

}

 public class MyThread extends Thread{

        private ViewData vd;

        public MyThread(ViewData vd)

        {

            this.vd=vd;

        }

        public void run(){

            while(true){

                try{

                    Thread.sleep(10);

                }catch(Exception e){

                    e.printStackTrace();

                }

                //执行

                vd.viewData("zhangsanzhangsan");

            }

        }



//main函数--执行

        public static void main(String[] args) {

            ViewData vd=new ViewData();

            MyThread mtd1=new MyThread(vd);

            MyThread mtd2=new MyThread(vd);

            mtd1.start();

            mtd2.start();

            //可以尝试 将ViewData中的Synchronized关键字去掉  看一下数据的脏读

        }
}
