import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BloombergAllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        int currentNode = 0;
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);

        backtrack(currentNode, target, path, graph, result);

        return result;
    }

    private void backtrack(int currentNode, int target, LinkedList<Integer> path, int[][] graph, List<List<Integer>> result) {
        if (currentNode == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : graph[currentNode]) {
            path.addLast(nextNode);
            backtrack(nextNode, target, path, graph, result);
            path.removeLast();
        }
    }

}