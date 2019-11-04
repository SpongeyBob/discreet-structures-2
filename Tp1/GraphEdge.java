package Tp1;

public class GraphEdge {
    private GraphNode node;
    private int distance;
    GraphEdge(GraphNode node_ ,int dist){
        node = node_;
        distance = dist;
    }

    public GraphNode getNode() { return node; }

    public int getDistance() {
        return distance;
    }

    public boolean isEqual(GraphEdge obj) {
        return (node.getId() == obj.node.getId() && distance==obj.distance);
    }
}
