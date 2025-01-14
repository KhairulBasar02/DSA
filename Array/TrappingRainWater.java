public class TrappingRainWater {

    // Trapping Rain water
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

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        int trappedWater = trappingRainWater(height);
        System.out.println(trappedWater);
    }
}
