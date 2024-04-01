class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0, right = 0, n = s.length(), minLength = Integer.MAX_VALUE, currCount = 0;
        String ans = "";
        while(left < n && s.charAt(left) != '1') {
            left++;
        }
        right = left;
        while(right < n) {
            currCount += (s.charAt(right) == '1' ? 1 : 0);
            if(currCount == k) {
                int length = right - left + 1;
                // System.out.println("left " + left + " right " + right);
                if(length < minLength || (length == minLength && ans.compareTo(s.substring(left, right + 1)) > 0)) {
                    minLength = length;
                    ans = s.substring(left, right + 1);
                }
                left++;
                while(left < n && s.charAt(left) != '1') {
                    left++;
                }
                if(right < left) right = left;
                currCount--;
            }
            right++;
        }
        return ans;
    }
}