public class BinarySearch {

    // binary search Iteration
    // Time Complexity - worst case: Big O(n)
    // Space complexity - worst case: Big O(1)
    public static int binarySearch(int numbers[], int target) {
        int start = 0;
        int end = numbers.length - 1;

        // comparison
        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (target < numbers[mid]) {
                end = mid - 1;
            } else if (target > numbers[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Binary Search Using Recursion
    // Time Complexity - worst case: Big O(n)
    // Space complexity- worst case: Big O(n) create inside call stack
    public static int binarySearchRec(int numbers[], int target, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < numbers[mid]) {
                return binarySearchRec(numbers, target, start, mid - 1);
            } else if (target > numbers[mid]) {
                return binarySearchRec(numbers, target, mid + 1, end);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Binary Search (must be sorted)
        int numbers[] = { 2, 4, 6, 8, 10 };
        int target = 100;
        // int index = binarySearch(numbers, target);

        // binary search using recursion
        int index = binarySearchRec(numbers, target, 0, numbers.length - 1);

        if (index == -1) {
            System.out.println("target not found");
        } else {
            System.out.println("target found at index: " + index);
        }

    }
}
