public class P042_TrappingRainWater {

    public static void main(String[] args) {
        P042_TrappingRainWater trappingRainWater = new P042_TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater.trap(height));

    }

    public int trap(int[] height) {
        if(height.length < 2) {
            return 0;
        }
        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];

        int maxLeft = 0, maxRight = 0;
        for(int i = 0; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            maxLeftHeight[i] = maxLeft;
        }
        for(int i = height.length -1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            maxRightHeight[i] = maxRight;
        }
        int trap = 0;
        for(int i = 0; i < height.length; i++) {
            int min = Math.min(maxLeftHeight[i], maxRightHeight[i]);
            trap += min - height[i];
        }

        return trap;
    }
}
