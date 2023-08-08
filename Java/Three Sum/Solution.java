import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pointerOne = i+1;
            int pointerTwo = nums.length-1;
            while(pointerOne < pointerTwo){
                if(nums[i] + nums[pointerOne] + nums[pointerTwo] > 0){
                    pointerTwo--;
                }
                else if(nums[i] + nums[pointerOne] + nums[pointerTwo] < 0){
                    pointerOne++;
                }
                else{
                    while(pointerOne < pointerTwo && nums[pointerOne] == nums[pointerOne + 1]){
                        pointerOne++;
                    }
                    while(pointerOne < pointerTwo && nums[pointerTwo] == nums[pointerTwo - 1]){
                        pointerTwo--;
                    }
                    returnList.add(new ArrayList<>(Arrays.asList(nums[i], nums[pointerOne], nums[pointerTwo])));
                    pointerOne++;
                    pointerTwo--;
                }
            }
        }
        return returnList;
    }

    public static void main(String []args){
        Solution sol = new Solution();
        sol.threeSum(new int []{-1,0,1,2,-1,-4})
    }
}