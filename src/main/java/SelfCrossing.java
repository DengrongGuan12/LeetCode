import java.util.ArrayList;

/**
 * Created by I322233 on 5/24/2016.
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.

 Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.

 Example 1:
 Given x = [2, 1, 1, 2],
 ┌───┐
 │      │
 └───┼──>
 │

 Return true (self crossing)
 Example 2:
 Given x = [1, 2, 3, 4],
 ┌──────┐
 │          │
 │
 │
 └────────────>

 Return false (not self crossing)
 Example 3:
 Given x = [1, 1, 1, 1],
 ┌───┐
 │     │
 └───┼>

 Return true (self crossing)
 */
public class SelfCrossing {

    public static void main(String[] args){
        SelfCrossing s = new SelfCrossing();
        int[] x = {1, 1, 1, 1};
        if(s.isSelfCrossing(x)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    public boolean isSelfCrossing(int[] x) {
        ArrayList<Edge> edges = new ArrayList<Edge>();
//        ArrayList<Edge> horizonals = new ArrayList<Edge>();
        int i = 0;
        Point start = new Point();
        start.x = 0;
        start.y = 0;
        for (int step:
             x) {
            Edge edge = new Edge();
            edge.index = i;
            edge.start = start;
            Point end = new Point();
            switch (i%4){
                case 0:
                    end.x = start.x;
                    end.y = start.y+step;
                    edge.vertical = true;
                    break;
                case 1:
                    edge.vertical = false;
                    end.y = start.y;
                    end.x = start.x - step;
                    break;
                case 2:
                    edge.vertical = true;
                    end.x = start.x;
                    end.y = start.y - step;
                    break;
                case 3:
                    edge.vertical = false;
                    end.y = start.y;
                    end.x = start.x + step;
                    break;
            }
            edge.end = end;
            for (Edge h:
                    edges) {
                if(edge.isCrossed(h)){
                    return true;
                }
            }
            edges.add(edge);
            start = end;
            i++;
        }
        return false;

    }

    class Edge{
        Point start;
        Point end;
        int index;
        boolean vertical = true;//竖直
        public boolean isCrossed(Edge edge){
            if(edge.index == this.index-1){
                return false;
            }
            int max_x = Math.max(edge.start.x,edge.end.x);
            int min_x = Math.min(edge.start.x,edge.end.x);
            int this_max_x = Math.max(this.start.x,this.end.x);
            int this_min_x = Math.min(this.start.x,this.end.x);
            int this_max_y = Math.max(this.start.y,this.end.y);
            int this_min_y = Math.min(this.start.y,this.end.y);
            int min_y = Math.min(edge.start.y,edge.end.y);
            int max_y = Math.max(edge.start.y,edge.end.y);
            if(this.vertical){
                if(edge.vertical){
                    if(edge.start.x == this.start.x){
                        if(edge.start.y >= this_min_y && edge.start.y <= this_max_y){
                            return true;
                        }
                        if(edge.end.y >= this_min_y && edge.end.y <= this_max_y){
                            return true;
                        }
                        if(this.start.y >= min_y && this.start.y <= max_y){
                            return true;
                        }
                        if(this.end.y >= min_y && this.end.y <= max_y){
                            return true;
                        }
                    }
                }else{
                    if(this.start.x >=min_x  && this.start.x <= max_x && edge.start.y>= this_min_y && edge.start.y <= this_max_y){
                        return true;
                    }
                }
            }else{
                if(!edge.vertical){
                    if(edge.start.y == this.start.y){
                        if(edge.start.x >= this_min_x && edge.start.x <= this_max_x){
                            return true;
                        }
                        if(edge.end.x >= this_min_x && edge.end.x <= this_max_x){
                            return true;
                        }
                        if(this.start.x >= min_x && this.start.x <= max_x){
                            return true;
                        }
                        if(this.end.x >= min_x && this.end.x <= max_x){
                            return true;
                        }
                    }
                }else{
                    if(this.start.y >= min_y && this.start.y <= max_y && edge.start.x <= this_max_x && edge.start.x >= this_min_x){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    class Point{
        int x;
        int y;
    }
}
