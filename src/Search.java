import java.util.*;

/**
 * Search class represents a generic search algorithm for traversing a graph.
 *
 * @param <Vertex> the type of vertices in the graph
 */
public abstract class Search<Vertex> {
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected Vertex source;

    /**
     * Constructs a search algorithm with the specified source vertex.
     *
     * @param source the source vertex for the search
     */
    public Search(Vertex source) {
        this.source = source;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    /**
     * Checks if there is a path from the source vertex to the specified vertex.
     *
     * @param v the destination vertex
     * @return true if there is a path, false otherwise
     */
    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    /**
     * Returns an iterable collection representing the path from the source vertex to the specified vertex.
     *
     * @param v the destination vertex
     * @return an iterable collection representing the path
     */
    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex x = v; x != source; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(source);
        return path;
    }
}
