import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for (int i=0; i<numbers.length; i++)
            str[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(str, new Comparator<String>(){
           @Override
            public int compare(String n1, String n2) {
                return (n2+n1).compareTo(n1+n2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s : str)
            sb.append(s);
        if (sb.toString().startsWith("0"))
            return "0";
        return sb.toString();
    }
}