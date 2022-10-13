package bronze;

import java.util.Scanner;

public class Q2525_¿Àºì½Ã°è {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int plus = sc.nextInt();
		m += plus;
		if (m>=60) {
			h+= (m/60);
			m = m%60;
		}
		if (h>=24)
			h -=24;
		System.out.println(h+" "+m);
	}
}
