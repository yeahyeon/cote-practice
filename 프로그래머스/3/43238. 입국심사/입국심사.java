import java.util.*;

class Solution {
    static int N;
    public long solution(int n, int[] times) {
        long answer = 0;
        
        N = times.length;
        Arrays.sort(times);
        long left = 0;
        long right = times[N-1] * (long) n;
        
        while(left <= right) {
            long mid = (left + right) / 2 ;
            long sum = 0;
            
            for(int i = 0 ; i < N ; i++) {
                sum += mid / times[i];
            }
            
            if(sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
                
            }
        }
        
        return answer;
    }
}