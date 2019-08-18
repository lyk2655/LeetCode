import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending
 * order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand
 * column.
 * 
 * 1,2,3 → 1,3,2 .
 * 3,2,1 → 1,2,3 .
 * 1,1,5 → 1,5,1 .
 *  
 *  下一个排列算法过程(6,8,7,4,3,2):
 * 
 * （1）从右到左，找到第一个违反递增趋势的分区数；例如下图的6。
 * 
 * （2）从右到左，找到第一个比分区数大的改变数；例如下图的7。
 * 
 * （3）交换分区数和改变数；例如下图的6和7交换。
 * 
 * （4）颠倒分区数索引的右边所有数字。例如下图的7之后的元素
 * 
 * 
 * @author linyk001
 * @date 2019/02/13
 */
public class P031_Next_Permutation {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 1.从右到左，找到第一个违反递增趋势的分区数；
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // 2.从右到左，找到第一个比分区数大的改变数
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            // 3.交换分区数和改变数
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        // 4.颠倒分区数索引的右边所有数字
        reverse(nums, i + 1);
    }

    public static void reverse(int[] nums, int index) {
        if (nums == null || nums.length == 0 || index > nums.length - 1) {
            return;
        }
        int l = index;
        int r = nums.length - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
