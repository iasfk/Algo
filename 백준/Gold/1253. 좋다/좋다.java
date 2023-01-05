import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int srt = 0;
			int end = arr.length - 1;
			while (true) {
				if (i == srt)
					srt++;
				else if (i == end)
					end--;
				if (srt >= end)
					break;

				if (arr[srt] + arr[end] > arr[i])
					end--;
				else if (arr[srt] + arr[end] == arr[i]) {
					answer++;
					break;
				} else
					srt++;
			}
		}
		System.out.println(answer);
	}
}