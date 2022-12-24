import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 1) {
			System.out.println(0);
			return;
			}
		PriorityQueue<ppl> pq = new PriorityQueue<>();
		int target = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			pq.add(new ppl(i, x));
		}

		while (true) {
			ppl pp = pq.poll();
			if (pp.votes >= target) {
				pq.add(new ppl(pp.num, pp.votes - 1));
				target++;
				cnt++;
			} else {
				System.out.println(cnt);
				return;
			}

		}
	}

	static class ppl implements Comparable<ppl> {
		int num;
		int votes;

		ppl(int num, int votes) {
			this.num = num;
			this.votes = votes;
		}

		@Override
		public int compareTo(ppl o) {
			// TODO Auto-generated method stub
			return o.votes - this.votes;
		}

	}
}