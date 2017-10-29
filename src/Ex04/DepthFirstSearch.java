package Ex04;

/**
 * Created by Administrator on 2017/10/29.
 */
//找出起点s可到达的顶点个数
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    //找到与顶点s联通的顶点
    public DepthFirstSearch(Graph G,int s){
        marked=new boolean[G.V()];
        dfs(G,s);
    }
    public void dfs(Graph G,int v){
        marked[v]=true;
        count++;
        for(int w:G.adj(v)){
            if(!marked[w]) dfs(G,w);
        }
    }
    public boolean marked(int w){
        return marked(w);
    }
    public int count(){
        return count;
    }
}
