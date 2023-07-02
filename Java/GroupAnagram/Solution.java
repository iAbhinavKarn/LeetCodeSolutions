package GroupAnagrams;

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
        for(int i=0; i<strs.length; i++){
            Map<Character, Integer> internalValuesMap = new HashMap<>();
            for(int j=0; j<strs[i].length(); j++){
                if(internalValuesMap.containsKey(strs[i].charAt(j))){
                    internalValuesMap.put(strs[i].charAt(j), internalValuesMap.get(strs[i].charAt(j)) + 1);
                }
                else{
                    internalValuesMap.put(strs[i].charAt(j),1);
                }
            }
            hashMappingWithStr.put(strs[i], internalValuesMap); // This will store data like {tan={a=1, t=1, n=1}, nat={a=1, t=1, n=1}, tea={a=1, t=1, e=1}, ate={a=1, t=1, e=1}, bat={a=1, b=1, t=1}, eat={a=1, t=1, e=1}}
        }
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
    public List<List<String>> groupAnagramsMethod2(String[] strs) {
        List<List<String>> returnList = new ArrayList<>();
        Map<String, List<String>> sortedStringMap = new HashMap<>();
        for(String s : strs){
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String key = String.valueOf(sArray);
            if(!sortedStringMap.containsKey(key)){
                sortedStringMap.put(key, new ArrayList<>());
            }
            sortedStringMap.get(key).add(s);
        }

        for(Map.Entry<String, List<String>> valueMap: sortedStringMap.entrySet()){
            returnList.add(valueMap.getValue());
        }
        return returnList;
    }

    public static void main(String []args){
        Solution solution = new Solution();
        solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}