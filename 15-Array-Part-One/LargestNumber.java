
public class LargestNumber {
    // find largest number in array
    public static int getLargest(int numbers[]) {
        int largestNum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (largestNum < numbers[i]) {
                largestNum = numbers[i];
            }
        }
        return largestNum;
    }

    public static void main(String[] args) {
        // get larges number
        // Time Complexity - worst case: Big O(n)
        // Space complexity- worst case: Big O(1)

        int numbers[] = { 100, 2, 5, 333, 7, 8 };
        int largestNum = getLargest(numbers);
        System.out.println("largest number is: " + largestNum);
    }
}
