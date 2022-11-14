import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for (int i=0; i<citations.length; i++){
            if (citations[i] - citations.length + i >= 0)
                return citations.length - i;
        }
        return 0;
    }
}