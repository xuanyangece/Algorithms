class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        // find right most a[i] < a[i + 1]
        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }
        
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int firstGreat = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstGreat = i;
                break;
            }
        }
        
        swap(nums, firstSmall, firstGreat);
        reverse(nums, firstSmall + 1, nums.length - 1);
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
