import java.util.*;

class Solution {
    static int N;
    static List<Integer>[] graph;
    static int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        answer = new int[sources.length];
        
        N = n;
        graph = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        Arrays.fill(dist, -1);
        
        for(int[] road : roads) {
            int from = road[0], to = road[1];
            graph[from].add(to); graph[to].add(from);
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(destination);
        dist[destination] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : graph[cur]) {
                if(dist[next] == -1) { // 한 번도 방문한 적 없음
                    dist[next] = dist[cur] + 1;
                    q.addLast(next);
                } else { // 방문한 적 있음
                    if(dist[next] > dist[cur] + 1) {
                        q.addLast(next);
                        dist[next] = dist[cur] + 1;
                    }
                }
                
            }
        }
        
        for(int i = 0 ; i < sources.length ; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}
