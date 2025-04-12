import java.util.*;

public class PairWithGivenSum {

    public static void printPairsWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<String> printed = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);
                String pair = a + "," + b;
                if (!printed.contains(pair)) {
                    System.out.println("Pair: " + a + " + " + b + " = " + target);
                    printed.add(pair);
                }
            }
            seen.add(num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7, 4, 13};
        int target = 17;
        printPairsWithSum(arr, target);
    }
}
