import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stk = new Stack<>();
        boolean flag = true;
        int cnt = 0;
        while (flag){
            if (cnt >= s.length()){
                if (stk.isEmpty())
                    return 1;
                else
                    return 0;
            }
            if (stk.isEmpty()) stk.add(s.charAt(cnt++));
            else {
                if (stk.peek() == s.charAt(cnt))
                  {stk.pop();
                  cnt++;}
                else
                stk.add(s.charAt(cnt++));
                }
        }
        return 0;
    }
}