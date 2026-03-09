import java.util.*;
import java.lang.*;

class Solution {
    static int N;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        N = numbers.length;

        for (int i = 0; i < N; i++) {
            long num = numbers[i];
            String binary = Long.toBinaryString(num);
            
            // 가능한 문자열의 길이는 2^n - 1
            int depth = 1;
            while (true) {
                int targetLen = (int)Math.pow(2, depth) - 1;
                if (binary.length() <= targetLen) break;
                depth++;
            }
            
            int targetLen = (int)Math.pow(2, depth) - 1;

            // 앞에 0 추가
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < targetLen - binary.length(); j++) {
                sb.append('0');
            }
            sb.append(binary);
            binary = sb.toString();
            
            answer[i] = dfs(binary) ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean dfs(String binary) {
        int l = binary.length();
        
        if (l == 1) return true;
        
        int m = l / 2;
        String leftBinary = binary.substring(0, m);
        String rightBinary = binary.substring(m + 1, l);
        
        // 현재 루트가 0이면 하위에 1 불가
        if (binary.charAt(m) == '0') {
            if (leftBinary.contains("1") || rightBinary.contains("1")) return false;
        }
        
        return dfs(leftBinary) && dfs(rightBinary);
    }
}