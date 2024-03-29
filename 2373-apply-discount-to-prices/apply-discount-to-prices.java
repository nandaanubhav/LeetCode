class Solution {
    private String convert(String s, int discount) {
        System.out.println(s);
        if(s.charAt(0) != '$') return s;
        DecimalFormat df = new DecimalFormat("0.00");
        try {
            long price = Long.parseLong(s.substring(1));
            double val = price - (double) price * discount / 100d;
            return new StringBuilder().append('$').append(df.format(val)).toString();
        } catch(Exception e) {
            return s;
        }
    }
    public String discountPrices(String sentence, int discount) {
        String[] splitSenStrings = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String s : splitSenStrings) {
            sb.append(convert(s, discount)).append(" ");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
}