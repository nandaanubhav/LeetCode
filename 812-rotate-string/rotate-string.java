class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++) {
            char c = sb.charAt(0);
            if(sb.deleteCharAt(0).append(c).toString().equals(goal)) return true;
        }
        return false;
    }
}