//This is not completed will complete tomorrow

#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int, int> hashMap;
        vector<int> returnVector;
        map<int,string>::iterator itr;
        if(nums.size() == k){
            return nums;
        }
        for(int num : nums){
            if (hashMap.find(nums) == hashMap.end())
                hashMap[num] = 1;
            else
                hashMap.find(nums) = hashMap.find(nums) + 1;
        }
        for(auto value : hashMap){
            cout<<value.first << " Value = " << value.second; 
        }
        return returnVector;
    }
};

int main(){
    Solution sol;
    vector<int> vec;
    vec.push_back(1);
    vec.push_back(1);
    vec.push_back(1);
    vec.push_back(2);
    vec.push_back(2);
    vec.push_back(3);
    sol.topKFrequent(vec, 2);
    return 0;
}