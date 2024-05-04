class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int leftPtr = 0, rightPtr = n - 1;
        int noOfBoats = 0;
        while(leftPtr <= rightPtr) {
            if(people[leftPtr] + people[rightPtr] <= limit) {
                leftPtr++;
                rightPtr--;
            } else rightPtr--;
            noOfBoats++;
        }
        return noOfBoats;
    }
}