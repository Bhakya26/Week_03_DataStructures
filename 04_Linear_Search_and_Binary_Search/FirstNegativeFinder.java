public class FirstNegativeFinder {
    public static void main(String[] args) {
        int[] numbers = {5, 8, 12, -3, 7, -1};  

        int index = findFirstNegativeIndex(numbers);

        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
            System.out.println("Value: " + numbers[index]);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }

    public static int findFirstNegativeIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return i;
            }
        }
        return -1; 
}
}
