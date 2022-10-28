package Gold;

import java.io.*;

public class Q1717_집합의표현 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] str = s.split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		parent = new int[n+1];
		//부모노드로 본인 넣어서 초기화
		for (int i =0; i<n+1; i++) {
			parent[i] = i;
		}
		for (int i=0; i<m; i++) {
			s = br.readLine();
			str = s.split(" ");
			switch (str[0]) {
			case "0" :
				union(Integer.parseInt(str[1]), Integer.parseInt(str[2]));
				break;
			case "1" :
				if (find(Integer.parseInt(str[1])) == find(Integer.parseInt(str[2]))) 
					sb.append("YES\n");
				else
					sb.append("NO\n");
				break;
			}
		}
		System.out.println(sb);
	}
	static int find(int a) {
		if (parent[a] == a)
			return a;
		else 
			return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int k = find(a);
		int m = find(b);
		if (k != m)
			parent[m] = k;
		}
	
}
