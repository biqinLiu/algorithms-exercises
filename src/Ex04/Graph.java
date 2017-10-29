package Ex04;

import com.sun.org.apache.regexp.internal.RE;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by Administrator on 2017/10/29.
 */
public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;
    public Graph(int V){
        this.V=V;
        this.E=0;
        adj=(Bag<Integer>[])new Bag[V];
        for(int v=0;v<V;v++){
            adj[v]=new Bag<Integer>();
        }
    }
    public Graph(In in){
        this(in.readInt());
        int E=in.readInt();
        for(int i=0;i<E;i++){
            int v=in.readInt();
            int w=in.readInt();
            addEdge(v,w);
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    //增加一条边
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    //和V相邻的所有顶点
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    //图的邻接表表示
    public String toString(){
        String s=V+" vertices, "+E+" edges"+"\n";
        for(int v=0;v<V;v++){
            s +=v+": ";
            for(int w:this.adj(v)){
                s +=w+" ";
            }
            s+="\n";
        }
        return s;
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        Graph graph=new Graph(in);
        System.out.println(graph.toString());

    }
}
