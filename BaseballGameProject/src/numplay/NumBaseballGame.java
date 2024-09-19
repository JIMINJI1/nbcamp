package numplay;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumBaseballGame {

        // 랜덤숫자 객체 생성
        private RandomNumbers randomNumbers = new RandomNumbers();
        // 랜덤숫자  생성 후 randomNum 담음
        private String randomNum=randomNumbers.createRandomNumber();
        //사용자입력값 객체 생성
        private InputNumbers inputNumbers = new InputNumbers();


        // 스트라이크 메서드
        private int cntStrike(String input) {
            int cnt = 0;
            // 입력값이랑 정답 각 자리 숫자 비교
            for (int i = 0; i < 3; i++) {
                // 같은 자리에 같은 숫자 있으면 스트라이크 수 증가
                // charAt(i) : 문자열에서 i번째 문자 가져옴
                if (input.charAt(i) == randomNum.charAt(i)) {
                    cnt++;
                }
            }
            return cnt; // 총 스크라이크 수 반환
        }


        // 볼 메서드
        private int cntBall(String input) {
            int cnt = 0;
            // 입력값 정답 각 자리 숫자 비교
            for (int i = 0; i < 3; i++) {
                char inputChar = input.charAt(i);
                // 같은 자리에서 일치하지 않으면서 정답에 포함된 경우 볼 수 증가
                // 비교대상.indexOf(찾고자하는문자) : 있으면 인덱스 반환, 없으면 -1 반환
                if (inputChar != randomNum.charAt(i) && randomNum.indexOf(inputChar) != -1) {
                    cnt++;
                }
            }
            return cnt; // 총 볼 수 반환
        }



        // 게임로직 메서드
        public void gameLogic(){
            while(true){
            // 사용자 입력값
            String input = inputNumbers.getValidInput();
            // 스트라이크,볼,아웃 계산
            int strike = cntStrike(input);
            int ball = cntBall(input);
            int out = 3 - strike - ball; // 총 자리수 3에서 스트라이크와 볼 제외 한 값

            // 결과 출력
            if (strike == 3) {
                System.out.println("3 스트라이크!!");
                break; // 반복문 종료
            } else {
                System.out.println(strike + " 스트라이크 " + ball + " 볼 " + out + " 아웃");
                    }

            }

        }
}
