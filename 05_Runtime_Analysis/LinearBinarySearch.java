import java.util.Arrays; 
public class LinearBinarySearch{ 
     
    static void linearSearch(int[] a,int k){ 
        for(int i =0;i<a.length;i++){ 
            if(a[i]==k){ 
                System.out.println("element "+k+" found at index "+ i); 
                return; 
            } 
        } 
        System.out.println("element "+k+" not found in array"); 
    } 
    static void binarySearch(int[] a,int k){ 
        Arrays.sort(a); 
        int l = 0; 
        int h = a.length - 1; 
        while(l<=h){ 
            int mid = l + (h-l)/2; 
            if(a[mid]==k){ 
                System.out.println("element "+k+" found at index "+ (mid+1)); 
                return; 
            }else if(a[mid]<k){ 
                l = mid+1; 
            }else{ 
                h = mid-1; 
            } 
        } 
        System.out.println("element "+k+" not found in array"); 
    } 
    public static void main(String[] args) { 
        int[] arr = { 56,23,12,8,4,28,98,43}; 
        int target = 28; 
        long t1 = System.nanoTime(); 
        linearSearch(arr,target); 
        System.out.println("duration for linear search : "+(System.nanoTime()-t1 + " ms")); 
        long t2 = System.nanoTime(); 
        binarySearch(arr,target); 
        System.out.println("duration for binary search : "+(System.nanoTime()-t2 + " ms")); 
    } 
}