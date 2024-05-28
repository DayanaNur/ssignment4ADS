/**
 * MyGraph class represents a generic graph data structure.
 *
 * @param <Vertex> the type of vertices stored in the graph
 */
import java.util.*;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    // Constructor to create an undirected graph by default.
    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param v the vertex to be added
     */
    public void addVertex(Vertex v) {
        if (!map.containsKey(v)) {
            map.put(v, new LinkedList<>());
        }
    }

    /**
     * Adds an edge between two vertices with a specified weight.
     *
     * @param source the source vertex of the edge
     * @param dest   the destination vertex of the edge
     * @param weight the weight of the edge
     */    public void addEdge(Vertex source, Vertex dest, double weight) {
        // Ensure both vertices exist in the graph.
        addVertex(source);
        addVertex(dest);

        map.get(source).add(new Edge<>(source, dest, weight));
        if (undirected) {
            map.get(dest).add(new Edge<>(dest, source, weight));
        }
    }

    public int getVerticesCount() {
        return map.size();
    }

    /**
     * Gets the count of vertices in the graph.
     *
     * @return the count of vertices
     */    public <Vertex> Vertex[] getAdjVertices(Vertex v) {
        return null;
    }
    /**
     * Gets the count of edges in the graph.
     *
     * @return the count of edges
     */
    public int getEdgesCount() {
        int count = 0;
        // Iterate through all vertices in the graph.
        for (Vertex v : map.keySet()) {
            // Increment count by the number of edges adjacent to the current vertex.
            count += map.get(v).size();
        }
        // If undirected, divide count by 2 since each edge is counted twice.
        if (undirected)
            count /= 2;
        return count;
    }

    /**
     * Checks if a vertex exists in the graph.
     *
     * @param v the vertex to be checked
     * @return true if the vertex exists in the graph, false otherwise
     */    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    // Method to get the list of adjacent vertices for a given vertex.
    public List<Edge<Vertex>> adjacencyVertices(Vertex v) {
        // Return the list of adjacent vertices for the given vertex.
        return map.getOrDefault(v, new LinkedList<>());
    }

}
