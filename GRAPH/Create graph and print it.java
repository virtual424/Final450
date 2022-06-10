import java.util.*;

class Main {

  static void addEdge(ArrayList<ArrayList<Integer>> graph,int u, int v){
    graph.get(u).add(v);
    graph.get(v).add(u);
  }

  static void bfs(ArrayList<ArrayList<Integer>> graph, int numberOfNodes){
    boolean visited[] = new boolean[numberOfNodes];
    Queue<Integer> q = new LinkedList<>();
    q.add(0);
    visited[0] = true;
    
    while(!q.isEmpty()){
      int node = q.poll();
      System.out.print(node+" ");

      ArrayList<Integer> adjNodes = graph.get(node);

      for(int i=0;i<adjNodes.size();i++){
        if(visited[adjNodes.get(i)]) continue;
        q.add(adjNodes.get(i));
        visited[adjNodes.get(i)] = true;
      }
      
    }
  }

  static void dfs(ArrayList<ArrayList<Integer>> graph, int numberOfNodes){

    boolean visited[] = new boolean[numberOfNodes];
  
    for(int i=0;i<numberOfNodes;i++){
      if(visited[i]!=true){
        dfsUtil(graph, visited, i);
      }
    }
    
  }
  
  static void dfsUtil(ArrayList<ArrayList<Integer>> graph, boolean visited[], int node){
      if(visited[node]) return;

      visited[node] = true;
      System.out.print(node+" ");
      ArrayList<Integer> adjNodes = graph.get(node);
      
      for(int i=0;i<adjNodes.size();i++){
       dfsUtil(graph,visited,adjNodes.get(i));
      }
  }

  public static void main(String[] args) {
    int numberOfNodes = 5;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    for(int i=0;i<numberOfNodes;i++){
      graph.add(new ArrayList<Integer>());
    }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

    bfs(graph,numberOfNodes);
    System.out.println();
    dfs(graph,numberOfNodes);
    
  }

  
  
}
