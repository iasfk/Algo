import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//컴ㅍ터 수
		int n = Integer.parseInt(br.readLine());
		//연결수
		int m = Integer.parseInt(br.readLine());
		
		boolean[] warm = new boolean[n+1];
		int count = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		warm[1] = true;
		while (!q.isEmpty()) {
			int a = q.poll();
			ArrayList<Integer> alist = list.get(a);
			for (int b : alist) {
				if (!warm[b]) {
					q.add(b);
					warm[b] = true;
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
