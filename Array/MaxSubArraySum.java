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
    // Method 3: Kadanes Algorithm
    // TC: O(n)
    // SC: O(1)
    public static void maxSubArrSum3(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            // if current sum < 0 : sum = 0
            if (currSum < 0) {
                currSum = 0;
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        System.out.println("max sub arr sum: " + maxSum);
    }

    // 53. Maximum Subarray (leetcode)
    // TC: O(n)
    // SC: O(1)
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int count = 0;

        for (int n : nums) {
            if (n < 0) {
                count++;
            }
        }

        if (count == nums.length) {
            for (int i = 0; i < nums.length; i++) {
                maxSum = Math.max(maxSum, nums[i]);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                if (currSum < 0) {
                    currSum = 0;
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // print max sub arr sum
        int arr[] = { 2, 4, 6, 8, 10 }; // ans: 30

        // Method 1: Brute Force Approach
        maxSubArrSum(arr);

        // Method 2: prefix Approach
        maxSubArrSum2(arr);

        // Method 3: Kadanes Algorithm
        maxSubArrSum3(arr);

    }
}
