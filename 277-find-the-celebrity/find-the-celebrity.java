/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    private boolean isCelebrity(int candidate, int totalPeople) {
        for(int i=0; i<totalPeople; i++) {
            if(i != candidate) {
                if(knows(candidate, i) || !knows(i, candidate)) {
                    return false;
                }
            }
        }
        return true;
    }
    public int findCelebrity(int n) {
        int celebrityCandidate = 0;
        for(int i = 1; i<n; i++) {
            if(knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if(isCelebrity(celebrityCandidate, n)) {
            return celebrityCandidate;
        }
        return -1;
    }
}