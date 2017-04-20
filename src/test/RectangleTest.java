import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dengrongguan on 2017/3/20.
 */
public class RectangleTest {
    @org.junit.Test
    public void setHeight() throws Exception {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(1.236);
        assertEquals(1.23,rectangle.getHeight(),0.0001F);
    }

    @Test
    public void setWidth() throws Exception {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(1.236);
        assertEquals(1.23,rectangle.getWidth(),0.0001F);
    }

    @Test
    public void calArea() throws Exception {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(75);
        rectangle.setWidth(100);
        rectangle.calArea();
        assertEquals(0,rectangle.getArea(),0001F);
        rectangle.setWidth(1.236);
        rectangle.setHeight(1);
        rectangle.calArea();
        assertEquals(1.23,rectangle.getArea(),0.0001F);
        rectangle.setWidth(1.24);
        rectangle.setHeight(0.2);
        rectangle.calArea();
        assertEquals(0.25,rectangle.getArea(),0.0001F);

    }

    @Test
    public void calLength() throws Exception {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(75);
        rectangle.setWidth(100);
        rectangle.calLength();
        rectangle.setWidth(1.236);
        rectangle.setHeight(1);
        rectangle.calArea();
        assertEquals(1.23,rectangle.getArea(),0.0001F);
        rectangle.setWidth(1.24);
        rectangle.setHeight(0.2);
        rectangle.calArea();
        assertEquals(0.25,rectangle.getArea(),0.0001F);
    }

}