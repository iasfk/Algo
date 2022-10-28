package Gold;

import java.io.*;

public class Q1976_여행가자 {
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N];
		for (int i=0; i<N; i++) {
			parent[i] = i;
		}
		for (int i=0; i<N; i++) {
		String s = br.readLine();
		String[] str = s.split(" ");
			for (int j =0; j <= i; j++) {
				if (i != j && Integer.parseInt(str[j]) != 0) {
					union(i,j);
				}
			}
		}
		String s = br.readLine();
		String[] str = s.split(" ");
		boolean flag = true;
		for (int i=1; i<str.length; i++) {
			if (find(Integer.parseInt(str[i])-1) != find(Integer.parseInt(str[i-1])-1)){
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}//end main
	
	static int find(int a) {
		return parent[a] == a ? a : find(parent[a]);
	}
	static void union (int a , int b) {
		if (a == b)
			return;
		int k = find(a);
		int m = find(b);
		if (k != m) {
			parent[m] = k;
		}
	}
}
