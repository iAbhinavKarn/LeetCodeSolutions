class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pointerOne = 0;
        int pointerTwo = numbers.length-1;
        boolean flag = true;
        while(flag){
            if(numbers[pointerOne] +  numbers[pointerTwo] > target){
                pointerTwo--;
            }
            else if(numbers[pointerOne] + numbers[pointerTwo] < target){
                pointerOne++;
            }
            else{
                return new int[]{pointerOne+1, pointerTwo+1};
            }
        }
        return new int[]{0,0};
    }

    public static void main(String []args){
        Solution solution = new Solution();
        solution.twoSum(new int[]{2,7,11,15}, 5);
    }
}