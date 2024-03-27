class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            if(!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1], new ArrayList<>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
                order.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int currCourse = queue.poll();
                if(map.containsKey(currCourse)) {
                    List<Integer> nextCourses = map.get(currCourse);
                    for(int nextCourse: nextCourses) {
                        indegree[nextCourse]--;
                        if(indegree[nextCourse] == 0) {
                            queue.add(nextCourse);
                            order.add(nextCourse);
                        }
                    }
                }
            }
        }
        return order.size() == numCourses ? order.stream().mapToInt(i->i).toArray() : new int[]{};
    }
}