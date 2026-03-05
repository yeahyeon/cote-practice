class Solution {
    static int N;
    public int solution(int[] a) {        
        N = a.length;
        if(N==1) return 1;
        if(N==2) return 2;
        
        // i번째 풍선을 남기는 경우
        int[] leftMin = new int[N]; // i 왼쪽의 풍선들 중 최솟값
        int[] rightMin = new int[N]; // i 오른쪽의 풍선들 중 최솟값
        
        int min = a[0];
        for(int i = 1 ; i < N ; i++) {
            leftMin[i] = min;
            min = Math.min(min, a[i]);
        }
        
        min = a[N-1];
        for(int i = N-2 ; i > 0 ; i--) {
            rightMin[i] = min;
            min = Math.min(min, a[i]);
        }
        
        int answer = 2;
        for(int i = 1 ; i < N-1 ; i++) {
            // i-1, i, i+1과 비교
            // i에서 가장 크면 중복되는 최솟값이므로 포함하지 않는다
            if(leftMin[i] < a[i] && rightMin[i] < a[i]) continue;
            answer++;
        }
        
        return answer;
    }
    
}