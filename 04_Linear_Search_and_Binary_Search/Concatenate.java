import java.util.*;
public class Concatenate{
    public static String ConcatenateStrin(String[] strings){
        StringBuffer sb=new StringBuffer();
        for(String str:strings){
            sb.append(str);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String[] input={"Bhakya","lakshmi"};
        String result=ConcatenateStrin(input);
        System.out.println(result);
       
    }
}