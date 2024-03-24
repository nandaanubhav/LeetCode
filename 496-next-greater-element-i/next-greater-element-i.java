class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                int prevSmaller = stack.pop();
                nextGreater.put(prevSmaller, nums2[i]);
            }
            stack.add(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++) {
            nums1[i] = nextGreater.containsKey(nums1[i]) ? nextGreater.get(nums1[i]) : -1;
        }
        return nums1;
    }
}