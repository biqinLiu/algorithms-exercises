package Ex01;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/8/21.
 */
//链式,Node变为静态的
public class LinkedStack<Item> implements Iterable<Item>{
    private Node<Item> first;
    private int N;
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    //表头插入
    public void push(Item i){
       Node oldfirst=first;
       first=new Node();
       first.item=i;
       first.next=oldfirst;
       N++;
    }
    //表头删除
    public Item pop(){
        Item i=first.item;
        first=first.next;
        N--;
        return i;
    }
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    private static class Node<Item>{
        Item item;
        Node next;
    }
    private class LinkedStackIterator implements Iterator<Item>{
        private Node<Item> current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        String test="to be or not to - be - - that - - - is";
        LinkedStack<String> stack=new LinkedStack<String>();
        String[] split=test.split(" ");
        for(String s:split){
            if(!s.equals("-")){
                stack.push(s);
            }else if(!test.isEmpty()){
                System.out.println(stack.pop()+" ");
            }
        }
        System.out.println(stack.size()+" left on the stack");
        edu.princeton.cs.algs4.LinkedStack stack2=null;
    }
}
