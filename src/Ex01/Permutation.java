package Ex01;


import edu.princeton.cs.algs4.StdIn;

/**
 * Created by Administrator on 2017/8/31.
 */
public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            System.out.println(q.dequeue());
        }
    }
}
