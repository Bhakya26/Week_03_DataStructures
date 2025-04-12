import java.util.*;
public class Duplicate{
    public static String removeDuplicate(String input){
        HashSet<Character> set=new HashSet<>();
        StringBuilder result=new StringBuilder();
        for(char ch:input.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                result.append(ch);
            }
        }
        return result.toString();

    }
    public static void main(String[] args){
        String input="helloo";
       String output= removeDuplicate(input);
       System.out.println("Removed duplicates "+output);


    }
}