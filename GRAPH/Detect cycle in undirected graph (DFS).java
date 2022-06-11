class Solution
{
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        
        for(int i = 0; i<V; i++){
            if(visited[i] == false){
            if(isCycleUtil(adj,i,-1,visited) == true) return true;
            }
        }
        
        return false;
    }
    
    public boolean isCycleUtil(ArrayList<ArrayList<Integer>> adj,int s,int parent,boolean visited[]){
            visited[s] = true;
            
            for(int u:adj.get(s)){
                if(visited[u] == false){
                    if(isCycleUtil(adj,u,s,visited) == true) return true;
                }else{
                    if(u!= parent) return true;
                }
            }
            return false;
    }
}
