import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				//절댓값에 따라 정렬
				if (Math.abs(o1) > Math.abs(o2))
					return 1;
				//같으면 작은 수부터
				else if (Math.abs(o1) == Math.abs(o2))
					return o1-o2;
				else
					return -1;
			}
			
		});
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int b = Integer.parseInt(br.readLine());
			if (b != 0) {
				pq.add(b);
			} else if (pq.isEmpty()) {
				sb.append(0).append('\n');
			} else
				sb.append(pq.poll()).append('\n');
			}
			System.out.println(sb);
		}
	
	}

