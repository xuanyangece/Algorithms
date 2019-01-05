class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0], count = 0;
        
        for (int num: nums) {
            if (num == majority) count++;
            else {
                if (count-- == 0) {
                    majority = num;
                    count++;
                }
            }
        }
        
        return majority;
    }
}
