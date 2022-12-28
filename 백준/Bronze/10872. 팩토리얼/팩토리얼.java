import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 0)
			System.out.println(1);
		else {
			int sum = 1;
			while (n > 0) {
				sum *= n;
				n--;
			}
			System.out.println(sum);
		}
	}

}