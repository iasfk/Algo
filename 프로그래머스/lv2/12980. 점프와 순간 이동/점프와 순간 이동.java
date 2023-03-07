import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while (n > 0) {
            // System.out.println(n+" "+ans);
            if (n%2 == 0) n /= 2;
            else {
                n--;
                ans++;
            }
        }
        return ans;
    }

}