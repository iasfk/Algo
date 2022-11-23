import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Integer, Boolean> vDFS, vBFS;
	static Map<Integer, ArrayList<Integer>> graph;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		vDFS = new HashMap<>();
		vBFS = new HashMap<>();
		graph = new HashMap<>();
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list = graph.getOrDefault(a, new ArrayList<Integer>());
			list.add(b);
			Collections.sort(list);
			graph.put(a, list);
			ArrayList<Integer> list2 = graph.getOrDefault(b, new ArrayList<Integer>());
			list2.add(a);
			Collections.sort(list2);
			graph.put(b, list2);
			vBFS.put(a, false);
			vBFS.put(b, false);
			vDFS.put(a, false);
			vDFS.put(b, false);
		}
		sb = new StringBuilder();
		dfs(v);
		System.out.println(sb.toString());
		bfs(v);
	}
	
	static void dfs(int v) {
		sb.append(v).append(" ");
		if (graph.get(v) == null)
			{
			return;}
		vDFS.put(v, true);
		ArrayList<Integer> alist = graph.get(v);
		for (int i : alist) {
			if (!vDFS.get(i))
				{
				vDFS.put(i,true);
				dfs(i);
				}
		}
	}
	
	static void bfs(int v) {
		sb = new StringBuilder();
		if (graph.get(v) == null)
			{System.out.println(v);
			return;}
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		while (!q.isEmpty()) {
			int a = q.poll();
			vBFS.put(a, true);
			sb.append(a).append(" ");
			ArrayList<Integer> list = graph.get(a);
			for (int i : list) {
				if (!vBFS.get(i)) {
					vBFS.put(i, true);
					q.add(i);}
			}
		}
		System.out.print(sb.toString());
	}
}

