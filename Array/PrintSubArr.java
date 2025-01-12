public class PrintSubArr {
    // print subArray
    public static void printSubArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // print subArray
        // Time Complexity - worst case: Big O(n3)
        // Space complexity - worst case: Big O(1)
        int arr[] = { 2, 4, 6, 8, 10 };
        printSubArr(arr);
    }
}
