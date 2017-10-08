package Ex02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

/**
 * Created by Administrator on 2017/9/19.
 */
public class CollinearClient {
    public static void main(String[] args) {

        // read the n points from a file
        //src/main/resources/input6.txt
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.setPenRadius(0.01);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();
        // print and draw the line segments FastCollinearPoints
        FastCollinearPoints fast = new FastCollinearPoints(points);
        BruteCollinearPoints brute = new BruteCollinearPoints(points);
        for (LineSegment segment : fast.segments()) {
            StdDraw.setPenRadius(0.002);
            segment.draw();
        }
        StdDraw.show();
    }
}
