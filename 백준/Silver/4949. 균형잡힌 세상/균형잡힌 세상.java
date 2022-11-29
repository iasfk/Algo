import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			Stack<Character> stk = new Stack<>();
			if (str.equals("."))
				{System.out.println(sb);
				return;}
			for (int i = 0; i<str.length(); i++) {
				char c = str.charAt(i);
				if (check(c))
				{
					if (stk.isEmpty() || open(c))
						stk.add(c);
					else {
						char k = stk.peek();
						if (k == '(' && c == ')')
							stk.pop();
						else if (k == '[' && c == ']')
							stk.pop();
						else
							stk.add(c);
					}	
				}
			}
			if (stk.isEmpty()) {
				sb.append("yes").append('\n');
			}else
				sb.append("no").append('\n');
		}
	}
	
	static boolean check(char a) {
		if (a == '(' || a==')' || a=='[' || a==']')
			return true;
		return false;
	}
	
	static boolean open(char a) {
		if (a == '(' || a == '[')
			return true;
		return false;
	}
}
