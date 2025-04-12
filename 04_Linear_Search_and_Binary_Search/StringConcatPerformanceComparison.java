public class StringConcatPerformanceComparison {

    public static long useStringBuilder(int count, String word) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(word);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static long useStringBuffer(int count, String word) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append(word);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static void printTime(String method, long durationNano) {
        System.out.println("Time taken by " + method + ": " + (durationNano / 1_000_000) + " ms");
    }

    public static void main(String[] args) {
        int count = 1_000_000;
        String word = "hello";

        long timeBuilder = useStringBuilder(count, word);
        long timeBuffer = useStringBuffer(count, word);

        printTime("StringBuilder", timeBuilder);
        printTime("StringBuffer", timeBuffer);
    }
}
