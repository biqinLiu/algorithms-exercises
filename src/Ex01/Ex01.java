package Ex01;

/**
 * Created by Administrator on 2017/8/17.
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Ex01 {
    public static void main(String[] args) {
        //1.1.1
        System.out.println((0+15)/2);
        System.out.println(2.0e-6*100000000.1);
        System.out.println(true&&false||true&&true);
        //1.1.2
        System.out.println((1+2.236)/2);
        System.out.println(1+2+3+4.0);
        System.out.println(4.1>=4);
        System.out.println(1+2+"3");
        //1.1.3
        int a = 1, b = 2, c = 3;
        if(a==b&&b==c) {System.out.println("equal");}
        else {System.out.println(" not equal");}
        //1.1.4
        if (a>b) c=0 ; else System.out.println("else");
        //1.1.5
        System.out.println(checkBetween(0.1,0.2));
        //1.1.6
        int f=0,g=1;
        for(int i=0;i<=15;i++){
            System.out.print(f+" ");
            f=f+g;
            g=f-g;
        }
        //1.1.7a
        double t = 9.0;
        while (Math.abs(t-9.0/t)>.001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n",t);
        //1.1.7b
        int sum = 0;
        for(int i=1;i<1000;i++){
            for(int j=0;j<i;j++){
                sum++;
            }
        }
        StdOut.println(sum);
        //1.1.7c
        int sum2=0;
        for(int i=1;i<1000;i*=2){
            for(int j=0;j<1000;j++){
                sum2++;
            }
        }
        StdOut.println(sum2);
        //1.1.8
        System.out.println('b');
        System.out.println('b'+'c');
        System.out.println('a'+4);
        System.out.println((char)('a'+4));
        //1.1.9
        System.out.println(Int2Binary(11));
        System.out.println(Integer.toBinaryString(11));
        //1.1.11
        boolean[][] matrix = new boolean[][]{{true, true, false}, {true, false, false}, {false, false, false}};
        printBooleanMatrix(matrix);
        //1.1.12
        int[] a12 = new int[10];
        for(int i=0;i<10;i++){
            a12[i] = 9 - i;
        }
        for(int i=0;i<10;i++){
            a12[i]=a12[a12[i]];
        }
        for(int i=0;i<10;i++){
            System.out.print(a12[i]+" ");
        }
        //1.1.13
        int[][] a13 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        transposeMatrix(a13);
        //1.1.14
        System.out.println(lg(1025));
        //1.1.15
        int[] aa15 = new int[]{0, 1, 1, 2, 2, 2, 3, 3, 3, 3};
        int[] a15=histogram(aa15,4);
        //1.1.16
        exR2(3);
        //1.1.18
        int a18=mystery(2,25);
        System.out.println(a18);
        //1.1.26
        sort3(4,3,2);
        //1.1.31
        StdDraw.circle(0.5, 0.5, 0.5);
        StdDraw.setPenRadius(0.05);
        int N=10;
        double p=0.5;
        Point[] points = new Point[N];
        double angle = 360.0 / N;
        for (int i = 0; i < N; i++) {
            points[i] = new Point(0.5 + 0.5 * Math.cos(angle * i * Math.PI / 180),
                    0.5 + 0.5 * Math.sin(angle * i * Math.PI / 180));
            StdDraw.point(points[i].x, points[i].y);
        }
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(Color.GRAY);
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
                }
            }
        }
    }


    public static boolean checkBetween(double x, double y){
        if(0<x&&x<1&&0<y&&y<1) return true; else return false;
    }
    public static String Int2Binary(int n){
        if(n==0){
            return "0";
        }
        String s="";
        int remainder;
        while(n>0){
            remainder=n%2;
            s=remainder+s;
            n=n/2;
        }
        return s;
    }
    public static void printBooleanMatrix(boolean[][] matrix){
        System.out.print(' ');
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(i);
        }
        System.out.println();
        for(int i=0;i<matrix.length;i++){
            System.out.print(i);
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]? '*':' ');
            }
            System.out.println();
        }
    }
    public static void transposeMatrix(int[][] matrix){
        System.out.println("\nbefore transposition");
        int M = matrix.length;
        int N = matrix[1].length;
        int[][] matrixNew = new int[N][M];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
                matrixNew[j][i] = matrix[i][j];
            }
            System.out.println();
        }
        System.out.println("after transposition");
        for(int i=0;i<matrixNew.length;i++){
            for(int j=0;j<matrixNew[i].length;j++){
                System.out.print(matrixNew[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int lg(int N){
        int x=0;
        int i=2;
        while(i<N){
            x++;
            i*=2;
        }
        return x;
    }
    public static int[] histogram(int[] a,int M){
        int[] result = new int[M];
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(numMap.keySet().contains(a[i]))  numMap.put(a[i],numMap.get(a[i])+1);
            else numMap.put(a[i], 1);
        }
        for(int key:numMap.keySet()){
            result[key] = numMap.get(key);
        }
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        return result;
    }
    public static String exR2(int n){
        System.out.println(" ");
        if(n<=0) return " ";
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        System.out.println(s);
        return s;
    }
    public static int mystery(int a,int b){
        if(b==0) return 0;
        if(b%2==0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static double calculateln(int N){
        if(N==0) return  0;
        else return Math.log(N) + calculateln(N - 1);
    }
    public static void sort3(int a,int b,int c){
        int t;
        if(a>b) {
            t=a;
            a=b;
            b=t;
        }
        if(a>c){
            t=a;
            a=c;
            c=t;
        }
        if(b>c){
            t=b;
            b=c;
            c=t;
        }
        System.out.println("a="+a+" b="+b+" c="+c);
    }
}
class Point{
    double x, y;
    public Point(double x,double y) {
        this.x = x;
        this.y = y;
    }

}
