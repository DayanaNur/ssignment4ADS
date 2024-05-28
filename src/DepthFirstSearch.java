import java.util.*;

/**
 * DepthFirstSearch class represents a depth-first search algorithm for traversing a graph.
 *
 * @param <Vertex> the type of vertices in the graph
 */
public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    /**
     * Constructs a depth-first search algorithm with the specified graph and source vertex.
     *
     * @param graph  the graph to be searched
     * @param source the source vertex for the search
     */
    public DepthFirstSearch(MyGraph<String> graph, String source) {
        super((Vertex) source);
        dfs(graph, source);
    }

    /**
     * Performs depth-first search starting from the specified vertex.
     *
     * @param graph   the graph to be searched
     * @param current the current vertex in the depth-first search
     */
    private void dfs(MyGraph<String> graph, String current) {
        Stack<Vertex> stack = new Stack<>();
        marked.add((Vertex) current);
        stack.push((Vertex) current);

        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            boolean hasUnmarkedNeighbor = false;

            for (Vertex V : graph.getAdjVertices(v)) {
                if (!marked.contains(V)) {
                    marked.add(V);
                    edgeTo.put(V, v);
                    stack.push(V);
                    hasUnmarkedNeighbor = true;
                    break;
                }
            }

            if (!hasUnmarkedNeighbor) {

            }
        }
    }
}
