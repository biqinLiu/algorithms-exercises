package Ex01;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ResizingArrayQueue<Item> implements Iterable<Item>{
    private int N;//队列大小
    private int head;//队首
    private int tail;//队尾
    private Item[] items;

    public ResizingArrayQueue(){
        items=(Item[]) new Object[2];
        head=0;
        tail=0;
        N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item i){
        if(N==items.length) resize(2*items.length);
        items[tail++]=i;
        N++;
        System.out.println("N="+N+" head="+head+" tail="+tail);
        for(Item x:items){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    public Item dequeue(){
        Item i = items[head];
        items[head] = null;
        head++;
        N--;
        if(N>0&&N==items.length/4) resize(items.length/2);
        System.out.println("N="+N+" head="+head+" tail="+tail);
        for(Item x:items){
            System.out.print(x+" ");
        }
        System.out.println();
        return i;
    }
    private void resize(int max){
        Item[] tem=(Item[])new Object[max];
        for(int i=0;i<N;i++){
            tem[i] = items[i];
        }
        items=tem;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResizingQueueIterator();
    }
    private class ResizingQueueIterator implements Iterator<Item>{
        @Override
        public boolean hasNext() {
            return N==0;
        }

        @Override
        public Item next() {
            return items[tail];
        }
        @Override
        public void remove() {
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> qu = new ResizingArrayQueue();
        qu.enqueue("to");
        qu.enqueue("be");
        qu.enqueue("or");
        qu.enqueue("not");
        qu.enqueue("to");
        qu.dequeue();
        qu.enqueue("be");
        qu.dequeue();
        qu.dequeue();
    }
}
