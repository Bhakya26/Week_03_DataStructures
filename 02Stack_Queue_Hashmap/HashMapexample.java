import java.util.HashMap;
public class HashMapexample{
    public static void main(String[] args){
        HashMap<Integer,String> studentMap=new HashMap<>();
        studentMap.put(1,"kristen");
        studentMap.put(2,"ben");
        studentMap.put(3,"david");
        System.out.println("Name with roll no 2: "+studentMap.get(2));
        if(studentMap.containsKey(3)){
            System.out.println("student with roll no 3 present");
        }
        studentMap.remove(3);
        for(Integer rollno:studentMap.keySet()){
            System.out.println("Rollno: "+rollno+" Name: "+studentMap.get(rollno));
        }


    }
}