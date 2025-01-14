import java.util.Scanner;

public class Board {

    // no need to create obj (directly use twoNumberSum func)
    public static int twoNumberSum(int num1, int num2) {
        return num1 + num2;
    }

    // need to create obj ( not use directly sayHello func)
    void sayHello() {
        System.out.println("hi' there");
    }

    // call by reference
    public static void update(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 1;
        }
    }

    // linerSearch
    public static int linerSearch(int numbers[], int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (target == numbers[i]) {
                return i;
            }
        }
        return -1;
    }

    // find largest number in array
    public static int getLargest(int numbers[]) {
        int largestNumber = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (largestNumber < numbers[i]) {
                largestNumber = numbers[i];
            }
        }
        return largestNumber;
    }

    // find the largest and smallest number give in the array
    public static int[] getMaxAndMin(int numbers[]) {
        int largestNum = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            // largest number
            if (largestNum < numbers[i]) {
                largestNum = numbers[i];
            }
            // smallest number
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }

        // return new int array
        return new int[] { largestNum, smallest };
    }

    // Binary Search (array must be sorted)
    public static boolean binarySearch(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            }
        }
        return false;
    }

    // number Guessing game (using Binary Search)
    public static void numberGuessing() {

        Scanner input = new Scanner(System.in);

        System.out.println("Valid numbers are between 1 and 10,000");
        System.out.print("Play the game from number 1 to ?: ");
        int number = input.nextInt();

        if (number >= 1 && number <= 10000) {

            int randomNum = (int) Math.floor(Math.random() * number) + 1;
            int tries = 0;

            System.out.print("Enter your guess number: ");
            int guess = input.nextInt();

            while (true) {
                if (randomNum == guess) {
                    System.out.println("\n------------congratulations-------------");
                    System.out.println("You're right! This is the right number.  ");
                    System.out.println("You won the game after " + tries + " tries.");
                    System.out.println("-----------------------------------------");
                    break;
                } else if (randomNum < guess) {
                    System.out.print("Too high: Try again Enter your guess number: ");
                    guess = input.nextInt();
                    tries++;
                } else if (randomNum > guess) {
                    System.out.print("Too Low: Try again Enter your guess number: ");
                    guess = input.nextInt();
                    tries++;
                }
            }
        } else {
            System.out.println("You entered an invalid number. You are out of the game.");
        }
        input.close();
    }

    // Reverse Array
    public static void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void pairArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }

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
    // Method 1: prefix Approach
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
            if (currSum < 0) {
                currSum = 0;
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        System.out.println("max sub arr sum: " + maxSum);
    }

    /// Trapping Rain Water (42. LeetCode)
    // TC: O(n)
    // SC: O(n)
    public static int trappingRainWater(int height[]) {
        // 1: leftMax height
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];

        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 2: rightMax height
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            // 3: waterLevel = min(leftMax, rightMax) * width
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // 4; trappedWater = waterLevel - height
            trappedWater += (waterLevel - height[i]);
        }
        return trappedWater;
    }

    public static void main(String args[]) {
        // this is my first program (08-01-2025)

        // call by reference update value---------------------------
        // int arr[] = { 91, 99, 97 };
        // update(arr);

        // for (int n : arr) {
        // System.out.print(n + " ");
        // }

        // liner Search---------------------------------------------
        // int numbers[] = { 2, 4, 5, 67, 77 };
        // int target = 100;

        // int index = linerSearch(numbers, target);

        // if (index == -1) {
        // System.out.println("the number you entered are not found");
        // } else {
        // System.out.println("your number found at index: " + index);
        // }

        // get larges number ----------------------------------------
        // int numbers[] = { 100, 2, 5, 333, 7, 8 };
        // int largestNumber = getLargest(numbers);
        // System.out.println("largest number is: " + largestNumber);

        // find the largest and smallest number give in the array -----
        // int numbers[] = { 2, 4, 6, -5, 1, 6, 354 };
        // int MaxAndMin[] = getMaxAndMin(numbers);

        // System.out.println("Largest number is: " + MaxAndMin[0]);
        // System.out.println("Smallest number is: " + MaxAndMin[1]);

        // Binary Search ---------------------------------------------
        // int arr[] = { 2, 4, 6, 8, 10 };
        // int target = 10;
        // boolean isTrue = binarySearch(arr, target);

        // if (isTrue == true) {
        // System.out.println("Target found");
        // } else {
        // System.out.println("target not found in the array");
        // }

        // Reverse Array ---------------------------------------------
        // int arr[] = { 1, 2, 3, 4, 5 };
        // reverseArray(arr);

        // for (int item : arr) {
        // System.out.print(item + " ");
        // }

        // print array of pair
        // int arr[] = { 2, 4, 6, 8, 10 };
        // pairArray(arr);

        // print sub array
        // int arr[] = { 2, 4, 6, 8 ,10};
        // printSubArr(arr);

        // print max sub array sum
        // int arr[] = { 1, 2, 3, 4 };
        // maxSubArrSum(arr);

        // invoke number guessing game function
        // numberGuessing();

        // print max sub arr sum----------------------------
        // Method 1: Brute Force Approach
        // int arr[] = { 2, 4, 6, 8, 10 }; // ans: 30
        // maxSubArrSum(arr);

        // print max sub arr sum---------------------
        // Method 2: prefix Approach
        // int arr[] = { 2, 4, 6, 8, 10 }; // ans: 30
        // // int arr[] = { 1, -2, 6, -1, 3 }; // ans: 8
        // // maxSubArrSum(arr);
        // maxSubArrSum2(arr);
        // maxSubArrSum3(arr);

        // Trapping Rain water---------------------------------------
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        trappingRainWater(height);
    }

}