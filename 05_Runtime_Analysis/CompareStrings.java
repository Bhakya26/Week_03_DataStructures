public class CompareStrings { 
public static void main(String[] args) { 
        String s = "aa"; 
        int n = 10000; 
        System.out.println("\nfinding execution time for string concatenation using string\n--------------\n"); 
        long startTime = System.currentTimeMillis(); 
        String str1=""; 
        for(int i=0;i<n;i++){ 
            str1 +=s; 
        } 
        long endTime = System.currentTimeMillis(); 
        System.out.println("time taken by string concatenation using string is "+(endTime-startTime)+" ms"); 
         
 
        System.out.println("\nfinding execution time for string concatenation using string builder\n--------------\n"); 
        startTime = System.currentTimeMillis(); 
        StringBuilder sb = new StringBuilder(""); 
        for(int i=0;i<n;i++){ 
            sb.append(s); 
        } 
        endTime = System.currentTimeMillis(); 
        System.out.println("time taken by string concatenation using string builder is "+(endTime-startTime) + " ms"); 
         
        System.out.println("\nfinding execution time for string concatenation using string buffer\n--------------\n"); 
        startTime = System.currentTimeMillis(); 
        StringBuffer sbf = new StringBuffer(""); 
        for(int i=0;i<n;i++){ 
            sbf.append(s); 
        } 
        endTime = System.currentTimeMillis(); 
        System.out.println("time taken by string concatenation using string buffer is "+(endTime-startTime)+" ms"); 
    } 
}