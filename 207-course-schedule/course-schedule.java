class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }
        int coursesTaken = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            coursesTaken++;
            for(int neighbor : adj.get(course)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return coursesTaken == numCourses;
    }
}