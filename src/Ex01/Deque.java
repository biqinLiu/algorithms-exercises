package Ex01;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Water Wood on 2017/9/10.
 *
 * @description: linkedList implementation,cost constant time in worst case,code refer to java.util.LinkedList
 */
public class Deque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int N;

    public Deque() {

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item i) {
        if (i == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> f = head;
        Node<Item> newNode = new Node<>(i, null, f);
        head = newNode;
        if (f == null)
            tail = newNode;
        else
            f.pre = newNode;
        N++;
    }

    public void addLast(Item i) {
        if (i == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> last = tail;
        Node<Item> newNode = new Node<>(i, last, null);
        tail = newNode;
        if (last == null)
            head = newNode;
        else
            last.next = newNode;
        N++;
    }

    public Item removeFirst() {
        Node<Item> f = head;
        if (f == null)
            throw new NoSuchElementException();
        Item i = f.item;
        Node<Item> next = f.next;
        f.item = null;
        head = next;
        if (next == null)
            tail = null;
        else
            next.pre = null;
        N--;
        return i;
    }

    public Item removeLast() {
        Node<Item> last = tail;
        if (last == null)
            throw new NoSuchElementException();
        Item i = last.item;
        Node<Item> pre = last.pre;
        last.item = null;
        tail = pre;
        if (pre == null)
            head = null;
        else
            pre.next = null;
        N--;
        return i;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node<Item> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) throw new NoSuchElementException();
            Item i = current.item;
            current = current.next;
            return i;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    private static class Node<Item> {
        Item item;
        Node<Item> pre;
        Node<Item> next;

        public Node(Item item, Node<Item> pre, Node<Item> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        Deque<Integer> qu = new Deque<Integer>();
        qu.addFirst(0);
        for (Integer i : qu) {
            System.out.print(i);
        }
        qu.addFirst(1);
        for (Integer i : qu) {
            System.out.print(i);
        }
      /*  qu.addFirst(2);
        for (Integer i : qu) {
            System.out.print(i);
        }
        qu.addFirst(3);
        qu.addFirst(4);
        System.out.println(qu.removeLast());
        qu.addFirst(6);
        System.out.println(qu.removeLast());
        System.out.println(qu.removeFirst());
        System.out.println(qu.removeFirst());
        for (Integer i : qu) {
            System.out.println(i);
        }*/
    }
}

