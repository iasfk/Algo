import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stk= new Stack<>();
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0)
				stk.pop();
			else
				stk.add(a);
		}
		int sum = 0;
		for (int i : stk) {
			sum += i;
		}
		System.out.println(sum);
	}
}
