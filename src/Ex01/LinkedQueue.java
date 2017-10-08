package Ex01;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/8/21.
 */
public class LinkedQueue<Item> implements Iterable<Item>{
    private int N;
    private Node head;
    private Node tail;

    public LinkedQueue(){

    }

    //复制队列
    public LinkedQueue(LinkedQueue<Item> q){
        LinkedQueue r=new LinkedQueue();
        System.out.println("coping queue");
        Item[] items=(Item[])new Object[q.size()];
        for(int i=0;i<=q.size();i++){
            items[i]=q.dequeue();
        }
        for(int i=0;i<items.length;i++) {
            r.enqueue(items[i]);
            q.enqueue(items[i]);
        }
        this.head=r.head;
        this.tail=r.tail;
        this.N=r.N;
    }

    public boolean isEmpty(){return N==0;}
    public int size(){ return N;}
    //表尾插入
    public void enqueue(Item i){
        Node oldTail=tail;
        tail=new Node();
        tail.item=i;
        tail.next=null;
        if(isEmpty()) head=tail;
        else oldTail.next=tail;
        N++;
    }
    //表头删除
    public Item dequeue(){
       Item i=head.item;
       head=head.next;
       if(isEmpty()) tail=null;// to avoid loitering,防止指针闲荡
       N--;
       return i;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class Node{
        Item item;
        Node next;
    }
    private class LinckedQueueIterator implements Iterator<Item>{
        private Node current=tail;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item i=current.item;
            current=current.next;
            return i;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        String test="to be or not to - be - - that - - - is";
        LinkedQueue<String> queue=new LinkedQueue<String>();
        String[] split=test.split(" ");
        for(String s:split){
            if(!s.equals("-")){
                queue.enqueue(s);
            }else if(!test.isEmpty()){
                System.out.println(queue.dequeue()+" ");
            }
        }
        System.out.println(queue.size()+" left on the queue");
/*        while (queue.head!=null){
            System.out.println(queue.head.item);
            queue.head=queue.head.next;
        }*/
        LinkedQueue r=new LinkedQueue(queue);
        while (r.head!=null){
            System.out.println(r.dequeue());
        }
    }
}
