package Ex02;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

/**
 * Created by Water Wood on 2017/9/17.
 */
public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        if (this.x == that.x && this.y == that.y) return Double.NEGATIVE_INFINITY;
        else if (this.y == that.y) return +0.0;
        else if (this.x == that.x) return Double.POSITIVE_INFINITY;
        else return (that.y - this.y) / (double) (that.x - this.x);
    }

    @Override
    public int compareTo(Point that) {
        int x0 = this.x;
        int y0 = this.y;
        int x1 = that.x;
        int y1 = that.y;
        if (y0 == y1) {
            if (x0 == x1)
                return 0;
            else if (x0 > x1)
                return 1;
            else
                return -1;
        } else if (y0 > y1)
            return 1;
        else
            return -1;
    }

    public Comparator<Point> slopeOrder() {
        return new SlopeOrder(this);
    }

    private class SlopeOrder implements Comparator<Point> {
        private final Point p0;

        public SlopeOrder(Point invokePoint) {
            this.p0 = invokePoint;
        }

        @Override
        public int compare(Point o1, Point o2) {
            double s1 = p0.slopeTo(o1);
            double s2 = p0.slopeTo(o2);
            return Double.compare(s1, s2);
        }
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public static void main(String[] args) {
        /* YOUR CODE HERE */
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        System.out.println("p1.compareTo(p2)=" + p1.compareTo(p2));
        System.out.println("p1.slopeTo(p2)=" + p1.slopeTo(p2));
        Point p3 = new Point(0, 4);
        System.out.println("p1.slopeTo(p3)=" + p1.slopeTo(p3));
        Point p4 = new Point(4, 4);
        System.out.println("p3.compareTo(p4)=" + p3.compareTo(p4));
        System.out.println("p3.slopeTo(p4)=" + p3.slopeTo(p4));
        Point p5 = new Point(0, 0);
        System.out.println("p1.slopeTo(p5)=" + p1.slopeTo(p5));
    }
}
