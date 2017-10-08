package Ex01;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by Administrator on 2017/8/30.
 */
public class StdDrawTest {
    public static void main(String[] args) {
        int n=10;
        StdDraw.clear();
        StdDraw.setCanvasSize(258,258);
        StdDraw.setScale(-0.05*n,1.05*n);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.line(1,0,9,0);
        StdDraw.line(1,10,9,10);
        StdDraw.line(0,1,0,9);
        StdDraw.line(10,1,10,9);
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(5,5);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.circle(5,5,2);
        StdDraw.filledCircle(5,5,1);


    }
}
