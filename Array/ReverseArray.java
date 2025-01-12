public class ReverseArray {
    // Reverse Array
    public static void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Reverse Array
        // Time Complexity - worst case: Big O(n)
        // Space complexity - worst case: Big O(1)
        int arr[] = { 2, 4, 6, 8, 20 };
        reverseArray(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
