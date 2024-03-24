class Solution {
    Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            String s1 = String.valueOf(i1), s2 = String.valueOf(i2);
            int i = 0;
            while(i < s1.length() && i < s2.length()) {
                if(s1.charAt(i) == s2.charAt(i)) {
                    i++;
                } else {
                    return (int) (Integer.valueOf(s1.charAt(i)) - Integer.valueOf(s2.charAt(i)));
                }
            }
            return (int) (s1.length() - s2.length());
        }
    };

    public List<Integer> lexicalOrder(int n) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            numbers.add(i);
        }
        Collections.sort(numbers, comp);
        return numbers;
    }
}