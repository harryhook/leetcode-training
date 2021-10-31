package com.leetcode.training;

public class LeetCode_65_Valid_Number {

    public static void main(String[] args) {
        LeetCode_65_Valid_Number client = new LeetCode_65_Valid_Number();
        System.out.println(client.isNumber("005047e+6"));
    }
    public boolean isNumber(String s) {
        boolean eExisted=false, digitExisted=false, dotExisted=false;

        int countMinusPlus = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            // dight
            if(Character.isDigit(ch)) {
                digitExisted = true;
            } else if(ch == '+' || ch == '-') {
                // minus plus
                if(countMinusPlus == 2) {
                    return false;
                }
                if(i>0 && (s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')) {
                    return false;
                }
                if(i == s.length() -1) {
                    return false;
                }
                countMinusPlus++;
            } else if(ch == '.'){
                if(eExisted || dotExisted) {
                    return false;
                }
                if(i == s.length()-1 && !digitExisted) {
                    return false;
                }
                dotExisted = true;

            } else if(ch == 'e' || ch == 'E') {
                if(eExisted || !digitExisted || i==s.length()-1) {
                    return false;
                }
                eExisted = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
