package Ex01;

/**
 * Created by Administrator on 2017/8/21.
 */

//链表的一些操作
public class LinkedList<Item> {

    private static class Node<Item>{
        Item item;
        Node<Item> next;
        public Node(Item item){
            this.item=item;
            this.next=null;
        }
        //双向链表
        private static class DoubleNode<Item>{
            static int N;//大小
            Item item;
            DoubleNode<Item> pre;
            DoubleNode<Item> next;
            public static void addFirst(DoubleNode node,DoubleNode newNode){
                newNode.next=node;
                newNode.pre=node.pre;
                newNode.next.pre=node;
                newNode.pre.next=newNode;
                N++;
            }
            public static void deleteFirst(DoubleNode node){

            }
        }
    }



    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        String s="to be or not to be that is a question";
        String s1="to";
        String s2=" ";
        String s3=null;
        String[] split=l.splitString(s);
        Node<String> first=null;
        if (split.length>0) {
            first= new Node(split[0]);
        }
        Node temp=first;
        //构造链表
        for(int i=1;i<split.length;i++){
            temp.next=new Node(split[i]);
            temp=temp.next;
        }
        System.out.println("link list size: "+l.size(first));
        l.removeLast(first);
        l.removeK(1,first);
        l.findKey("question",first);
        Node kNode=l.getK(2,first);
        l.removeAfter(kNode,first);
        //遍历链表
        System.out.println("traverse link list:");
        while (first!=null){
            System.out.println(first.item);
            first=first.next;
        }

    }
    public String[] splitString(String s){
        String[] split=new String[]{};
        if (s!=null){
            split=s.split(" ");
        }else {
            System.out.println("String cannot be null");
        }
        return split;
    }
    //链表的大小
    public int size(Node first){
        int length=0;
        while (first!=null){
            length++;
            first=first.next;
        }
        return length;
    }
    //得到K位置的结点
    public Node getK(int k,Node first){
        if(k<=size(first)){
            for(int i=1;i<k;i++){
                first=first.next;
            }
        }else{
            System.out.println(k+" is bigger than link list's size");
        }
        return first;
    }

    //删除链表的尾结点
    public void removeLast(Node first){
        while (first.next!=null){
            first=first.next;
        }
        System.out.println("remove last item: "+first.item);
        first=null;
    }
    //删除链表的第K个元素
    public void removeK(int k,Node first){
        if(k<=size(first)){
        for(int i=1;i<k-1;i++) {
            first = first.next;
        }
            System.out.println("remove "+k+"th item: "+first.item);
        }else {
            System.out.println(k+" is bigger than link list's size");
        }

    }
    //查找key
    public boolean findKey(Item k,Node first){
        while (first.next!=null){
            first=first.next;
            if(first.item.equals(k)){
                System.out.println("find key: "+k.toString());
                return true;
            }
        }
        System.out.println("not find key: "+k.toString());
        return false;
    }
    //删除某结点的后一个结点
    public void  removeAfter(Node someNode,Node first){
        while (first!=null&&first.equals(someNode)==false){
            first=first.next;
            if(first.equals(someNode)){
                System.out.println("remove after node of"+someNode.item+" "+first.next.item);;
                first.next=first.next.next;
            }
        }
    }
    //在某个结点后插入另一个结点
    public void insertAfter(Node one,Node Two,Node first){

    }
    //删除item等于key的结点
    public void remove(Item key,Node first){
        while(first.next!=null){
            if(first.next.item.equals(key)){
                System.out.println("remove key:"+first.next.item);
                first.next=first.next.next;
            }
        }
    }
    //返回结点中最大的值,方法二可以用递归
    public int max(Node<Integer> first){
        int max=0;
        while (first!=null){
            if(first.item>max){
                max=first.item;
            }
            first=first.next;
        }
        return max;
    }
    //反转链表,返回首结点
    public Node reverse(Node first){
        if(first==null||first.next==null) return first;
        Node pre=null;
        Node nex=null;
        while (first!=null){
            nex=first.next;
            first.next=pre;
            pre=first;
            first=nex;
        }
        return pre;
    }
    //递归反转链表,返回首结点
    public Node reverseRec(Node first){
        if(first==null||first.next==null) return first;
        Node reHead=reverseRec(first.next);
        first.next.next=first;
        first.next=null;
        return reHead;
    }


}
