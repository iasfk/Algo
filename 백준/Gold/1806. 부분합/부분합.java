import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		// 투포인터를 사용할 거임!
		// start는 0부터 end도 0부터 시작해서 sum이 s보다 커질 때까지 ++
		// 이후로 sum이 s보다 크면 start를 키워서 줄이고
		// 작아지면 end를 키워용
		// 그래서 끝내면 끝
		int sum = 0;
		while (true) {
			if (sum >= s) {
				sum -= arr[start++];
				min = Math.min(min, end - start + 1);
			}
			else if (end == n)
				break;
			 else
				sum += arr[end++];
		}
		System.out.println((min == Integer.MAX_VALUE) ? 0 : min);
	}
}
