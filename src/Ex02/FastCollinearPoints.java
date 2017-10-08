package Ex02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FastCollinearPoints {

    private Point[] points;
    private final LineSegment[] segments;
    private int segNum;

    private List<PointPair> pointPairList;

    private class PointPair {
        private final Point smallPoint;
        private final Point largePoint;
        private final double slope;

        public PointPair(Point smallPoint, Point largePoint) {
            this.smallPoint = smallPoint;
            this.largePoint = largePoint;
            this.slope = largePoint.slopeTo(smallPoint);
        }

        public Point getLargePoint() {
            return this.largePoint;
        }

        public Point getSmallPoint() {
            return this.smallPoint;
        }

        public double getSlope() {
            return this.slope;
        }

        public int compareTo(PointPair that) {
            Point l1 = this.getLargePoint();
            Point l2 = that.getLargePoint();
            double s1 = this.getSlope();
            double s2 = that.getSlope();
            if (l1.compareTo(l2) > 0) return 1;
            else if (l1.compareTo(l2) < 0) return -1;
            else {
                if (s1 > s2) return 1;
                else if (s1 < s2) return -1;
                else return 0;
            }
        }

        public Comparator<PointPair> pointPairComparator() {
            return new PointPairComparator();
        }

        private class PointPairComparator implements Comparator<PointPair> {
            @Override
            public int compare(PointPair pp1, PointPair pp2) {
                // TODO Auto-generated method stub
                Point l1 = pp1.getLargePoint();
                Point l2 = pp2.getLargePoint();
                double s1 = pp1.getSlope();
                double s2 = pp2.getSlope();
                if (l1.compareTo(l2) > 0) return 1;
                else if (l1.compareTo(l2) < 0) return -1;
                else {
                    return Double.compare(s1, s2);
                }
            }
        }
    }

    public FastCollinearPoints(Point[] inpoints) {
        // finds all line segments containing 4 or more points
        if (inpoints == null)
            throw new IllegalArgumentException("Constructor argument Point[] is null!");
        // finds all line segments containing 4 points
        for (int i = 0; i < inpoints.length; i++) {
            if (inpoints[i] == null)
                throw new IllegalArgumentException("there is null in constructor argument");
        }
        points = new Point[inpoints.length];
        for (int i = 0; i < inpoints.length; i++) {
            points[i] = inpoints[i];
        }
        Arrays.sort(points);
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0)
                throw new IllegalArgumentException("there exists repeated points!");
        }
        findPointPairForLineSegment(points);
        segments = generateLineSegment();
    }

    private void findPointPairForLineSegment(Point[] points) {
        int pNum = points.length;
        pointPairList = new ArrayList<PointPair>();
        for (int i = 0; i < pNum - 3; i++) {
            Point origin = points[i];
            Point[] tPoints = new Point[pNum - i - 1];
            int tpNum = 0;
            for (int j = i + 1; j < pNum; j++) {
                tPoints[tpNum++] = points[j];
            }
            Arrays.sort(tPoints, origin.slopeOrder());
            int startPostion = 0;
            double slope = 0.0;
            for (; startPostion < tpNum - 1; startPostion++) {
                slope = origin.slopeTo(tPoints[startPostion]);
                if (origin.slopeTo(tPoints[startPostion + 1]) == slope) {
                    break;
                } else {
                    continue;
                }
            }
            int currentPosition = startPostion + 1;
            for (; currentPosition < tpNum; currentPosition++) {
                if (origin.slopeTo(tPoints[currentPosition]) == slope) {
                    continue;
                } else {
                    break;
                }
            }
            if (currentPosition - startPostion >= 3) {
                PointPair pp = new PointPair(origin, tPoints[currentPosition - 1]);
                pointPairList.add(pp);
            }
        }
    }


    private LineSegment[] generateLineSegment() {
        int ppsize = pointPairList.size();
        if (ppsize == 0) return new LineSegment[0];
        ;
        PointPair[] pointPairs = new PointPair[ppsize];
        int i = 0;
        for (PointPair pp : pointPairList) {
            pointPairs[i++] = pp;
        }
        pointPairList.clear();
        Arrays.sort(pointPairs, pointPairs[0].pointPairComparator());
        List<LineSegment> lineSegmentList = new ArrayList<LineSegment>();

        PointPair ppls = pointPairs[0];
        for (i = 1; i < ppsize; i++) {
            if (ppls.compareTo(pointPairs[i]) == 0) {
                Point s = pointPairs[i].getSmallPoint();
                if (ppls.getSmallPoint().compareTo(s) > 0)
                    ppls = pointPairs[i];
            } else {
                LineSegment seg = new LineSegment(ppls.getSmallPoint(), ppls.getLargePoint());
                lineSegmentList.add(seg);
                ppls = pointPairs[i];
            }
        }
        LineSegment seg = new LineSegment(ppls.getSmallPoint(), ppls.getLargePoint());
        lineSegmentList.add(seg);

        LineSegment[] segments = new LineSegment[lineSegmentList.size()];
        segNum = 0;
        for (LineSegment ls : lineSegmentList) {
            segments[segNum++] = ls;
        }
        return segments;
    }

    public int numberOfSegments() {
        // the number of line segments
        return segNum;
    }

    public LineSegment[] segments() {
        // the line segments
        LineSegment[] retseg = new LineSegment[segNum];
        for (int i = 0; i < segNum; i++) {
            retseg[i] = segments[i];
        }
        return retseg;
    }
}