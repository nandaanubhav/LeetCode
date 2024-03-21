class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i: nums) frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        int maxFrequencyElements = 0;
        Map.Entry<Integer, Integer> maxEntry = frequencyMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue() == maxEntry.getValue()) {
                maxFrequencyElements += maxEntry.getValue();
            }
        }
        return maxFrequencyElements;
    }
}