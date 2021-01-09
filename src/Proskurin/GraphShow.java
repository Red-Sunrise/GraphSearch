package Proskurin;

public class GraphShow {
    public static void main(String[] args) {
        Graph graph = new Graph(false);
        Node one = new Node(1, "1");
        Node two = new Node(2, "2");
        Node three = new Node(3, "3");
        Node four = new Node(4, "4");
        Node five = new Node(5, "5");
        Node six = new Node(6, "6");
        Node seven = new Node(7, "7");
        Node eight = new Node(8, "8");
        Node nine = new Node(9, "9");
        Node ten = new Node(10, "10");
        Node eleven = new Node(11, "11");
        Node twelve = new Node(12, "12");

        graph.addEdge(one, two);
        graph.addEdge(one, seven);
        graph.addEdge(one, eight);
        graph.addEdge(two, three);
        graph.addEdge(two, six);
        graph.addEdge(three, four);
        graph.addEdge(three, five);
        graph.addEdge(eight, nine);
        graph.addEdge(eight, twelve);
        graph.addEdge(nine, ten);
        graph.addEdge(nine, eleven);

        graph.printEdges();
        System.out.println("Обход в ширину");
        graph.breadthFirstSearch(one);
        graph.resetNodesVisited();
        System.out.println();
        System.out.println("Обход в глубину");
        graph.depthFirstSearch(one);
    }
}