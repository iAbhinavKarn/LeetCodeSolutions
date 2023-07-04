import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //The base condition can if the length of string is equal to k so that means we can return the array directly
        if(nums.length == k){
            return nums;
        }
        List<Integer> returnList = new ArrayList<>();
        Map<Integer,Integer> hashMap = new HashMap<>(); //Created a hashMap to count frequency of a number
        //getting the frequency of a number and saving it in a hasmap
        for(int num : nums){
            if(returnList.contains(num)){
                continue;
            }
            if(hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num) + 1);
            }
            else{
                hashMap.put(num,1);
            }
        }
        int[] returnArray = new int[k];
        //adding all the values in a list to sort in the descresing order
        for(int key : hashMap.keySet()){
            returnList.add(hashMap.get(key));
        }
        Collections.sort(returnList, Collections.reverseOrder());
        // The value of previous index is -10001 because in the problem statement we can see the number cant be smaller than -10000 or -10^4
        int previousIndex = -10001;

        for(int i=0; i<k; i++){ //the loop here is only running till the input k as we only need to return k number of values.
            if(previousIndex != -10001){ //This condition is important beacuse if there are 2 numbers with same frequency it will be counted twice which will be wrong so if the key is counted once we are going to remove it from hashMap
                hashMap.remove(previousIndex);
            }
            for(int key : hashMap.keySet()){
                if(hashMap.get(key) == returnList.get(i)){// if the value in the hashmap is same as the value in the returnlist index value that means we have our key.
                    returnArray[i] = key;
                    previousIndex = key;
                    break;
                }
            }
        }
        return returnArray;
    }

    public static void main(String []args){
        Solution solution = new Solution();
        solution.topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);
    }
}