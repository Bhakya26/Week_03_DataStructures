import java.util.*;
public class Reverse{
    public static void main(String[] args){
        String input="hello";
        StringBuilder sb=new StringBuilder(input);
        sb.reverse();
        System.out.println("reversed word: "+sb.toString());
    }
}