import java.util.*;
import java.io.*;

public class Main {
	static int r, c, m, total;
//	static HashMap<int[], Shark> map;
	static Queue<Shark> target;
	static Shark[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new Shark[r+1][c+1];
		// 이걸 매 try마다 초기화시키면서 겹치는 경우 shark size 비교해서 큰 것만 거기 있도록 하면 되지 않을까요?
		target = new LinkedList<>();
		Queue<Shark> q = new LinkedList<>();
		
		// 상어의 수 m개 입력받기
		// 상어 Queue에 넣기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			Shark a = new Shark(x, y, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			map[x][y] = a;
			q.add(a);
		}
		for (int i=1; i<=c; i++) {
			getShark(map, i);
			move(addShark(map));
		}

		System.out.println(total);
	}

	static class Shark {
		int x;
		int y;
		int speed;
		int d;
		int size;

		Shark(int x, int y, int speed, int d, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.d = d;
			this.size = size;
		}
	}

	// 상어가 움직이는 거야
	// 상어 모음 queue 입력 받고 get을 입력 받아서 움직이고 난 뒤 x == get이면 이제 total += shark.size 올려주기
	// d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
	static void move(Queue<Shark> q) {
		while(!q.isEmpty()) {
			Shark a = q.poll();
			int speed = a.speed;
			int d = a.d;
			int x = a.x;
			int y = a.y;
			while (speed != 0) {
				if (d == 1) {
					if (speed >= (x - 1)) {
						speed -= x- 1;
						x = 1;
						d = 2;
					} else {
						x -= speed;
						speed = 0;
					}

				} else if (d == 2) {
					if (speed >= r - x) {
						speed -= r - x;
						x = r;
						d = 1;
					} else {
						x += speed;
						speed = 0;
					}
				} else if (d == 3) {
					if (speed >= c - y) {
						speed -= c - y;
						y = c;
						d = 4;
					} else {
						y += speed;
						speed = 0;
					}
				} else if (d == 4) {
					if (speed >= (y - 1)) {
						speed -= y - 1;
						y = 1;
						d = 3;
					} else {
						y -= speed;
						speed = 0;
					}
				}
			} // end of while
			
			//shark 이동 끝! map에 넣어주고 만약에 겹치는 거 잇으면 size 비교해서 큰 거만 넣어주기
			Shark b = new Shark(x, y, a.speed, d, a.size);
			
			if (map[x][y] != null) {
				Shark pre = map[x][y];
				if (pre.size < b.size) {
					map[x][y] = b;
				}
			} else
				map[x][y] = b;
		}
	}
	//사냥꾼이 상어 잡는 거
	static void getShark(Shark[][] map, int pos) {
		for (int i=1; i <= r; i++) {
			if (map[i][pos] != null) {
				total += map[i][pos].size;
				map[i][pos] = null;
				return;
			}
		}
	}
	
	static Queue<Shark> addShark(Shark[][] map){
		Queue<Shark> q = new LinkedList<>();
		for (int i=1; i<=r; i++) {
			for (int j=1; j<=c; j++) {
				if (map[i][j] != null) {
					q.add(map[i][j]);
					map[i][j] = null;
					}
			}
		}
		
		return q;
	}

	
}
