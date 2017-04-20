/**
 * Created by dengrongguan on 2017/3/8.
 */
public class EqualsTest {
    public static void main(String[] args){
        Student a = new Student("a");
        Student b = new Student("a");
        String str1 = "a";
        String str2 = "a";
        String s1 = new String("a");
        String s2 = new String("a");
        System.out.println(a.equals(b));
        System.out.println(str1.equals(str2));
        System.out.println(s1.equals(s2));
    }

}
class Student{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Student(String name){
        this.name = name;
    }

    private String name;

}
