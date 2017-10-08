package Ex03;

/**
 * Created by Water Wood on 2017/10/6.
 */
public class SequentialSearchST<Key,Value> {
    private Node first;
    private class Node{
        Key key;
        Value value;
        Node next;
        public Node(Key key,Value value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
    public Value get(Key key){
        for(Node x=first;x!=null;x=x.next){
            if(key.equals(x.key)){
                return x.value;
            }
        }
        return null;
    }
    public void put(Key key,Value value){
        for(Node x=first;x!=null;x=x.next){
            if(key.equals(x.key)){
                x.value=value;
                return;
            }
        }
        first=new Node(key,value,first);
    }
}
