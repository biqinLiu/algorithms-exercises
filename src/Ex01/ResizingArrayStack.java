package Ex01;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by Administrator on 2017/8/21.
 */
//动态调整数组大小保持数组大小和栈大小之比小于一个常数
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private int N=0;//栈大小
    private Item[] items;
    public ResizingArrayStack(int size){
         items= (Item[]) new Object[size];
    }
    public  boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(Item i){
        if(N==items.length) resize(2*items.length);
        items[N++]=i;
        System.out.println("N="+N+" ,array length="+items.length);
        for(Item x:items){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    public Item pop(){
        Item i=items[--N];
        items[N]=null;
        if(N>0 && N==items.length/4) resize(items.length/2);
        System.out.println("N="+N+" ,array length="+items.length);
        for(Item x:items){
            System.out.print(x+" ");
        }
        System.out.println();
        return i;
    }
    private void resize(int max){
        Item[] tem=(Item[]) new Object[max];
        for(int i=0;i<N;i++) tem[i]=items[i];
        items=tem;
    }
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return items[N];
    }
    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return items[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> s2=new ResizingArrayStack(1);
        System.out.println(s2.isEmpty());
        s2.push("to");
        s2.push("be");
        s2.push("or");
        s2.push("not");
        s2.push("to");
        s2.pop();
        s2.push("be");
        s2.pop();
        s2.pop();
        s2.pop();
    }
}
