class Solution {
    public String largestGoodInteger(String num) {
        int count = 1;
        char ansInt = ' ';
        for(int i=1;i<num.length();i++) {
            if(num.charAt(i) == num.charAt(i-1)) {
                count++;
                if(count == 3) {
                    if (num.charAt(i) > ansInt || ansInt == ' ')
                        ansInt = num.charAt(i);
                }
            } else {
                count = 1;
            }
            // System.out.println(num.charAt(i) + " : " + count);
        }
        if (ansInt == ' ') return "";
        StringBuilder sb = new StringBuilder();
        return sb.append(ansInt).append(ansInt).append(ansInt).toString();
    }
}