class Solution {
    public String removeOccurrences(String s, String part) {
        int partLength = part.length();
        StringBuilder sb = new StringBuilder(s);
        int index = sb.indexOf(part);
        while(index != -1) {
            sb.delete(index, index + partLength);
            index = sb.indexOf(part);
        }
        return sb.toString();
    }
}