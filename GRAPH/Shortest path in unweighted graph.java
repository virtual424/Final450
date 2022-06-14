 static void shortestPath(ArrayList<ArrayList<Integer>> adj,int V, int s, int[] dist){
        boolean visited[] = new boolean[V];
        
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v:adj.get(u)){
                if(visited[v] == false){
                    dist[v] = dist[u]+1;
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        
        for(int i=0;i<V;i++){
            System.out.print(dist[i] + " ");
        }
    }
