/**
 * Created by dengrongguan on 2017/2/20.
 */
public class RMB {
    private static final char[] data = new char[]{ '零','壹','贰','叁','肆','伍','陆','柒','捌','玖'
    };
    private static final char[] units = new char[]{
            '元','拾','佰','仟','万','拾','佰','仟','亿' };
    public static void main(String[] args){
        System.out.print(convert(201000));

    }

    public static String convert(int money){
        StringBuffer stringBuffer = new StringBuffer();
        int unit = 0;
        while(money != 0){
            stringBuffer.insert(0,units[unit++]);
            int number = money % 10;
            stringBuffer.insert(0,data[number]);
            money = money/10;
        }
//        return stringBuffer.toString();
        return stringBuffer.toString().replaceAll("零[拾佰仟]","零").replaceAll("零+万","万").replaceAll("零+元","元").replaceAll("零+","零");
    }
}
