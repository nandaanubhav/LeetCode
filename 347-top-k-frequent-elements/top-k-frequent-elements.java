class Solution {
    class Number implements Comparable<Number> {
        int num;
        int freq;

        public Number(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Number number) {
            return number.freq - freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> freqSet = new HashMap<>();
        for(int i : nums) {
            freqSet.put(i, freqSet.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freqSet.get(a) - freqSet.get(b));
        for(int key: freqSet.keySet()) {
            pq.add(key);
            while(pq.size() > k) pq.poll();
        }
        // Number[] numberList = new Number[freqSet.size()];
        // int i = 0;
        // for(Map.Entry<Integer, Integer> entry : freqSet.entrySet()) {
        //     numberList[i] = new Number(entry.getKey(), entry.getValue());
        //     i++;
        // }
        // Arrays.sort(numberList);
        
        int[] top = new int[k];
        for(int j = 0; j < k; j++) {
            top[j] = pq.poll();
        }
        // freqSet.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        return top;
    }
}