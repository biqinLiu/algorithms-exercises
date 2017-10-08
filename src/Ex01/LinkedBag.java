package Ex01;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/8/21.
 */
public class LinkedBag<Item> implements Iterable<Item> {
    private Node first;
    public void  add(Item i){
        Node oldFirst=first;
        first=new Node();
        first.item=i;
        first.next=oldFirst;
    }


    @Override
    public Iterator<Item> iterator() {
        return new LinkedBagIterator();
    }

    private class LinkedBagIterator implements Iterator<Item>{
        private Node current=first;
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
    private class Node{
        Node next;
        Item item;
    }
}
