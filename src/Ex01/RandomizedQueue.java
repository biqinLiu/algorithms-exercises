package Ex01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/8/23.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;//队列大小
    private Item[] items;

    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (items.length == n) resize(2 * items.length);
        items[n++] = item;
        System.out.println("N=" + n);
        for (Item x : items) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    //随机选一个元素和head交换，然后删除
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        int x = StdRandom.uniform(0, n);
        Item temp = items[n - 1];
        items[n - 1] = items[x];
        items[x] = temp;
        Item item = items[n - 1];
        items[n - 1] = null;
        n--;
        if (n > 0 && n == items.length / 4) resize(items.length / 2);
        System.out.println("N=" + n);
        for (Item i : items) {
            System.out.print(i + " ");
        }
        System.out.println();
        return item;
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        int x = StdRandom.uniform(0, n);
        return items[x];
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        int i;
        int[] random;

        public QueueIterator() {
            i = n - 1;
            random = new int[n];
            for (int j = 0; j < n; j++) {
                random[j] = j;
            }
            StdRandom.shuffle(random);
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int j = random[i--];
            return items[j];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.isEmpty();//     ==> true
        rq.enqueue(703);
        rq.dequeue();//     ==> 703
        System.out.println(rq.size());//        ==> 0
        rq.enqueue(343);//
        rq.dequeue();//     ==> 343
        rq.isEmpty();//     ==> true
        rq.enqueue(961);
        for (Integer i : rq) {
            System.out.println(i);
        }
    }
}
