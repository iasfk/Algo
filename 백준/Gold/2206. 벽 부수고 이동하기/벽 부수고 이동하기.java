import java.util.*;
import java.io.*;

public class Main {
	static boolean[][][] visited;
	static char[][] map;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		Node nd = new Node(0, 0, 0, false);
		visited[nd.x][nd.y][0] = true;
		q.add(nd);
		while (!q.isEmpty()) {

			Node a = q.poll();

//			System.out.println("x " + a.x + " y " + a.y);
			if (a.x == n - 1 && a.y == m - 1)
				return a.level + 1;

			for (int i = 0; i < 4; i++) {
				
				int nr = dx[i] + a.x;
				int nc = dy[i] + a.y;

				// map 밖으로 나간 경우 제외
				if (!(nr >= 0 && nc >= 0 && nr < n && nc < m))
					continue;

				// 방문한 경우 제외
				if (visited[nr][nc][a.chance ? 1 : 0])
					continue;
				
//				System.out.println("nr "+nr+" nc "+nc);
				// 벽이 아닐 경우
				if (map[nr][nc] == '0') {
					//근데 부수지도 않았음
					if (!a.chance) {
						// 방문 처리 해주고
						visited[nr][nc][0] = true;
						// 넣어주기
						q.add(new Node(nr, nc, a.level + 1, a.chance));
					} else {
						//부쉈으면 마찬가지로 방문처리 + 넣어주기
						visited[nr][nc][1] = true;
						q.add(new Node(nr, nc, a.level + 1, a.chance));
					}
				}
				//벽이면
				else if (map[nr][nc] == '1') {
					//안부쉈다면
					if (!a.chance) {
						//방문처리해주고넣어주고 chance 소모!
						visited[nr][nc][1] = true;
						q.add(new Node(nr, nc, a.level + 1, !a.chance));
					}
				}
			}
		}
		
		return -1;
	}

	static class Node {
		int x;
		int y;
		int level;
		boolean chance;

		Node(int x, int y, int level, boolean check) {
			this.x = x;
			this.y = y;
			this.level = level;
			this.chance = check;
		}
	}
}
