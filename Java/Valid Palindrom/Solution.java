class Solution {
    public boolean isPalindrome(String s) {
        String strCpy = "";
        for(int i=0; i<s.length() ; i++){
            int asciiValue = (int)s.charAt(i);
            if((asciiValue >= 65 && asciiValue <= 90) || (asciiValue >= 97 && asciiValue <=122) || (asciiValue >= 48 && asciiValue <=57)){
                if(asciiValue >= 65 && asciiValue <= 90){
                    asciiValue += 32;
                    strCpy += (char)asciiValue;
                }
                else{
                    strCpy += (char)asciiValue;
                }
            }
        }
        boolean isPalindrom = true;
        for(int i=0; i<strCpy.length()/2; i++){
            if(strCpy.charAt(i) == strCpy.charAt(strCpy.length() - i-1)){
                continue;
            }
            else{
                return false;
            }
        }
        return isPalindrom;
    }

    public static void main(String []args){
        Solution solution = new Solution();
        solution.isPalindrome("A man, a plan, a canal: Panama");
    }
}