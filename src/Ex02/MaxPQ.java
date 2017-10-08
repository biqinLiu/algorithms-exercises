package Ex02;

/**
 * Created by Water Wood on 2017/9/16.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N=0;
    public  void MaxPQ(){

    }
    public  void MaxPQ(int max){
        pq = (Key[]) new Comparable[max + 1];
    }
    public void maxPQ(Key[] a){

    }
    public  void inset(Key v){
        pq[N++]=v;
        swim(N);
    }
    public Key max(){
        return null;
    }
    public Key delMax(){
        Key max=pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    private boolean less(int v,int w){
        return pq[v].compareTo(pq[w])<0;
    }
    private void exch(int i,int j){
        Key tem = pq[i];
        pq[i] = pq[j];
        pq[j]=tem;
    }
    private void swim(int k){
        while (k>1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }
    private void sink(int k){
        while (2*k<=N){
            int j=2*k;
            if(j<N&&less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }

}
