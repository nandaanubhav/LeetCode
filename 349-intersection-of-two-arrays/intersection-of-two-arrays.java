class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Values = new HashSet<>();
        for(int i: nums1) num1Values.add(i);
        Set<Integer> ans = new HashSet<>();
        for(int i: nums2) {
            if(num1Values.contains(i)) ans.add(i);
        }
        return ans.stream().mapToInt(i -> i).toArray(); 

    }
}