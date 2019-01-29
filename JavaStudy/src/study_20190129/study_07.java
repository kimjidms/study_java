package study_20190129;

import java.util.Arrays;
import java.util.List;

class study_07 {
	public static void main(String[] args) {
		
		int[] a = { 3, 1, 2 };
		
		// a를 복사해서 { 3, 1, 2, 0, 0 } 인 배열 생성
		int[] b = Arrays.copyOf(a, 5);
		
		Arrays.fill(b, 3, 5, 100); // 3 ≤ index < 5 를 100으로 채움
		Arrays.fill(b, 10); // b의 모든 값을 10으로 채움
		Arrays.sort(a); // 오름차순으로 정렬
		
		String str = Arrays.toString(a); // "[1, 2, 3]" 문자열로 변경
		boolean isSame = Arrays.equals(a, b); // 두개의 배열이 같은지 비교
		List<String> list = Arrays.asList("abc", "def"); // 리스트로 변환
		
		System.out.println(str);
		System.out.println(isSame);
		System.out.println(list);
	 } 
}