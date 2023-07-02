#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<string>> hashMap;
        for(auto str : strs){
            string copyStr = str;
            sort(copyStr.begin(), copyStr.end());
            hashMap[copyStr].push_back(str);
        }
        vector<vector<string>> returnList;
        for(auto values : hashMap){
            returnList.push_back(values.second);
        }
        return returnList;
    }
};

int main(){
    Solution sol;
    vector<string> vec;
    vec.push_back("eat");
    vec.push_back("tea");
    vec.push_back("tan");
    vec.push_back("ate");
    vec.push_back("nat");
    vec.push_back("bat");
    sol.groupAnagrams(vec);
    return 0;
}