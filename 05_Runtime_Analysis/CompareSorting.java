import java.util.Arrays; 
public class CompareSorting{ 
static int[] bubbleSort(int[] arr){ 

        for(int i=0;i<arr.length;i++){ 
            for(int j= i+1;j<arr.length;j++){ 
                if(arr[j]<arr[i]){ 
                    int temp = arr[i]; 
                    arr[i] = arr[j]; 
                    arr[j] = temp; 
                } 
            } 
        } 
        return arr; 
    } 
    static void conquer(int[] arr,int left,int mid,int right){ 
        int[] res = new int[right-left+1]; 
        int l = left; 
        int r = mid+1; 
        int k = 0; 
        while(l<=mid && r<=right){ 
            if(arr[l]<arr[r]){ 
                res[k++] = arr[l++]; 
            }else{ 
                res[k++] = arr[r++]; 
            } 
        } 
        while(l<=mid){ 
            res[k++] = arr[l++]; 
        } 
        while(r<=right){ 
            res[k++] = arr[r++]; 
        } 
        for(int i=0;i<res.length;i++){ 
            arr[left+i] = res[i]; 
        } 
         
 
    } 
    static void divide(int[] arr,int start,int end){ 
        if(start>=end){ 
            return ; 
        } 
        int mid = start + (end - start) / 2 ; 
        divide(arr,start,mid); 
        divide(arr,mid+1,end); 
        conquer(arr,start,mid,end); 
    } 
    static int[] mergeSort(int[] arr){ 
        divide(arr,0,arr.length-1); 
        return arr; 
    } 
    static int partition(int[] arr,int l,int r){ 
        int pivot = arr[r]; 
        int i = l-1; 
        for(int j=l;j<r;j++){ 
            if(arr[j]<pivot){ 
                i++; 
                int temp =  arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        i++; 
        int temp = arr[i]; 
        arr[i] = arr[r]; 
        arr[r] = temp; 
        return i; 
    } 
    static void quick(int[] arr,int l,int r){ 
        if(l<r){ 
            int pivot = partition(arr,l,r); 
            quick(arr,l,pivot-1); 
            quick(arr,pivot+1,r); 
        } 
    } 
    static int[] quickSort(int[] arr){ 
        quick(arr,0,arr.length-1); 
        return arr; 
 
    } 
     
    public static void main(String[] args) { 
        int[] arr = { 56,23,12,8,4,28,98,43}; 
        int[] arr2 = { 56,23,12,8,4,28,98,43}; 
        int[] arr3 = { 56,23,12,8,4,28,98,43}; 
 
        long t1 = System.nanoTime(); 
        System.out.println("After sorting using bubble sort : " + Arrays.toString(bubbleSort(arr))); 
        System.out.println("duration for bubbleSort: "+(System.nanoTime()-t1 + " ms")); 
 
        long t2 = System.nanoTime(); 
        System.out.println(" After sorting using merge sort : " + Arrays.toString(mergeSort(arr2))); 
        System.out.println("duration for merge sort : "+(System.nanoTime()-t2 + " ms")); 
 
        long t3 = System.nanoTime(); 
        System.out.println( "After sorting using quicksort : "+ Arrays.toString(quickSort(arr3))); 
        System.out.println("duration for quickSort : "+(System.nanoTime()-t3 + " ms")); 
    } 
}