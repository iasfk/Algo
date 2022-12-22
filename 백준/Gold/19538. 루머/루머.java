import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n+1];
		int[] know = new int[n+1];

		ArrayList<Integer>[] list = new ArrayList[n+1];
		//초기화
		for (int i = 0; i<n+1; i++) {
			time[i] = -1;
			list[i] = new ArrayList<Integer>();
		}
		//list에 쌍방 담아주기
		for (int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		//몇 명이 루머를 퍼트리지
		br.readLine();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue<Node> qu = new LinkedList<>();
		while (st.hasMoreTokens()) {
			int t = Integer.parseInt(st.nextToken());
			qu.add(new Node(t,0));
			time[t] = 0;
		}

		
		while (!qu.isEmpty()) {
			Node nd = qu.poll();

			for (int i : list[nd.x]) {
				know[i]++;
				
				if (i != 0 && time[i] == -1 && know[i] >= (list[i].size())/2) {
					qu.add(new Node(i, nd.level+1));
					time[i] = nd.level+1;
//					System.out.println(nd.x+"가 "+i+" 감염 level은 "+(nd.level+1));
				}
			}
		}
		
		for (int i=1; i<n+1; i++) {
			System.out.print(time[i]+" ");
		}
	}
	
	static class Node {
		int x;
		int level;
		Node (int x, int level){
			this.x = x;
			this.level = level;
		}
	}
}