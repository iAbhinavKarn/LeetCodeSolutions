import java.util.*;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int max = 1; //This will store multiple value of all the integers present in the array
        int secondMax = 1; //If there any 0 in the array then we will multiply the result with 1 so that the other value remains with us as when creating and return string divide by 0 is error so we need to store the value somewhere.
        int zeroCount = 0; //To check if there are more than one 0 in input as this will clear us doubth that the response will be 0 always
        for(int i : nums){
            if(i == 0){
                max = 0;
                zeroCount++;
                secondMax *= 1;
            }
            else{
                max *= i;
                secondMax *= i;
            }
        }
        int[] returnArray = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                if(zeroCount > 1){
                    returnArray[i] = 0;
                }
                else{
                returnArray[i] = secondMax;
                }
            }
            else{
                returnArray[i] = max/nums[i];
            }
        }
        return returnArray;
    }

    public static void main(String []args){
        Solution solution = new Solution();
        solution.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
    
}
