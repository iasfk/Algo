import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		map = new char[2][m];

		int cnt = 0;
		for (int i = 0; i < 2; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				char a = str.charAt(j);
				if (a == '#')
					cnt++;
				map[i][j] = str.charAt(j);
			}
		} // map
		int z = bfs(m);
		System.out.println(2 * m - cnt - z);
	}

	static int bfs(int m) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[2][m];
		for (int i = 0; i < 2; i++) {
			if (map[i][0] == '#')
				continue;
			visited[i][0] = true;
			q.add(new Node(i, 0, 1));
		}
		while (!q.isEmpty()) {
			Node nr = q.poll();
			if (nr.y == m - 1)
				return nr.level;
			for (int j = 0; j < 4; j++) {
				int dr = dx[j] + nr.x;
				int dc = dy[j] + nr.y;
				if (!(dr < 2 && dc < m && dr >= 0 && dc >= 0 && !visited[dr][dc] && map[dr][dc] == '.'))
					continue;
				visited[dr][dc] = true;
				q.add(new Node(dr, dc, nr.level + 1));
			}
		}
		return -1;
	}

	static class Node {
		int x;
		int y;
		int level;

		Node(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}
}
