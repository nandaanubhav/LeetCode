class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>(Arrays.stream(students).boxed().toList());
        int studentsMissed = 0, sandwichIndex = 0;
        while(studentsMissed < studentQueue.size()) {
            if(studentQueue.peek() == sandwiches[sandwichIndex]) {
                sandwichIndex++;
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