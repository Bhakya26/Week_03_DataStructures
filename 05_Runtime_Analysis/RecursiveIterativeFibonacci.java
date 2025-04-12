public class RecursiveIterativeFibonacci { 
 
    static void fibonacciIterative(int n){ 
        if(n<=0){ 
            System.out.println("Input should be positive integer."); 
            return; 
        } 
        int a = 0; 
        int b = 1; 
        System.out.print(a + " "+ b + " "); 
        for(int i = 2; i <= n; i++){ 
            int sum = a + b; 
            a = b; 
            b = sum; 
            System.out.print(sum + " "); 
        } 
    } 
    static int fibonacciRecursive(int n1){ 
        if(n1<0){ 
            System.out.println("Input should be positive integer."); 
            return -1; 
        }else{ 
            if(n1<=1){ 
                return n1; 
            } 
            return fibonacciRecursive(n1-1) + fibonacciRecursive(n1-2); 
        } 
    } 
    public static void main(String[] args) { 
        int n = 10; 
        int n1 = 10; 
        long t1 = System.currentTimeMillis(); 
        fibonacciIterative(n); 
        System.out.println("duration for iterative approach : " + (System.currentTimeMillis() - t1) + " ms"); 
        long t2 = System.currentTimeMillis(); 
        for(int i = 0; i <= n1; i++){ 
            System.out.print(fibonacciRecursive(i)+" "); 
        } 
System.out.println("duration for recursive approach : " + (System.currentTimeMillis() - t2) + " ms"); 
} 
}