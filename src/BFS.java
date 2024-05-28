import java.util.*;

/**
 * BFS class represents a breadth-first search algorithm for traversing a graph.
 *
 * @param <Vertex> the type of vertices in the graph
 */
public class BFS<Vertex> extends Search<Vertex> {
    /**
     * Constructs a breadth-first search algorithm with the specified graph and source vertex.
     *
     * @param graph  the graph to be searched
     * @param source the source vertex for the search
     */
    public BFS(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        bfs(graph, source);
    }

    /**
     * Performs breadth-first search starting from the specified vertex.
     *
     * @param graph   the graph to be searched
     * @param current the current vertex in the breadth-first search
     */
    private void bfs(MyGraph<Vertex> graph, Vertex current) {
        Queue<Vertex> queue = new LinkedList<>();
        marked.add(current);
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Edge<Vertex> edge : graph.adjacencyVertices(v)) {
                Vertex dest = edge.getDestination();
                if (!marked.contains(dest)) {
                    marked.add(dest);
                    edgeTo.put(dest, v);
                    queue.add(dest);
                }
            }
        }
    }
}
