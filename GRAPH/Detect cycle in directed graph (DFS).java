class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean visited[] = new boolean[V] ;
        boolean recursionStack[] = new boolean[V] ;
        
        for(int i=0;i<V;i++){
        if(!visited[i]&&isCyclicUtil(V,adj,visited,i,recursionStack)) return true;
            
        }
        return false;
    
        
        
    }
    
    public boolean isCyclicUtil(int V,ArrayList<ArrayList<Integer>> adj, boolean visited[],int node,boolean recursionStack[]){
            if(recursionStack[node]) return true;
            if(visited[node]) return false;
            
            visited[node] = true;
            recursionStack[node] = true;
            
            ArrayList<Integer> adjNodes = adj.get(node);
            
            for(int i = 0;i<adjNodes.size();i++){
                
                if(!visited[adjNodes.get(i)]&&isCyclicUtil(V,adj,visited,adjNodes.get(i),recursionStack)) return true;
                else if(recursionStack[adjNodes.get(i)]) return true;
            }
            
            recursionStack[node] = false;
            return false;
    }
}
