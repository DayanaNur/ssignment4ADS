import java.util.HashMap;
import java.util.Map;

/**
 * Vertex class represents a vertex in a graph.
 *
 * @param <V> the type of data stored in the vertex
 */
public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    /**
     * Constructs a vertex with the specified data.
     *
     * @param data the data to be stored in the vertex
     */
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Gets the data stored in the vertex.
     *
     * @return the data stored in the vertex
     */
    public V getData() {
        return data;
    }

    /**
     * Sets the data stored in the vertex.
     *
     * @param data the data to be stored in the vertex
     */
    public void setData(V data) {
        this.data = data;
    }

    /**
     * Gets the map of adjacent vertices and their weights.
     *
     * @return the map of adjacent vertices and their weights
     */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    /**
     * Adds an adjacent vertex with the specified weight.
     *
     * @param destination the adjacent vertex
     * @param weight      the weight of the edge to the adjacent vertex
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    /**
     * Returns a string representation of the vertex.
     *
     * @return a string representation of the vertex
     */
    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                '}';
    }
}
