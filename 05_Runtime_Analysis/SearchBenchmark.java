import java.util.*; 
public class SearchBenchmark { 
public static void main(String[] args) { 
 
        int[] sizes = {1_000, 100_000, 1_000_000}; 
        Random rand = new Random(); 
 
        for (int N : sizes) { 
            int target = rand.nextInt(N); 
            System.out.println("\nBenchmarking with N = " + N); 
 
            List<Integer> arrayList = new ArrayList<>(); 
            for (int i = 0; i < N; i++) { 
                arrayList.add(i); 
            } 
            Collections.shuffle(arrayList); 
 
            
            long start = System.nanoTime(); 
            boolean found = arrayList.contains(target); 
            long end = System.nanoTime(); 
            System.out.printf("ArrayList Search (O(N)): %.4f ms\n", (end - start) / 1e6); 
 
            
            Set<Integer> hashSet = new HashSet<>(arrayList); 
            start = System.nanoTime(); 
            found = hashSet.contains(target); 
            end = System.nanoTime(); 
            System.out.printf("HashSet Search (O(1)): %.4f ms\n", (end - start) / 1e6); 
 
            
            Set<Integer> treeSet = new TreeSet<>(arrayList); 
            start = System.nanoTime(); 
            found = treeSet.contains(target); 
            end = System.nanoTime(); 
            System.out.printf("TreeSet Search (O(log N)): %.4f ms\n", (end - start) / 1e6); 
        } 
    } 
} 