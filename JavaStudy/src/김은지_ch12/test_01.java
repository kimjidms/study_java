package 김은지_ch12;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;


public class test_01 {
    public static void main(String[] args) {

        char[] alphabets = new char[27];
        char ch = 'A';

        for(int i=1; i<alphabets.length; i++, ch++) {
            alphabets[i] = ch;
        }

        HashMap<Integer, Character> map  = new HashMap<>();

        for (int i=1; i<alphabets.length; i++) {
            Integer key = i;
            char value = alphabets[i];
            map.put(key,value);
        }

        // 학생번호 : 학생이름
        System.out.println("\nStudent List : " + map);
        System.out.println("\n=====================================================\n");

        HashMap<Integer, Integer> korean  = new HashMap<>();
        HashMap<Integer, Integer> english  = new HashMap<>();
        HashMap<Integer, Integer> math  = new HashMap<>();

        for(int i=1; i<map.size(); i++){
            int koreanTest = ThreadLocalRandom.current().nextInt(101);
            int englishTest = ThreadLocalRandom.current().nextInt(101);
            int mathTest = ThreadLocalRandom.current().nextInt(101);

            korean.put(i,koreanTest);
            english.put(i,englishTest);
            math.put(i,mathTest);
        }

        // 순서대로 학생번호 : 한국어, 영어, 수학 점수
        System.out.println("Student Korean Score : " + korean);
        System.out.println("Student English Score : " + english);
        System.out.println("Student Math Score : " + math);
        System.out.println("\n=====================================================\n");

        /**
         * 다음 값을 출력한다.
         */

        //학생별 총점
        HashMap<Integer, Integer> score  = new HashMap<>();
        int sum = 0;

        for(int i=1; i<map.size(); i++){
            sum += korean.get(i);
            sum += english.get(i);
            sum += math.get(i);

            score.put(i,sum);
            sum = 0;
        }
        System.out.println("Student Score : " + score);

        //최고점을 받은 학생이름
        int max = 0;
        int num = 0;
        for(int i=1; i<score.size(); i++) {
            if(max <= score.get(i)) {
                max = score.get(i);
                num = i;
            }
        }
        System.out.println("Best Student : " + map.get(num));

        //과목별 전체 학생의 평균
        float koreanAvg;
        float englishAvg;
        float mateAvg;

        int koreanSum = 0;
        int englishSum = 0;
        int mateSum = 0;

        for(int i=1; i<score.size(); i++) {
            koreanSum += korean.get(i);
            englishSum += english.get(i);
            mateSum += math.get(i);
        }
        koreanAvg = koreanSum / map.size();
        englishAvg = englishSum / map.size();
        mateAvg = mateSum / map.size();

        System.out.println("Average score by subject ==>  Korean : "+koreanAvg+" / English : "+englishAvg+" / Mate : "+mateAvg);

        //과목별 최고점를 받은 학생 이름
        koreanSum = 0;
        englishSum = 0;
        mateSum = 0;

        int koreanNum = 0;
        int englishNum = 0;
        int mateNum = 0;

        for(int i=1; i<map.size(); i++) {
            if(koreanSum <= korean.get(i)) {
                koreanSum = korean.get(i);
                koreanNum  = i;
            }
            if (englishSum <= english.get(i)) {
                englishSum = english.get(i);
                englishNum  = i;
            }
            if (mateSum <= math.get(i)) {
                mateSum = math.get(i);
                mateNum  = i;
            }
        }
        System.out.println("Best Korean Score : " + map.get(koreanNum));
        System.out.println("Best English Score : " + map.get(englishNum));
        System.out.println("Best Math Score : " + map.get(mateNum));


    }
}