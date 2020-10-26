import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Graph {

    // Keep a fast index to nodes in the map
    private Map<Integer, Vertex> vertexNames;

    /**
     * Construct an empty Graph with a map. The map's key is the name of a 
     * vertex
     * and the map's value is the vertex object.
     */
    public Graph() {
        vertexNames = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph. Throws IllegalArgumentException if two 
     * vertices
     * with the same name are added.
     *
     * @param v (Vertex) vertex to be added to the graph
     */
    public void addVertex(Vertex v) {
        if (vertexNames.containsKey(v.name))
            throw new IllegalArgumentException("Cannot create new vertex with" +
                    " existing name.");
        vertexNames.put(v.name, v);
    }

    /**
     * Gets a collection of all the vertices in the graph
     *
     * @return (Collection < Vertex >) collection of all the vertices in the 
     * graph
     */
    public Collection<Vertex> getVertices() {
        return vertexNames.values();
    }

    /**
     * Gets the vertex object with the given name
     *
     * @param name (String) name of the vertex object requested
     * @return (Vertex) vertex object associated with the name
     */
    public Vertex getVertex(String name) {
        return vertexNames.get(name);
    }

    /**
     * Adds a directed edge from vertex u to vertex v
     *
     * @param nameU (String) name of vertex u
     * @param nameV (String) name of vertex v
     * @param cost  (double) cost of the edge between vertex u and v
     */
    public void addEdge(int nameU, int nameV, Double cost) {
        if (!vertexNames.containsKey(nameU))
            throw new IllegalArgumentException(nameU + " does not exist. " +
                    "Cannot create edge.");
        if (!vertexNames.containsKey(nameV))
            throw new IllegalArgumentException(nameV + " does not exist. " +
                    "Cannot create edge.");
        Vertex sourceVertex = vertexNames.get(nameU);
        Vertex targetVertex = vertexNames.get(nameV);
        Edge newEdge = new Edge(sourceVertex, targetVertex, cost);
        sourceVertex.addEdge(newEdge);
    }

    /**
     * Adds an undirected edge between vertex u and vertex v by adding a 
     * directed
     * edge from u to v, then a directed edge from v to u
     *
     * @param name  (String) name of vertex u
     * @param name2 (String) name of vertex v
     * @param cost  (double) cost of the edge between vertex u and v
     */
    public void addUndirectedEdge(int name, int name2, double cost) {
        addEdge(name, name2, cost);
        addEdge(name2, name, cost);
    }


    /**
     * Computes the euclidean distance between two points as described by their
     * coordinates
     *
     * @param ux (double) x coordinate of point u
     * @param uy (double) y coordinate of point u
     * @param vx (double) x coordinate of point v
     * @param vy (double) y coordinate of point v
     * @return (double) distance between the two points
     */
    public double computeEuclideanDistance(double ux, double uy, double vx, 
                                           double vy) {
        return Math.sqrt(Math.pow(ux - vx, 2) + Math.pow(uy - vy, 2));
    }

    /**
     * Computes euclidean distance between two vertices as described by their
     * coordinates
     *
     * @param u (Vertex) vertex u
     * @param v (Vertex) vertex v
     * @return (double) distance between two vertices
     */
    public double computeEuclideanDistance(Vertex u, Vertex v) {
        return computeEuclideanDistance(u.x, u.y, v.x, v.y);
    }

    /**
     * Calculates the euclidean distance for all edges in the map using the
     * computeEuclideanCost method.
     */
    public void computeAllEuclideanDistances() {
        for (Vertex u : getVertices())
            for (Edge uv : u.adjacentEdges) {
                Vertex v = uv.target;
                uv.distance = computeEuclideanDistance(u.x, u.y, v.x, v.y);
            }
    }


    // STUDENT CODE STARTS HERE

    public void generateRandomVertices(int n) {
        vertexNames = new HashMap<>(); // reset the vertex hashmap
        
        for (int i = 0; i < n; i++) {
            int randX = (int) (Math.random() * 100) + 0;
            int randY = (int) (Math.random() * 100) + 0;
            Vertex v = new Vertex(i, randX, randY);
            this.addVertex(v);
        }

        for (Vertex v1 : getVertices()) {
            for (Vertex v2 : getVertices()) {
                if (v1.name < v2.name) {
                    addUndirectedEdge(v1.name, v2.name, 100);
                }
            }
        }

        computeAllEuclideanDistances(); // compute distances
    }

    public List<Edge> nearestNeighborTsp() {
        List<Edge> path = new LinkedList<Edge>();
        nearestHelper();
        Vertex source = vertexNames.get(0);
        
        while (source.prev != null) {
            for (Edge edge : source.adjacentEdges) {
                if (edge.target == source.prev) {
                    path.add(edge);
                }
            }
            
            source = source.prev;
        }
        
        return path;
    }

    // nearest neighbor helper method
    public void nearestHelper() {
        Vertex tmp = vertexNames.get(0);
        nearestRec(tmp);
    }

    // nearest neighbor helper method
    public void nearestRec(Vertex v1) {
        boolean flag = false;
        double low = Double.POSITIVE_INFINITY;
        v1.known = true;
        
        for (Edge edge : v1.adjacentEdges) {
            if (!edge.target.known) {
                flag = true;
                if (edge.distance < low) {
                    low = edge.distance;
                    v1.prev = edge.target;
                }
            }
        }
        
        if (flag) {
            nearestRec(v1.prev);
        }
        
        v1.known = false;
    }

    public List<Edge> bruteForceTsp() {
        LinkedList<LinkedList<Edge>> allPath = new LinkedList<LinkedList<Edge>>();
        List<Edge> path = new LinkedList<Edge>();

        int numEdge = getVertices().size() - 1;
        System.out.println(numEdge);

        Vertex v = vertexNames.get(0);
        for (int i = 0; i < numEdge; i++) {
            Vertex tempV = v;
            LinkedList<Edge> tmp = new LinkedList<Edge>();
            for (int j = i; j < numEdge; j++) {
                tmp.add(tempV.adjacentEdges.get(j));
                tempV = tempV.adjacentEdges.get(j).target;
            }
            int remain = numEdge - tmp.size();
            for (int k = remain; k > 0; k--) {
                tmp.add(tempV.adjacentEdges.get(k));
                tempV = tempV.adjacentEdges.get(k).target;
            }
            allPath.add(tmp);
        }
        
        path = calcShortestPath(allPath);
        return path;
    }

    // brute force helper method
    public List<Edge> calcShortestPath(LinkedList<LinkedList<Edge>> a) {
        double low = Double.POSITIVE_INFINITY;
        List<Edge> temp = new LinkedList<Edge>();
        for (LinkedList<Edge> l : a) {
            double sum = 0;
            for (Edge e : l) {
                sum += e.distance;
            }
            if (sum < low) {
                temp = l;
                low = sum;
            }
        }
        return temp;

    }

    /**
     * Prints out the adjacency list of the graph for debugging
     */
    public void printAdjacencyList() {
        for (int u : vertexNames.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(u);
            sb.append(" -> [ ");
            for (Edge e : vertexNames.get(u).adjacentEdges) {
                sb.append(e.target.name);
                sb.append("(");
                sb.append(e.distance);
                sb.append(") ");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}


