package Ex01;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Water Wood on 2017/8/31.
 * @description: circular array, cost constant amortized time,code reference to java.util.ArrayDequeue
 */
public class ArrayDeque<Item> implements Iterable<Item> {
    private int head;//队首
    private int tail;//队尾
    private Item[] items;
    public ArrayDeque(){
        init();
    }
    private void init(){
        this.items=(Item[]) new Object[8];
        this.head=0;
        this.tail=0;
    }
    public boolean isEmpty(){
        return head==tail;
    }
    public int size(){
         return (tail - head) & (items.length - 1);
    }
    public void addFirst(Item i){
        if (i.equals(null)){
            throw new IllegalArgumentException();
        }
        items[head = (head - 1) & (items.length - 1)] = i;//2.下标是否越界
        if (head == tail)//1.空间是否够用
            resize(2*items.length);//扩容
        System.out.println(" head="+head+" tail="+tail);
        for(Item x:items){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    public void addLast(Item i){
        if (i.equals(null)){
            throw new IllegalArgumentException();
        }
        items[tail]=i;
        if ( (tail = (tail + 1) & (items.length - 1)) == head) resize(2*items.length);
        System.out.println(" head="+head+" tail="+tail);
        for(Item x:items){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public Item removeFirst(){
        int h = head;
        Item result = items[h]; // Element is null if deque empty
        if (result == null)
            throw new NoSuchElementException();
        items[h] = null;     // Must null out slot
        head = (h + 1) & (items.length - 1);

        System.out.println(" head="+head+" tail="+tail);
        for(Item x:items){
            System.out.print(x+" ");
        }
        System.out.println();
        return result;
    }
    public Item removeLast(){
        int t = (tail - 1) & (items.length - 1);
        Item result = items[t];
        if (result == null)
            throw new NoSuchElementException();
        items[t] = null;
        tail = t;

        System.out.println(" head="+head+" tail="+tail);
        for(Item x:items){
            System.out.print(x+" ");
        }
        System.out.println();
        return result;
    }
    private void resize(int max){
        Item[] tem=(Item[]) new Object[max];
        int n=items.length;
        for(int i=head,j=0;i<n;i++,j++){
            tem[j]=items[i];
        }
        for(int i=0,j=n-head;i<head;i++,j++)
        {
            tem[j]=items[i];
        }
        items=tem;
        head=0;
        tail=n;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ResizingDequeIterator();
    }
    private class ResizingDequeIterator implements Iterator<Item>{
        @Override
        public boolean hasNext() {
            return head!=tail;
        }

        @Override
        public Item next() {
            if(tail==head) throw new NoSuchElementException();
            Item result=items[head];
            head = (head + 1) & (items.length - 1);
            return result;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> qu = new ArrayDeque();
        qu.addFirst(1);
        qu.addFirst(2);
        qu.addLast(1);
        qu.addLast(2);
        for(Integer i:qu){
            System.out.println(i);
        }
    }
}
