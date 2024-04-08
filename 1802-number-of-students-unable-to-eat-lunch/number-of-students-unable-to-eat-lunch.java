class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>(Arrays.stream(students).boxed().toList());
        Queue<Integer> sandWichQueue = new LinkedList<>(Arrays.stream(sandwiches).boxed().toList());
        int studentsMissed = 0;
        while(studentsMissed < studentQueue.size()) {
            if(studentQueue.peek() == sandWichQueue.peek()) {
                sandWichQueue.poll();
                studentQueue.poll();
                studentsMissed = 0;
            } else {
                studentsMissed += 1;
                studentQueue.add(studentQueue.poll());
            }
        }
        return studentQueue.size();
    }
}