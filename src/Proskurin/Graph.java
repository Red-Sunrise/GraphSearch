package Proskurin;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    public void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> tmp = adjacencyMap.get(a);

        if (tmp != null) {
            tmp.remove(b);
        } else tmp = new LinkedList<>();
        tmp.add(b);
        adjacencyMap.put(a, tmp);
    }

    public void addEdge(Node source, Node destination) {

        if (!adjacencyMap.keySet().contains(source))
            adjacencyMap.put(source, null);

        if (!adjacencyMap.keySet().contains(destination))
            adjacencyMap.put(destination, null);

        addEdgeHelper(source, destination);

        if (!directed) {
            addEdgeHelper(destination, source);
        }
    }

    public void printEdges() {
        for (Node node : adjacencyMap.keySet()) {
            System.out.print("Вершина " + node.getName() + " имеет связь с вершинами: ");
            for (Node neighbor : adjacencyMap.get(node)) {
                System.out.print(neighbor.getName() + " ");
            }
            System.out.println();
        }
    }

    public boolean hasEdge(Node source, Node destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).contains(destination);
    }

    public void resetNodesVisited() {
        for (Node node : adjacencyMap.keySet()) {
            node.unvisit();
        }
    }

    //Обход в ширину
    public void breadthFirstSearch(Node node) {
        if (node == null)
            return;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();

            if (current.isVisited())
                continue;

            current.visit();
            System.out.print(current.getName() + " --> ");

            LinkedList<Node> allNeighbors = adjacencyMap.get(current);

            if (allNeighbors == null)
                continue;

            for (Node neighbor : allNeighbors) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                }
            }
        }
    }

    //Обход в глубину
    public void depthFirstSearch(Node node) {
        node.visit();
        System.out.print(node.getName() + " --> ");

        LinkedList<Node> allNeighbors = adjacencyMap.get(node);
        if (allNeighbors == null)
            return;

        for (Node neighbor : allNeighbors) {
            if (!neighbor.isVisited())
                depthFirstSearch(neighbor);
        }
    }
}
