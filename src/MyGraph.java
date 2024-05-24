import java.util.*;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        if (!map.containsKey(v)) {
            map.put(v, new LinkedList<>());
        }
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
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
    public <Vertex> Vertex[] getAdjVertices(Vertex v) {
        return null;
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }
        if (undirected)
            count /= 2;
        return count;
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public List<Edge<Vertex>> adjacencyVertices(Vertex v) {
        return map.getOrDefault(v, new LinkedList<>());
    }

}
