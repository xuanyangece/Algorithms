class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if (temp > target) end--;
                else start++;
                if (Math.abs(target - temp) < Math.abs(res - target)) res = temp;
            }
        }
        
        return res;
    }
}
