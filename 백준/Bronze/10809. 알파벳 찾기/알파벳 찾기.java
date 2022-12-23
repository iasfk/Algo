import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int[] alp = new int[26];
		for (int i=0; i<alp.length; i++) {
			alp[i] = -1;
		}
		
		for (int i=0; i<str.length(); i++) {
			if (alp[str.charAt(i)-97] == -1)
				alp[str.charAt(i)-97] = i;
		}
		
		for (int i=0; i<alp.length; i++) {
			sb.append(alp[i]+" ");
		}
		System.out.println(sb);
	}
}