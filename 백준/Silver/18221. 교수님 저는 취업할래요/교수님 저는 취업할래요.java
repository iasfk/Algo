import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[] prof = new int[2];
		int[] sk = new int[2];
		//성규랑 교수님 받아오기 && 좌석 받아오기
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 5) {
					prof[0] = i;
					prof[1] = j;
				} else if (map[i][j] == 2) {
					sk[0] = i;
					sk[1] = j;
				}
			}
		}
		
		//1.거리가 5 이상이어야 함
		double distance = Math.sqrt(Math.pow(prof[0]-sk[0], 2) + Math.pow(prof[1] -sk[1],2));
		if (distance < 5)
		{
			System.out.println(0);
			return;
		}
		//2. 직사각형 안에 3명 이상 있어야 함
		int minx = Math.min(prof[0], sk[0]);
		int maxx = Math.max(prof[0], sk[0]);
		int miny = Math.min(prof[1], sk[1]);
		int maxy = Math.max(prof[1], sk[1]);
		
		int sum = 0;
		
		for (int i = minx; i<=maxx; i++) {
			for (int j = miny; j <=maxy; j++) {
				if (map[i][j] == 1) 
					sum++;
			}
		}
		
		if (sum >= 3) {
			System.out.println(1);
		} else
			System.out.println(0);
	}
}