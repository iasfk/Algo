import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i=1; i<=30; i++)
			list.add(i);
		
		for (int i=0; i<28; i++) {
			list.remove(Integer.valueOf(sc.nextInt()));
		}
		for (int i : list) {
			System.out.println(i);
		}
	}
}
