import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			// 입력값이 end일 경우 종료
			if (str.equals("end")) {
				System.out.println(sb.toString());
				break;
			}
			
			sb.append("<").append(str+"> is ");
			// flag true : acceptable false : not acceptable
			boolean flag = true;
			
			
			if (!chkOne(str)) flag = false;
			if (!chkTwo(str)) flag = false;
			if (!chkThree(str)) flag = false;
			
			if (!flag) {
				sb.append("not ");
			}
			sb.append("acceptable.\n");
		}
		
	}
	
	//모음이 하나라도 있을 경우 true
	public static boolean chkOne(String s) {
		String[] vowel = {"a","e","i","o","u"};
		for (int i=0; i<vowel.length; i++) {
			if (s.contains(vowel[i])) {
				return true;
			}
		}
		return false;
	}
	
	// 3개 이상 같은 글자가 올 경우 false
	public static boolean chkTwo(String s) {
		if (s.length() == 1)
			return true;
		s = s.replaceAll("[^aeoui]", "1").replaceAll("[aeoui]", "0");
		if (s.contains("000") || s.contains("111"))
			return false;
		return true;
	}
	
	// 같은 글자가 연속이면 false (ee와 oo는 허용)
	public static boolean chkThree(String s) {
		if (s.length() == 1)
			return true;
		for (int i=1; i<s.length(); i++) {
			// 이전과 동일할 경우
			if (s.charAt(i) == s.charAt(i-1)) {
				if (!(s.charAt(i) == 'e' || s.charAt(i) == 'o')) {
					return false;
				}
			}
		}
		return true;
	}
}

//chkOne에서 for문 크기를 s의 length만큼 돌림
