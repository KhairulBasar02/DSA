
public class MaxAndMin {

    // find the largest and smallest number give in the array
    public static int[] getMaxAndMin(int numbers[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            // largest number
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
            // smallest number
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }

        // return new int array
        return new int[] { largest, smallest };
    }

    public static void main(String[] args) {
        // find the largest and smallest number give in the array
        // Time Complexity - worst case: Big O(n)
        // Space complexity - worst case: Big O(1)

        int numbers[] = { 2, 4, 6, -5, 1, 6, 354 };
        int MaxAndMin[] = getMaxAndMin(numbers);

        System.out.println("Largest number is: " + MaxAndMin[0]);
        System.out.println("Smallest number is: " + MaxAndMin[1]);
    }
}
