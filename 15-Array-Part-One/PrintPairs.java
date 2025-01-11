
public class PrintPairs {
    // Print array of paris
    public static void pairArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // print array of pairs
        // Time Complexity - worst case: Big O(n2)
        // Space complexity - worst case: Big O(1)
        int arr[] = { 2, 4, 6, 8, 10 };
        pairArray(arr);
    }
}
