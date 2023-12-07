class Solution {
    public String largestOddNumber(String num) {
        int numLen = num.length() - 1;
        int rightMostOddNumber = numLen;
        while(rightMostOddNumber >= 0) {
            int digit = Integer.valueOf(num.charAt(rightMostOddNumber));
            if(digit % 2 != 0) break;
            rightMostOddNumber--;
        }
        if (rightMostOddNumber < 0) return "";
        // System.out.println(rightMostOddNumber);
        // System.out.println(num.substring(0, rightMostOddNumber + 1));
        return num.substring(0, rightMostOddNumber + 1);
    }
}