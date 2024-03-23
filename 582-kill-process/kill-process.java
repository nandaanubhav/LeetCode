class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i : pid) {
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<ppid.size(); i++) {
            if(ppid.get(i) == 0) continue;
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Stack<Integer> processToBeKilled = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        processToBeKilled.add(kill);
        while(!processToBeKilled.isEmpty()) {
            int process = processToBeKilled.pop();
            ans.add(process);
            processToBeKilled.addAll(map.get(process));
        }
        return ans;
    }
}