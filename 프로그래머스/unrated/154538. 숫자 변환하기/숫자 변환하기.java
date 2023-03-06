import java.util.*;

class Solution {

    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        int[] dp = new int[y+1];
        Arrays.fill(dp, 1000001);
        
        dp[x] = 0;
    
        for (int i = x+1; i<=y; i++){
            if (x <= i-n) dp[i] = Math.min(dp[i], dp[i-n] + 1);
            if (i % 2 == 0 && x <= i/2) dp[i] = Math.min(dp[i], dp[i/2] +1);
            if (i % 3 == 0 && x <= i/3) dp[i] = Math.min(dp[i], dp[i/3] +1);
        }
        
        return dp[y] == 1000001 ? -1 : dp[y];
    }
}