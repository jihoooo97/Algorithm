class StringUtil {
	
	public static int compare(char[] s1, char[] s2){

		// 1. 문자열이 다른부분이 존재하는 경우 man girl
		// 짧은 문자열 길이 추출해서 비교
		int minLen = Math.min(s1.length, s2.length);
		
		for(int i = 0; i < minLen; i += 1) {
			// s1이 크면 양수 s2가 크면 음수 반환
			if(s1[i] != s2[i]) {
				return (int)s1[i] - s2[i];
			}
		}
		// 2. 다른부분 존재 x
		// 2-1. 길이가 다른경우 sex sexking
		// 2-2. 길이가 같은경우(문자열 같음)
		if(s1.length != s2.length) {
			return s1.length - s2.length;
			// 음수 s1이 빠름
			// 양수 s2가 빠름
			// 0이 나오면 같음
		}
		return 0;
	}
	
	public static boolean equals(char[] s1, char[] s2){
		/* 두 문자열 s1, s2가 일치하면 true
		 일치하지 않으면 false를 반환하는 함수
		*/
		if(s1.length != s2.length) {
			return false;
		}
		for(int i = 0; i < s1.length; i += 1) {
			if(s1[i] != s2[i])
				return false;
		}
		return true;
	}
}

public class Main {

	public static void main(String[] args) {
		char[] s1 = "algorithm".toCharArray();
		char[] s2 = "allergy".toCharArray();
		
		System.out.printf("compare() Result : %d\n", StringUtil.compare(s1,s2) );
		System.out.printf("equals() Result : %b\n", StringUtil.equals(s1,s2) );
	}
}