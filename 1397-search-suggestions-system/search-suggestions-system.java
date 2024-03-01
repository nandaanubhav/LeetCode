class Solution {

     // Equivalent code for lower_bound in Java
    int lower_bound(String[] products, int start, String word) {
        int l = start, r = products.length, m;
        while(l < r) {
            m = (l + r)/2;
            if(word.compareTo(products[m]) <= 0) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int length = searchWord.length();
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        char[] prefix = searchWord.toCharArray();
        for(int i=0; i<length; i++) {
            String startWord = searchWord.substring(0, i + 1);
            int start = lower_bound(products, 0, startWord);
            System.out.print("Match Found at " + start);
            List<String> currAns = new ArrayList<>();
            for(int j = start; j < Math.min(products.length, start + 3); j++) {
                if(products[j].length() < startWord.length() || !products[j].substring(0, i + 1).equals(startWord)) {
                    break;
                }
                currAns.add(products[j]);
            }
            result.add(currAns);
        }
        return result;
    }
}