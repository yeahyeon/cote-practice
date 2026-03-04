import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int ans = 0;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        graph = new ArrayList[100001];
        for(int i = 0 ; i < 100001 ; i++) graph[i] = new ArrayList<>();
        for(int i = 0 ; i < lighthouse.length ; i++) {
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        dfs(1, 0);
        return ans;
    }
    
    public int dfs(int cur, int prev) {
        if(graph[cur].size() == 1 && graph[cur].get(0) == prev) // 리프 노드
            return 1;
        
        int tmp = 0;
        for(int next : graph[cur]) {
            if(next == prev) continue;
            tmp += dfs(next, cur);
        }
        
        if(tmp == 0) return 1; // 다음 등불이 켜져야함 (이웃한 노드 등불 모두 off)
        else ans++; // 지금 등불이 켜져야함
        
        return 0;
    }
}