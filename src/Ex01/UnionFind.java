package Ex01;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by Administrator on 2017/8/25.
 */
public class UnionFind {
    private int[] id;
    private int[] weighted;
    private int count;
    public UnionFind(int N){
        count=N;
        id=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
        }
        weighted=new int[N];
        for(int i=0;i<N;i++){
            weighted[i]=1;
        }
    }
    //连通分量的个数
    public int count(){
        return count;
    }
    //返回某触点的连通分量标识符 quick  find
    public int find(int p){
        return id[p];
    }
    public boolean connected(int p,int q){
        return id[p]==id[q];
    }

    public void union(int p, int q){
        int pID=find(p);
        int qID=find(q);
        if(pID==qID) return;
        for(int i=0;i<id.length;i++){
            if(id[i]==pID) id[i]=qID;
            count--;
        }
    }
    //quick union
    public int find2(int p){
        while (p!=id[p]) p=id[p];
        return p;
    }
    public void union2(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot) return;
        id[pRoot]=qRoot;
        count--;
    }
    //weighted quick union
    public void union3(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot) return;
        if(weighted[pRoot]<weighted[qRoot]) {
            id[pRoot]=qRoot;
            weighted[qRoot]+=weighted[pRoot];
        }
        else {
            id[qRoot]=pRoot;
            weighted[pRoot]+=weighted[qRoot];
        }
        count--;
    }




    public static void main(String[] args) {
        UnionFind uf=new UnionFind(10);
        int[][] data=new int[][]{{4,3},{3,8},{6,5},{9,4},{2,1},{5,0},{7,2},{6,1}};
        for(int i=0;i<data.length;i++){
            int p=data[i][0];
            int q=data[i][1];
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            System.out.println(p+" "+q);
            }
        System.out.println(uf.count()+" components");
        }
    }
