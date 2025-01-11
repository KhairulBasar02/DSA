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
            mid = (left + right) / 2;

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
        int arr[] = { 2, 4, 6, 8 ,10};
        printSubArr(arr);

    }   

}