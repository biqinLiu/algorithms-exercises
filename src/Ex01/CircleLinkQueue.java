package Ex01;

/**
 * Created by Administrator on 2017/8/22.
 */
public class CircleLinkQueue {
    private int N;
    private Node last;
    public boolean isEmpty(){return N==0;}
    public int size(){ return N;}

    public static void main(String[] args) {

    }

    private class Node<Item>{
        Item item;
        Node next;
    }

}
