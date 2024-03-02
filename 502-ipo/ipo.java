class Solution {
    class Project implements Comparable<Project> {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        public int compareTo(Project project) {
            return capital - project.capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projectList = new Project[n];
        for(int i=0; i<n; i++) {
            projectList[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projectList);
        PriorityQueue<Integer> availProjects = new PriorityQueue<>(Collections.reverseOrder());
        int projectCompleted = 0, projectAvail = 0;
        while(projectCompleted < k) {
            while(projectAvail < n && w >= projectList[projectAvail].capital) {
                availProjects.add(projectList[projectAvail].profit);
                System.out.println();
                projectAvail++;
            }
            if(availProjects.isEmpty()) break;
            w += availProjects.poll();
            projectCompleted++;
        }
        return w;
        
    }
}