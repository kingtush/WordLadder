import java.util.*;


public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    /*
    Constructor to initialize a graph with V vertices.
     */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }


   //return number of vertices in the graph
    public int V() {

        return V;
    }

    /*
    return number of edges in the graph
     */
    public int E() {

        return E;
    }

    /*
    This function is making sure that the vertex is valid i.e, is in between 0 and the maximum
    index V-1
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /*
    this function adds an edge to the graph between nodes v and w.
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        //adj[w].add(v);
    }

    /*
    Returns the list of vertices adjacent to vertex v.
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /*
    Returns the degree of a vertex
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }


    /*
        Overloaded toString method to show the graph each word and its adjacency list.
     */
    public String toString(List<String> listy) {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(listy.get(v) + ": ");
            for (int w : adj[v]) {
                s.append(listy.get(w) + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


}