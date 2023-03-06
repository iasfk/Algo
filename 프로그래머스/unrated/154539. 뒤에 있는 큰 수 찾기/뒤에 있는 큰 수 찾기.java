import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        
        for (int i = numbers.length -1; i >= 0; i--) {
            if (stk.isEmpty()){
                list.add(-1);
                stk.push(numbers[i]);
            }
            else {
                int a = -1;
                while (!stk.isEmpty()){
                    int s = stk.pop();
                    if (s > numbers[i]) {
                        a = s;
                        stk.push(s);
                        break;
                    }
                }
                
                list.add(a);
                
                stk.push(numbers[i]); 
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i=list.size()-1; i>=0; i--){
            answer[list.size()-1-i] = list.get(i);
        }
        return answer;
    }
}