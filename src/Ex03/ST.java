package Ex03;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/9/30.
 */
public class ST <Key extends Comparable<Key>,Value>{
    public ST(){

    }
    public void put(Key key,Value val){

    }
    public Value get(Key key){
        return null;
    }
    public void delete(Key key){

    }
    public boolean contains(Key key){
        return false;
    }

    public boolean isEmpty(){
        return false;
    }
    public int size(){
        return 0;
    }
    public Key min(){
        return null;
    }
    public Key max(){
        return null;
    }
    public Key floor(Key key){
        return null;
    }
    public Key ceiling(Key key){
        return null;
    }
    public int rank(Key key){
        return 0;
    }
    public Key select(int k){
        return null;
    }
    public void deleteMin(){

    }

    public void deleteMax(){

    }
    public int size(Key lo,Key hi){
        return 0;
    }

    public Iterable<Key> keys(Key lo,Key hi){
        return null;
    }
    public Iterable<Key> keys(){
        return null;
    }

    public static void main(String[] args) {
        ST<String,Integer> st;
        st=new ST<String, Integer>();
        for(int i=0;!StdIn.isEmpty();i++){
            String key=StdIn.readString();
            st.put(key,i);
        }
        for(String s:st.keys()){
            StdOut.println(s+" "+st.get(s));
        }
    }
}
