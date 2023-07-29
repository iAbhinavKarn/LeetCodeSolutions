import java.utils.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int previous = nums[0];
        int returnInt = max;
        for(int i=1; i<nums.length; i++){
            if(previous == nums[i]){
                continue;
            }
            if(previous + 1 == nums[i]){
                max += 1;
                previous = nums[i];
            }
            else{
                previous = nums[i];
                if(max > returnInt){
                    returnInt = max;
                }
                max = 1;
            }
        }
        if(max > returnInt){
            returnInt = max;
        }
        return returnInt;
    }

    public static void main(String []args){
        Solution solution = new Solution();
        solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
    }
}