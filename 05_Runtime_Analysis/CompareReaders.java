import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.FileReader; 
import java.io.InputStreamReader; 
public class CompareReaders { 
public static void main(String[] args) { 
        try{ 
            System.out.println("finding exexution time for FileReader\n-----------------------------------\n"); 
            long startTime = System.currentTimeMillis(); 
            FileReader fr = new FileReader("sample.txt"); 
            BufferedReader br = new BufferedReader(fr); 
            String i; 
            while((i = br.readLine()) != null){ 
                System.out.println(i); 
            } 
            long endTime = System.currentTimeMillis(); 
            System.out.println("Execution time for FileReader: " + (endTime - startTime) + "ms"); 
            br.close(); 
            fr.close(); 
 
            System.out.println("finding exexution time for InputStreamReader\n-----------------------------------\n"); 
            startTime = System.currentTimeMillis(); 
            InputStreamReader isr = new InputStreamReader(new FileInputStream("sample.txt")); 
            BufferedReader brr = new BufferedReader(isr); 
            String j = ""; 
            while((j = brr.readLine()) != null){ 
                System.out.println(j); 
            } 
            endTime = System.currentTimeMillis(); 
            System.out.println("Execution time for InputStreamReader: " + (endTime - startTime) + "ms"); 
            isr.close(); 
            brr.close(); 
        }catch(Exception e){ 
            System.out.println(e.getMessage()); 
        } 
       
    } 
}