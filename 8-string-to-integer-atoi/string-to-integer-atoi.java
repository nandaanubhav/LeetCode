

import static java.lang.Character.isDigit;

class Solution {
    public int myAtoi(String s) {
        int index = 0;
        boolean negative = false;
        long num = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if(index < s.length() && s.charAt(index) == '-') {
                negative = true;
                index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
                negative = false;
                index++;
        }
        while(index < s.length()) {
           if(isDigit(s.charAt(index))){
                num = num * 10 + Integer.valueOf(s.charAt(index)- '0');
                if(num > Integer.MAX_VALUE && !negative) return Integer.MAX_VALUE;
                else if (num > Integer.MAX_VALUE && negative) return Integer.MIN_VALUE;
                index++;
            } else {
                break;
            }
        }
        return negative ? -1 * (int) num : (int) num;
    }
}