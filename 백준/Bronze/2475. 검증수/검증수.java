import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		System.out.println((int) (Math.pow(a, 2)+Math.pow(b, 2)+Math.pow(c, 2)+Math.pow(d, 2)+Math.pow(e, 2))%10);
	}
}
