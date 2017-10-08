package Ex02;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Water Wood on 2017/9/16.
 */
public class Quick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void sort(Comparable[] a,int lo,int hi){
        while (hi<=lo) return;
        int j = partition(a, lo, hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    public static int partition(Comparable[] a,int lo,int hi){
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i],v))  break;
            while (less(v,a[--j]))  break;
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.print();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a={"b","c","e","a"};
        sort(a);
        assert isSorted(a);
        show(a);
    }


}
