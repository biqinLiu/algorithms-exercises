package Ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class BruteCollinearPoints {
    private LineSegment[] lineSegments;
    private final Point[] pointsFinal;

    //finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        if (hasNullPoint(points) || hasRepeatPoint(points)) throw new IllegalArgumentException();
        pointsFinal = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointsFinal[i] = points[i];
        }
        findSegments(pointsFinal);
    }

    private void findSegments(Point[] points) {
        List<LineSegment> lines = new ArrayList();
        LineSegment lineSe;
        double x, y, z;
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int m = j + 1; m < points.length - 1; m++) {
                    for (int n = m + 1; n < points.length; n++) {
                        x = points[i].slopeTo(points[j]);
                        y = points[i].slopeTo(points[m]);
                        z = points[i].slopeTo(points[n]);
                        if (x == y && x == z && y == z) {
                            Point start = findLineStart(points[i], points[j], points[m], points[n]);
                            Point end = findLineEnd(points[i], points[j], points[m], points[n]);
                            lineSe = new LineSegment(start, end);
                            lines.add(lineSe);
                        }
                    }
                }
            }
        }
        lineSegments = new LineSegment[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            lineSegments[i] = lines.get(i);
        }
    }

    private boolean hasNullPoint(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) return true;
        }
        return false;
    }

    private boolean hasRepeatPoint(Point[] points) {
        Arrays.sort(points);
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) return true;
        }
        return false;
    }

    private Point findLineStart(Point x, Point y, Point m, Point n) {
        Point min = x;
        if (min.compareTo(y) > 0) min = y;
        if (min.compareTo(m) > 0) min = m;
        if (min.compareTo(n) > 0) min = n;
        return min;
    }

    private Point findLineEnd(Point x, Point y, Point m, Point n) {
        Point max = x;
        if (max.compareTo(y) < 0) max = y;
        if (max.compareTo(m) < 0) max = m;
        if (max.compareTo(n) < 0) max = n;
        return max;
    }

    //the number of line segments
    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        LineSegment[] segments = new LineSegment[lineSegments.length];
        int i = 0;
        for (LineSegment seg : lineSegments) {
            segments[i++] = seg;
        }
        return segments;
    }

}
