import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");
		int result = 0;
		
		for (int i=0; i<str.length; i++) {
			if (str[i].contains("+")) {
				String[] st = str[i].split("\\+");
				int sum = 0;
				for (String a : st) {
					sum += Integer.parseInt(a);
				}
				if (i == 0) {
					result += sum;
				} else
					result -= sum;
			} else {
				if (i == 0) {
					result += Integer.parseInt(str[i]);
				} else
					result -= Integer.parseInt(str[i]);
				
			}
				
		}
		
		System.out.println(result);


	}
}