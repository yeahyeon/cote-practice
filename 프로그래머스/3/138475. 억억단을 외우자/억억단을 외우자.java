import java.util.*;

class Solution {
    static int[] cnt;
    static int N;
    
    public int[] solution(int e, int[] starts) {
        // s <= num <= e
        // ex. 6의 경우 s~e 중 6단 이하에서 등장 결국 num 을 찾으려면 s~min(num,e)
        // num의 약수이면 1개 
        // 즉 각 수는 약수 중 e 이하인 단에서 나타남
        
        N = starts.length;
        int[] answer = new int[N];
        cnt = new int[e+1];
        
        for(int i = 1 ; i <= e ; i++) {
            int t = i;
            while(t <= e) {
                cnt[t]++;
                t += i;
            }
        }
        
        //System.out.println(Arrays.toString(cnt));
        
        int ans = 0, idx = 0;
        for(int i = e ; i >= 0 ; i--) {
            idx = ans > cnt[i] ? idx : i;
            ans = ans > cnt[i] ? ans : cnt[i];
            cnt[i] = idx;
        }
        
        for(int i = 0 ; i < N ; i++) {
            answer[i] = cnt[starts[i]];
        }
        
        //System.out.println(Arrays.toString(answer));
        
        
        return answer;
    }
}