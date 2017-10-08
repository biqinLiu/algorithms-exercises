package Ex02;

import edu.princeton.cs.algs4.*;

/**
 * Created by Water Wood on 2017/9/12.
 */
public class SortCompare {
    public static double time(String alg,Double[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
        if(alg.equals("Merge")) MergeTD.sort(a);
        if(alg.equals("Quick")) Quick.sort(a);
        if(alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg,int N,int T){
        double total=0.0;
        Double[] a = new Double[N];
        for(int t=0;t<T;t++){
            for(int i=0;i<N;i++){
                a[i] = StdRandom.uniform();
            }
            total+=time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String arg1 = args[0];
        String arg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(arg1, N, T);
        double t2 = timeRandomInput(arg2, N, T);
        System.out.println(t1);
        System.out.println(t2);
        StdOut.printf("For %d random doubles\n  %s is ",N,arg1);
        StdOut.printf("%.1f times faster than %s",t2/t1,arg2 );
    }

}
