
public class LinerSearch {
    // liner Search
    public static int linerSearch(int numbers[], int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (target == numbers[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // liner Search
        // Time Complexity - worst case: Big O(n)
        // Space complexity - worst case: Big O(1)

        int numbers[] = { 2, 4, 5, 67, 77 };
        int target = 67;
        int index = linerSearch(numbers, target);

        if (index == -1) {
            System.out.println("the number you entered are not found");
        } else {
            System.out.println("your number found at index: " + index);
        }
    }
}
