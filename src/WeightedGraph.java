import java.util.*;

/**
 * WeightedGraph class represents a weighted graph data structure.
 *
 * @param <Vertex> the type of vertices stored in the graph
 */
public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> adjacencyMap;

    /**
     * Constructs an undirected weighted graph.
     */
    public WeightedGraph() {
        this(true);
    }

    /**
     * Constructs a weighted graph with specified directionality.
     *
     * @param undirected true if the graph is undirected, false otherwise
     */
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.adjacencyMap = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex the vertex to be added
     */
    public void addVertex(Vertex vertex) {
        adjacencyMap.putIfAbsent(vertex, new ArrayList<>());
    }

    /**
     * Adds a weighted edge between two vertices.
     *
     * @param source      the source vertex of the edge
     * @param destination the destination vertex of the edge
     * @param weight      the weight of the edge
     */
    public void addEdge(Vertex source, Vertex destination, double weight) {
        addVertex(source);
        addVertex(destination);

        // Ensure that the edge doesn't already exist and it's not a self-loop.
        if (!hasEdge(source, destination) && !source.equals(destination)) {
            adjacencyMap.get(source).add(new Edge<>(source, destination, weight));
            if (undirected) {
                adjacencyMap.get(destination).add(new Edge<>(destination, source, weight));
            }
        }
    }

    /**
     * Gets the count of vertices in the graph.
     *
     * @return the count of vertices
     */
    public int getVertexCount() {
        return adjacencyMap.size();
    }

    /**
     * Gets the count of edges in the graph.
     *
     * @return the count of edges
     */
    public int getEdgeCount() {
        int count = adjacencyMap.values().stream().mapToInt(List::size).sum();
        return undirected ? count / 2 : count;
    }

    /**
     * Checks if a vertex exists in the graph.
     *
     * @param vertex the vertex to be checked
     * @return true if the vertex exists, false otherwise
     */
    public boolean hasVertex(Vertex vertex) {
        return adjacencyMap.containsKey(vertex);
    }

    /**
     * Checks if an edge exists between two vertices.
     *
     * @param source      the source vertex of the edge
     * @param destination the destination vertex of the edge
     * @return true if the edge exists, false otherwise
     */
    public boolean hasEdge(Vertex source, Vertex destination) {
        if (!hasVertex(source)) return false;
        return adjacencyMap.get(source).stream().anyMatch(edge -> edge.getDestination().equals(destination));
    }

    /**
     * Gets a list of adjacent vertices for a given vertex.
     *
     * @param vertex the vertex whose adjacent vertices are to be retrieved
     * @return a list of adjacent vertices
     */
    public List<Vertex> getAdjVertices(Vertex vertex) {
        if (!hasVertex(vertex)) return Collections.emptyList();
        List<Vertex> adjVertices = new ArrayList<>();
        for (Edge<Vertex> edge : adjacencyMap.get(vertex)) {
            adjVertices.add(edge.getDestination());
        }
        return adjVertices;
    }

    /**
     * Gets an iterable collection of edges incident to a given vertex.
     *
     * @param vertex the vertex whose incident edges are to be retrieved
     * @return an iterable collection of incident edges
     */
    public Iterable<Edge<Vertex>> getEdges(Vertex vertex) {
        return hasVertex(vertex) ? adjacencyMap.get(vertex) : Collections.emptyList();
    }
}
