public class Edge<Vertex> {
    private final Vertex source;
    private final Vertex dest;
    private final double weight;

    public Edge(Vertex source, Vertex dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }
}
