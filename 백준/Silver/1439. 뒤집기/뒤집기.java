import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		if (!str.contains("0")) {
			System.out.println(0);
			return;
		}
		StringTokenizer st = new StringTokenizer(str, "1");
		StringTokenizer st2 = new StringTokenizer(str, "0");
		System.out.println(Math.min(st.countTokens(), st2.countTokens()));
	}
}