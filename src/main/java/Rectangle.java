import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by dengrongguan on 2017/3/20.
 */
public class Rectangle {
    private double height=0;
    private double width=0;
    private double area=0;//面积
    private double length=0;//长度
    public void setHeight(double height){
        if(height>0 && height<75){
            this.height = this.formatWithNoUp(height);
        }
    }
    public void setWidth(double width){
        if(width>0 && width<=100){
            this.width = this.formatWithNoUp(width);
        }
    }
    private double formatWithUp(double d){
        BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.HALF_UP);
        return bg.doubleValue();
    }
    private double formatWithNoUp(double d){
        BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.DOWN);
        return bg.doubleValue();
    }
    public void calArea(){
        this.area = this.formatWithUp(this.width * this.height);
    }
    public void calLength(){
        this.length = this.formatWithUp((this.width+this.height)*2);
    }

    public double getHeight(){
        return this.height;
    }
    public double getWidth(){
        return this.width;
    }
    public double getArea(){
        return this.area;
    }
    public double getLength(){
        return this.length;
    }
}
