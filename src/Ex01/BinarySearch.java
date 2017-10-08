package Ex01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/17.
 */
public class BinarySearch {

    public static int rank(int[] a,int key){
        Arrays.sort(a);
        int lo = 0;
        int hi = a.length - 1;
        int mid;
        while (lo<=hi){
            mid = (hi+lo) / 2;
            if(key>a[mid]){
                lo=mid+1;
            }else if(key<a[mid]){
                hi=mid-1;
            }else
            {
                return a[mid];
            }
        }
        return -1;
    }
    //recursive
    public static int rank2(int[] a,int key){
        return rank2(a, key, 0, a.length - 1,0);
    }
    public static int rank2(int[] a,int key,int lo,int hi,int depth){
        for(int i=0;i<=depth;i++) System.out.printf(" ");
        System.out.println("lo="+lo+" hi="+hi);
        if(lo>hi) return -1;
        int mid = (lo + hi) / 2;
        if(key>a[mid]) return rank2(a, key, mid + 1, hi,depth+1);
        else if (key<a[mid]) return rank2(a, key, lo, mid - 1,depth+1);
        else return a[mid];
    }
    //find equal keys
    public static int rank3(int[] a,int key){
        int num=0;
        for(int i=0;i<a.length;i++){
            if (a[i]<key){
                num++;
            }else {
                break;
            }
        }
        return num;
    }
    public static int count(int[] a,int key){
        int num=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<key){
                continue;
            }else if(a[i]==key){
                num++;
            }else {
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] aa = new int[]{2,2,3,4,5, 3, 4, 5, 6, 34, 52, 12};
        //1.1.28 delete duplicate number
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<aa.length;i++){
            s.add(aa[i]);        }
        Object[] temp=s.toArray();
        int[] a = new int[temp.length];
        for(int i=0;i<temp.length;i++){
            a[i] = (int)temp[i];
        }
        for (int i:a){
            System.out.println(i);
        }
        //1.1.22
        int[] b = new int[]{1, 2, 7};
        for(int i=0;i<b.length;i++){
            //int result = rank(a, b[i]);
            int result = rank2(a, b[i]);
            if(result!=-1) System.out.println("find "+b[i]);
            else System.out.println("not found "+b[i]);
        }
        //1.1.29
        Arrays.sort(aa);
        int i=rank3(aa,5);
        int j = count(aa, 5);
        for(int m=i;m<i+j;m++){
            System.out.print(aa[m]+" ");
        }
    }

}
