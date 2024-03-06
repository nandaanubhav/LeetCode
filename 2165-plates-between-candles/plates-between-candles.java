class Solution {
    public int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(arr[m] == target) {
                // System.out.println("Returning " + m + " target " + target);
                return ans = m;
            } else if (arr[m] > target){
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        // System.out.println("Returning " + l + " target " + target);
        return ans;
    }
    public int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1;
        while(l <= r) {
            int m = l + (r - l)/2;
            if(arr[m] == target) {
                // System.out.println("Returning " + m + " target " + target);
                return m;
            } else if (arr[m] < target){
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        // System.out.println("Returning " + l + " target " + target);
        return ans;
    }
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> candlePosList = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '|') candlePosList.add(i);
        }
        int[] candlePos = candlePosList.stream().mapToInt(i -> i).toArray();
        int[] ans = new int[queries.length];
        int i = 0;
        for(int[] query : queries) {
            // System.out.println("Query : " + query[0] + "-" + query[1]);
            int leftCandle = upperBound(candlePos, query[0]);
            int rightCandle = lowerBound(candlePos, query[1]);
            // System.out.println("leftCandle : " + leftCandle + " " + candlePos[leftCandle]);
            // System.out.println("rightCandle : " + rightCandle + " " + candlePos[rightCandle]);
            if(leftCandle != -1 && rightCandle != -1 && rightCandle > leftCandle) {
                int otherCandles = rightCandle - leftCandle - 1;
                // System.out.println(candlePos[rightCandle] + " - " + candlePos[leftCandle] + " - 1");
                // System.out.println(rightCandle + " - " + leftCandle + " + 1");
                // System.out.println("Other Candles " +  otherCandles);
                ans[i] = candlePos[rightCandle] - candlePos[leftCandle] - 1 - otherCandles;
                // 5 - 2 - 1 - (1 - 0 + 1)
                // 9 - 5 - 1 - (2 - 1 + 1)
                // 19 - 3 - 1 - (5 - 0 + 1)
                // 16 - 15 - 1 - (16 - 15 + 1)
            }
            i++;
        }
        return ans;
    }
}