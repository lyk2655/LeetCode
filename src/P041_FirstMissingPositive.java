public class P041_FirstMissingPositive {
    public static void main(String[] args) {
        P041_FirstMissingPositive cc = new P041_FirstMissingPositive();
        int[] nums = {-1,4,2,1,9,10};
        int res = cc.firstMissingPositive(nums);
        System.out.println(res);
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] -1];
                nums[temp-1] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
