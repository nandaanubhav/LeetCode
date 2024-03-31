class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, TreeMap<Integer, String>> userWebsite = new HashMap<>();
        int n = username.length;
        for(int i=0; i<n; i++) {
            if(!userWebsite.containsKey(username[i])) userWebsite.put(username[i], new TreeMap<Integer, String>());
            userWebsite.get(username[i]).put(timestamp[i], website[i]);
        }
        HashMap<String, Integer> visitedSeq = new HashMap<>();
        String ans = "";
        for(String user : userWebsite.keySet()) {
            List<String> visitedWebsites = new ArrayList<>(userWebsite.get(user).values());
            if(visitedWebsites.size() < 3) continue;
            Set<String> uniquePatters = new HashSet<>();
            for(int i=0; i<visitedWebsites.size(); i++) {
                for(int j=i+1; j<visitedWebsites.size(); j++) {
                    for(int k=j+1; k<visitedWebsites.size(); k++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(visitedWebsites.get(i)).append(" ");
                        sb.append(visitedWebsites.get(j)).append(" ");
                        sb.append(visitedWebsites.get(k));
                        String pattern = sb.toString();
                        if(!uniquePatters.contains(pattern)) {
                            visitedSeq.put(pattern, visitedSeq.getOrDefault(pattern, 0) + 1);
                            uniquePatters.add(pattern);
                        }
                        if(ans.equals("") || visitedSeq.get(pattern) > visitedSeq.get(ans) || 
                          (visitedSeq.get(pattern) == visitedSeq.get(ans) && ans.compareTo(pattern) > 0)) {
                            // System.out.println("Changing " + ans + " to " + sb.toString());
                            ans = pattern;
                          }
                    }
                }
            }
        }
        // System.out.println(visitedSeq);
        String[] ansSplit = ans.split(" ");
        return Arrays.asList(ansSplit);
    }
}