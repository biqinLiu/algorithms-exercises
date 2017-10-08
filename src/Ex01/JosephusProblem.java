package Ex01;

import java.util.Queue;

/**
 * Created by Administrator on 2017/8/21.
 */
public class JosephusProblem {

    //方法一：队列
    public static void queueMethod(int m, int n){
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        for(int i=0;i<n;i++){
            queue.enqueue(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < m - 1; i++) {
                queue.enqueue(queue.dequeue());
                System.out.print(queue.dequeue() + " ");
            }
        }
    }

    public static void main(String[] args) {
        int m=2;//第几个出局
        int n=7;//人数
        queueMethod(2,7);
    }


}
