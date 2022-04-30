package leetcode.solution.Graph;

import java.util.*;

/**
 * 399. Evaluate Division
 */
public class EvaluateDivision {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        EvaluateDivisionSolution solution = new EvaluateDivisionSolution();
        double[] ans = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ans));
        // [6.00000,0.50000,-1.00000,1.00000,-1.00000]
    }


}


class EvaluateDivisionSolution {

    /**
     * Adjacency List
     * <p>
     * <from point, <to point, values></>
     */
    HashMap<String, HashMap<String, Double>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String from = equation.get(0);
            String to = equation.get(1);
            double value = values[i];
            // put from -> to and to -> from.
            if (!graph.containsKey(from)) {
                graph.put(from, new HashMap<>());

            }
            if (!graph.containsKey(to)) {
                graph.put(to, new HashMap<>());

            }
            graph.get(from).put(to, value);
            graph.get(to).put(from, 1 / value);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            // record visited node, avoiding dead cycle.
            Set<String> visited = new HashSet<>();
            // search and calculate
            ans[i] = searchAndCalculate(from, to, visited);
        }

        return ans;
    }

    /**
     * search and calculate.
     * which is a backtracking.
     *
     * @param from
     * @param to
     * @param visited
     * @return
     */
    private double searchAndCalculate(String from, String to, Set<String> visited) {
        if (visited.contains(from)) {
            return -1.0;
        }
        if (!graph.containsKey(from)) {
            return -1.0;
        }

        // arrive the end.
        if (from.equals(to)) {
            return 1;
        }

        // sign as visited
        visited.add(from);

        // traverse the neighbors
        Map<String, Double> neighbor = graph.get(from);
        for (Map.Entry<String, Double> item : neighbor.entrySet()) {
            String str = item.getKey();
            double value = item.getValue();

            double nextVal = searchAndCalculate(str, to, visited);
            if (nextVal == -1.0) {
                continue;
            }

            // find the legal result
            return value * nextVal;
        }
        // revoke the choice
        visited.remove(from);

        // no result.
        return -1.0;

    }

}
