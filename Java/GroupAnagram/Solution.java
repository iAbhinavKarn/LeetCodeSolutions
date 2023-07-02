import java.util.*;

class Solution {
    //Brute Force Method 1
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returnList = new ArrayList<>(); //The final List which will be returned
        List<String> returnInternalList = new ArrayList<>(); //Internal List which will contain all the anagram
        if(strs.length == 1){ //If size is one then the value itself is its anagram
            returnInternalList.add(strs[0]);
            returnList.add(returnInternalList);
            return returnList;
        }
        Map<String, Map<Character, Integer>> hashMappingWithStr = new HashMap<>();
        //We will create a hash map with all the character and their count
        for(int i=0; i<strs.length; i++){
            Map<Character, Integer> internalValuesMap = new HashMap<>();
            for(int j=0; j<strs[i].length(); j++){ //Can use for (String s : strs) as well
                if(internalValuesMap.containsKey(strs[i].charAt(j))){
                    internalValuesMap.put(strs[i].charAt(j), internalValuesMap.get(strs[i].charAt(j)) + 1);
                }
                else{
                    internalValuesMap.put(strs[i].charAt(j),1);
                }
            }
            hashMappingWithStr.put(strs[i], internalValuesMap); // This will store data like {tan={a=1, t=1, n=1}, nat={a=1, t=1, n=1}, tea={a=1, t=1, e=1}, ate={a=1, t=1, e=1}, bat={a=1, b=1, t=1}, eat={a=1, t=1, e=1}}
        }
        //Now we have a hashmap we will now check if there are two or more hashmaps with same value if there are any then we will add it in response map
        for(int i=0; i<strs.length ; i++){
            for(String key : hashMappingWithStr.keySet()){
                if(hashMappingWithStr.get(key).equals(hashMappingWithStr.get(strs[i]))){
                    returnInternalList.add(key);
                }
            }
            if(!returnList.contains(returnInternalList)){
                returnList.add(returnInternalList);   
            }
            returnInternalList = new ArrayList<>();
        }
        return returnList;
    }

    //Method 2 Using sort
    //This is the second and better way to solve the same issue as words are different but the sorted string with those characters will be same
    //which will help us in understanding which 2 strings are anagram of each other.
    // for e.g: eat will be aet and tea will also be aet similarly ate will also be aet so we know these three words are anagram of each other/
    public List<List<String>> groupAnagramsMethod2(String[] strs) {
        List<List<String>> returnList = new ArrayList<>();
        Map<String, List<String>> sortedStringMap = new HashMap<>();
        for(String s : strs){
            char[] sArray = s.toCharArray(); //Converting string to array of characters as applying sort will be easy
            Arrays.sort(sArray);
            String key = String.valueOf(sArray); //Saving the sorted array in a string name key
            if(!sortedStringMap.containsKey(key)){
                sortedStringMap.put(key, new ArrayList<>()); //if the key is not present in HashMap then creating it with empty array
            }
            sortedStringMap.get(key).add(s); //adding words for the key with same sorted value.
        }

        for(Map.Entry<String, List<String>> valueMap: sortedStringMap.entrySet()){
            returnList.add(valueMap.getValue()); //adding the value in return list
        }
        return returnList;
    }

    public static void main(String []args){
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}).toString());
    }
}