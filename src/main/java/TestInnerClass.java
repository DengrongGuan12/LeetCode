/**
 * Created by dengrongguan on 2017/2/18.
 */
public class TestInnerClass {
    int n;
    public class Inner{
        public int x;
        public void b(){
            int m = n+1;
        }
    }

    public void test(){
        final int a = 0;
        class Inner2{
            public void a(){
                int b = a+3;
            }
        }
    }

    public static class InnerStatic{

    }
}
