/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]


The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class P004_MedianOfTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
			return 0.0;
		}
		int[] nums= new int[nums1.length+nums2.length];
		int i = 0,j=0, k = 0;
		for(; i < nums1.length && j < nums2.length;) {
			if(nums1[i] <= nums2[j] ) {
				nums[k++] = nums1[i++];
			} else {
				nums[k++] = nums2[j++];
			}
		}
		for(;i<nums1.length;){
			nums[k++] = nums1[i++];
		}
		for(;j<nums2.length;) {
			nums[k++] = nums2[j++];
		}
		int len = nums.length;
		if(len % 2 == 0) {
			return (nums[len/2 - 1]+nums[len/2]) / 2.0;
		} else {
			return nums[(len-1)/2];
		}
    }
	public static void main(String[] agrs) {
		int[] nums1 = new int[]{1,2,4,7};
		int[] nums2 = new int[]{3,6,8};
		double i = findMedianSortedArrays(nums1,nums2);
		System.out.println(i);
	}
}
