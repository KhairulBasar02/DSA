public class MaxSubArraySum {
    // max sub array sum
    // Method 1: Brute Force Approach
    // TC: O(n3)
    // SC: O(1)
    public static void maxSubArrSum(int arr[]) {
        int maxSub = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum > maxSub) {
                    maxSub = sum;
                }
                // System.out.print(sum + " ");
            }
            // System.out.println();
        }
        System.out.println("max sub arr sub: " + maxSub);
    }

    // max sub array sum
    // Method 2: prefix Approach
    // TC: O(n2)
    // SC: O(n)
    public static void maxSubArrSum2(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];

        // prefix: i==0 (all sub array sum calc)
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE; // - infinity

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                int sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("max Sub arr sum:  " + maxSum);
    }

    // max sub array sum
    // Method 2: prefix Approach
    // TC: O(n2)
    // SC: O(n)
    public static void maxSubArrSum3(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];

        // prefix: i==0 (all sub array sum calc)
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE; // - infinity

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                int sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("max Sub arr sum:  " + maxSum);
    }

    public static void main(String[] args) {
        // print max sub arr sum
        int arr[] = { 2, 4, 6, 8, 10 }; // ans: 30
        // Method 1: Brute Force Approach
        maxSubArrSum(arr);

        // Method 2: prefix Approach
        maxSubArrSum2(arr);

    }
}
