package linyk2655;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 * 
 * @author linyk001
 * @date 2019/02/15
 */
public class P033_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //从左边开始遍历数组,如果命中,直接返回. 因为数组有序,如果发现target < nums[i], 说明不在左边开始的有序序列中
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (target < nums[i]) {
                break;
            }
        }
        //从右边倒序遍历数组,命中直接返回. 因为后一段也是有序的,如果发现 target > nums[j], 说明不在后一段中
        for (int j = nums.length - 1; j > 0; j--) {
            if (target == nums[j]) {
                return j;
            }
            if (target > nums[j]) {
                break;
            }
        }
        return -1;
    }
}
