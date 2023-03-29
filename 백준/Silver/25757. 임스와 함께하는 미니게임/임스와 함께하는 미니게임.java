import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		HashSet<String> people = new HashSet<>();
		
		for (int i=0; i<n; i++) {
			people.add(br.readLine());
		}
		
		int num = people.size();
		
		if (game.equals("Y")) System.out.println(num);
		else if (game.equals("F")) System.out.println(num/2);
		else System.out.println(num/3);
		
		
	}
}