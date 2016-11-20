/**
 * @author open
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class P011_ContainerWithMostWater {
	
	//time limited
    public static int maxArea(int[] height) {
    	if(height == null || height.length <= 1) {
    		return 0;
    	}
    	if(height.length == 2) {
    		return Math.min(height[0],height[1]);
    	}
    	int max = 0;
    	for(int i = 0; i < height.length-1; i++) {
    		for(int j = i+1; j < height.length; j++) {
    			int area = Math.min(height[i], height[j]) * (j - i);
    			if(max < area) {
    				max = area;
    			}
    		}
    	}
        return max;
    }
    
    public static int maxArea2(int[] height) {
    	int max=0, l = 0, r = height.length - 1;
    	while(l < r) {
    		max = Math.max(max, Math.min(height[l],height[r])*(r-l));
    		if(height[l] < height[r]) {
    			l++;
    		} else {
    			r--;
    		}
    	}
    	return max;
    }
    
    public static void main(String[] args) {
    	int[] height = {3,6,7,4};
    	System.out.println(maxArea(height));
    }
}
