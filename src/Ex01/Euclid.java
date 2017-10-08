package Ex01;

/**
 * Created by Administrator on 2017/8/17.
 */
public class Euclid {
    public static int find(int p,int q){
        if (q==0) return  p;
        int r=p%q;
        return find(q, r);
    }

    //1.1.30
    public static boolean[][] matrixEx(int N){
        boolean[][] a = new boolean[N][N];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                int s=find(i,j);
                if(s==1){
                    a[i][j]=true;
                }else{
                    a[i][j] = false;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int q = find(1111111, 1234567);
        System.out.println(q);
        boolean[][] x=matrixEx(3);
        for(int i=0;i<x.length;i++){
            System.out.println(" ");
            for(int j=0;j<x[i].length;j++){
                System.out.print(x[i][j]+" ");
            }
        }
    }


}
