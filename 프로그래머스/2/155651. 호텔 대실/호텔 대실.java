import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (x,y) -> x[0].compareTo(y[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        
        for (String[] book : book_time) {
            String[] starts = book[0].split(":");
            String[] ends = book[1].split(":");
            
            int s = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
            int e = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]) + 10;
            
            if(pq.isEmpty()) {
                answer++;
                pq.add(new int[]{s, e});
                continue;
            }
            
            int[] prev = pq.poll();
            
            int prevS = prev[0], prevE = prev[1];
            
            if(s >= prevE) {
                pq.add(new int[] {s, e});
            } else {
                answer++;
                pq.add(new int[] {s, e});
                pq.add(prev);
            }
            
            
        }
        
        return answer;
    }
}