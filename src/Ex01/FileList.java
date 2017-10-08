package Ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/23.
 */

//使用队列递归打印文件列表
public class FileList {
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        String pathName = "E:\\adRemove";
        File file = new File(pathName);
        ArrayList<File> fileList=new ArrayList<>();
        //listAllFile(file,fileList);
        LinkedQueue fileQueue=new LinkedQueue();
        System.out.println(file.getAbsolutePath());
        listAllFile_Q(file,fileQueue,0);
    }
    public static void listAllFile(File folder,ArrayList<File> fileList){
        File[] files=folder.listFiles();
        for(File file:files){
            if(file.isFile()) {
                System.out.println(file.getAbsolutePath());
                fileList.add(file);
            }else
            {
                listAllFile(file,fileList);
            }
        }
    }
    public static void listAllFile_Q(File folder,LinkedQueue fileQueue,int n){
        String tabs="  ";
        for(int i=0;i<n;i++){
            tabs+=tabs;
        }
        File[] files=folder.listFiles();
        for(File file:files){
            System.out.println(tabs+file.getAbsolutePath());
            if(file.isFile()) {
                fileQueue.enqueue(file);
            }else
            {
                listAllFile_Q(file,fileQueue,n++);
            }
        }
    }

}
