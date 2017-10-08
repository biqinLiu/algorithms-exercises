package Ex01;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Counter;
/**
 * Created by Administrator on 2017/8/18.
 */
public class Ex012 {
    public static void main(String[] args) {
        //minDist(10);
        //1.2.4
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
        //1.2.7
        System.out.println(mystery("abcde"));

    }

    //1.2.1
    public static double minDist(int N) {
        Point2D[] point2D = new Point2D[N];
        StdDraw.setPenRadius(0.05);
        for (int i = 0; i < N; i++) {
            point2D[i] = new Point2D(Math.random(), Math.random());
            point2D[i].draw();
        }
        double min=0.0;
        if (N > 1) {
             min= point2D[0].distanceTo(point2D[1]);
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (point2D[i].distanceTo(point2D[j]) < min) {
                        min = point2D[i].distanceTo(point2D[j]);
                    }
                }
            }
        }
        System.out.println(min);
            return min;
        }
        //1.2.7
    public static String mystery(String s){
        int N = s.length();
        if(N<=1) return s;
        String a=s.substring(0,N/2);
        String b = s.substring(N / 2, N);
        return mystery(a) + mystery(b);
    }
    //arithmetic expression
    public static int evaluate(String s){
        Stack<Integer> number=new Stack<>();
        Stack<String> operator=new Stack<>();
        int result=0;
        return result;

    }


}
