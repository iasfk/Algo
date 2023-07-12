import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		ArrayList<Nation> list = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			Nation nation = new Nation(index, gold, silver, bronze);
			list.add(nation);
		}
		//정렬
        Collections.sort(list);
       

        int rate = 1;
        int cnt = 1;

        if (list.get(0).index == T) {
            System.out.println(1);
            return;
        }
        
        for (int i = 1; i < N; i++) {

            Nation prev = list.get(i-1);
            Nation cur = list.get(i);

            //금메달 갯수 다르거나, 은메달 개수 다르거나, 동메달 개수 다르면
            if ((prev.gold != cur.gold) || (prev.silver != cur.silver) || (prev.bronze != cur.bronze)) {
            	//등수는 여태 모아온 cnt 더해주기
                rate += cnt;
                //중복등수 초기화
                cnt = 1;
            }
            else
                cnt++;

            if (cur.index == T) {
                System.out.println(rate);
                break;
            }
        }
	}
	static class Nation implements Comparable<Nation> {
		int index, gold, silver, bronze;

        public Nation (int index, int gold, int silver, int bronze) {
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                }
                else return o.silver - this.silver;
            }
            else
                return o.gold - this.gold;
        }
	}
	
	
}
