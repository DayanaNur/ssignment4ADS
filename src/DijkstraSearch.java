import java.util.*;

/**
 * DijkstraSearch class represents a Dijkstra's shortest path algorithm for weighted graphs.
 *
 * @param <Vertex> the type of vertices in the graph
 */
public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final PriorityQueue<Vertex> priorityQueue;
    private final Map<Vertex, Double> distances;
    private final WeightedGraph<Vertex> graph;

    /**
     * Constructs a DijkstraSearch algorithm with the specified graph and source vertex.
     *
     * @param graph  the weighted graph to be searched
     * @param source the source vertex for the search
     */
    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        this.graph = graph;
        this.distances = new HashMap<>();
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        dijkstra(source);
    }

    /**
     * Performs Dijkstra's algorithm to find shortest paths from the source vertex.
     *
     * @param source the source vertex for the shortest paths
     */
    private void dijkstra(Vertex source) {
        distances.put(source, 0.0);
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            Vertex currentNode = priorityQueue.poll();
            marked.add(currentNode);

            for (Edge<Vertex> edge : graph.getEdges(currentNode)) {
                Vertex neighbor = edge.getDestination();
                if (!marked.contains(neighbor)) {
                    double newDist = distances.get(currentNode) + edge.getWeight();
                    if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                        distances.put(neighbor, newDist);
                        edgeTo.put(neighbor, currentNode);
                        priorityQueue.add(neighbor);
                    }
                }
            }
        }
    }

    /**
     * Gets the shortest distance to the specified vertex from the source vertex.
     *
     * @param v the destination vertex
     * @return the shortest distance to the destination vertex
     */
    public double distTo(Vertex v) {
        return distances.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}
