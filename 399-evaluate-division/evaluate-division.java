class Solution {
    private double evaluate(HashMap<String, HashMap<String, Double>> graph, String curr, String target, double accProduct, Set<String> seen) {
        seen.add(curr);
        double ret = -1.0;

        Map<String, Double> neighbors = graph.get(curr);
        if(neighbors.containsKey(target)) return accProduct * neighbors.get(target);
        else {
            for(Map.Entry<String, Double> entry: neighbors.entrySet()) {
                String nextNode = entry.getKey();
                if(seen.contains(nextNode)) continue;
                ret = evaluate(graph, nextNode, target, accProduct * entry.getValue(), seen);
                if(ret != -1.0) break;
            }
        }
        return ret;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i=0; i<equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];
            if(!graph.containsKey(dividend)) graph.put(dividend, new HashMap<>());
            if(!graph.containsKey(divisor)) graph.put(divisor, new HashMap<>());
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }

        double[] ans = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                ans[i] = -1;
            } else if (dividend == divisor) {
                ans[i] = 1;
            } else {
                HashSet<String> seen = new HashSet<>();
                ans[i] = evaluate(graph, dividend, divisor, 1, seen);
            }
        }
        return ans;
    }
}