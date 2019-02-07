package 김은지_ch13;

import java.util.concurrent.ThreadLocalRandom;

public final class NameGenerator {
	 private static final String[] 성 = {
	 "김","이","박","최","정","강","조"
	 ,"윤","장","임","한","오","서","신"
	 ,"권","황","안","송","전","홍" };

	 private static final String[] 이름 = {
	 "가람","가온","가을","겨운","겨레"
	 ,"나라","나래","나리","나무","나은"
	 ,"다래","다솔","다솜","다온","다운"
	 ,"마루","마음","미리내","믿음"
	 ,"바다","보름","보라","보람","보미","봄"
	 ,"산들","시원","사랑","새론","새롬","슬"
	 ,"아라","아람","아름","아리","은비"
	 ,"잔디","초롱","푸름","하나","한결",};
	 
	 
	 public static String generate() {
		 ThreadLocalRandom random = ThreadLocalRandom.current();
		 return 성[random.nextInt(성.length)] + 이름[random.nextInt(이름.length)];
	 }
}