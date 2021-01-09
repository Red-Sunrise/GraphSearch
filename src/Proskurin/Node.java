package Proskurin;

public class Node {
    private int n;
    private String name;
    private boolean visited;

    public Node(int n, String name) {
        this.n = n;
        this.name = name;
        visited = false;
    }

    public void visit() {
        visited = true;
    }

    public void unvisit() {
        visited = false;
    }

    public int getN() {
        return n;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setName(String name) {
        this.name = name;
    }
}
