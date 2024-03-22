class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int currX = 0, currY = 0;
        visited.add(currX + "-" + currY);
        for(int i=0; i<path.length(); i++) {
            char c = path.charAt(i);
            if(c == 'N') currY++;
            else if (c == 'E') currX++;
            else if (c == 'S') currY--;
            else if (c == 'W') currX--;
            String currPos = currX + "-" + currY;
            // System.out.println(currPos);
            if (visited.contains(currPos)) return true;
            else visited.add(currPos);
        }
        return false;
    }
}