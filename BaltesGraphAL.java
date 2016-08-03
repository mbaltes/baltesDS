package baltesDS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BaltesGraphAL {
  private Map<Integer, List<Integer>> adjacencyList;
  
  public BaltesGraphAL(int numberOfVertices) {
    adjacencyList = new HashMap<Integer, List<Integer>>();
    for (int i = 1; i <= numberOfVertices; i++) {
      adjacencyList.put(i, new LinkedList<Integer>());
    }
  }
  
  public void setEdge(int source, int destination) {
    if (source > adjacencyList.size() || destination > adjacencyList.size()) {
      System.out.println("The vertex entered is not in the graph.");
    }
    List<Integer> sourceList = adjacencyList.get(source);
    sourceList.add(destination);
    List<Integer> destinationList = adjacencyList.get(destination);
    destinationList.add(source);
  }
  
  public List<Integer> getEdge(int source) {
    if (source > adjacencyList.size()) {
      System.out.println("The vertex entered is not in the graph.");
    }
    return adjacencyList.get(source);
  }
  
  public static void main(String[] args) {
    System.out.println("Enter number of vertices and edges in graph (V E): ");
    Scanner scan = new Scanner(System.in);
    int numberOfVertices = scan.nextInt();
    int numberOfEdges = scan.nextInt();
    BaltesGraphAL graphAL = new BaltesGraphAL(numberOfVertices);
    
    // Set edges.
    int count = 1;
    int source, destination;
    System.out.println("Enter edges in graph (source, destination)");
    while (count <= numberOfEdges) {
      source = scan.nextInt();
      destination = scan.nextInt();
      graphAL.setEdge(source, destination);
      count++;
    }
    scan.close();
    
    // Print adjacency list to screen.
    System.out.println("Graph adjacency list is...");
    for (int i = 1; i <= numberOfVertices; i++) {
      System.out.print(i + "->");
      List<Integer> edgeList = graphAL.getEdge(i);
      for (int j = 1; ; j++) {
        if (j != edgeList.size()) {
          System.out.print(edgeList.get(j - 1) + "->");
        } else {
          System.out.print(edgeList.get(j - 1));
          break;
        }
      }
      System.out.println();
    }
  }
}
