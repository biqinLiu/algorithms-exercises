package Ex01;


/**
 * Created by Administrator on 2017/8/23.
 */
public class CircularBuffer<Item> {
    private int putIndex=0;
    private int getIndex=0;
    private Item[] buffer;
    private int capacity;

    public CircularBuffer(int capacity){
        this.capacity=capacity;
        this.buffer=(Item[])new Object[capacity];
    }
    public int size(){
        return capacity;
    }
    public boolean isEmpty(){
        return capacity==0;
    }
    public boolean putElement(Item item){
        if(item==null){
            throw new NullPointerException();
        }
        if(buffer[putIndex]!=null){
            return false;
        }
        buffer[putIndex++]=item;
        putIndex%=capacity;
        return true;
    }
    public Item getElement(){
        if(buffer[getIndex]==null){
            return null;
        }
        Item tep=buffer[getIndex];
        buffer[getIndex]=null;
        getIndex++;
        getIndex%=capacity;
        return tep;
    }


}
