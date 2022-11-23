import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Long n = Long.parseLong(st.nextToken());
		Long m = Long.parseLong(st.nextToken());
		String str = br.readLine();
		long[] trees = Arrays.stream(str.split(" ")).mapToLong(Long::parseLong).toArray();
		Arrays.sort(trees);
		Long start = (long) 0;
		Long end = trees[trees.length-1];
		while (start<=end) {
			Long mid = (start+end)/2;
			Long sum =(long) 0;
			for (int i=0; i<trees.length; i++) {
				if (trees[i] >=mid)
					sum+=trees[i]-mid;
			}
			if (sum>=m) {
				start=mid+1;
			}else end=mid-1;
		}
		System.out.println(end);
	}
}
