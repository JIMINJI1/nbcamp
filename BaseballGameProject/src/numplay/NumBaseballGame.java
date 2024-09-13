package numplay;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumBaseballGame {

        // 중복 숫자 확인 메서드
        private boolean hasDuplicateDigits(String numberStr) {
            // 중복 숫자 확인하기 위해 Set 선언 및 생성
            Set<Character> digits = new HashSet<>();

            //입력값 문자열 -> 문자로 변환
            for (char c : numberStr.toCharArray()) {
                // digits에 문자 추가 안되면 중복이라서 안되는거임
                if (!digits.add(c)) {
                    return true; // 중복된 숫자가 발견되면 T 반환
                }
            }
            // 중복된 숫자 없으면 F 반환
            return false;
        }

        // 스트라이크 메서드
        private int cntStrike(String input) {
            int cnt = 0;
            // 입력값이랑 정답 각 자리 숫자 비교
            for (int i = 0; i < 3; i++) {
                // 같은 자리에 같은 숫자 있으면 스트라이크 수 증가
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
                if (inputChar != randomNum.charAt(i) && randomNum.indexOf(inputChar) != -1) {
                    cnt++;
                }
            }
            return cnt; // 총 볼 수 반환
        }


        // 랜덤숫자 객체 생성
        private RandomNumbers randomNumbers = new RandomNumbers();
        // 랜덤숫자  생성 후 randomNum 담음
        private String randomNum=randomNumbers.createRandomNumber();

        // 사용자 값 입력 받고 유효성 검사
        public void inputNumber(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("게임을 시작합니다. 3자리 숫자를 입력해 주세요. 동일한 숫자 사용 불가능");

//            System.out.println("=========랜덤숫자확인용 출력"+randomNum+"=========");
            while(true){
                // Scanner로 입력값 받음
                String input =scanner.nextLine();

                //입력값 3자리 숫자인지 확인 ->  "\\d": 숫자인지   "\\d{3}" : 세자리 숫자인지
                if(!input.matches("\\d{3}")){
                    System.out.println("3자리 숫자를 입력하세요.");
                    continue; //유효하지 않으면 반복문 처음으로
                }

                // 입력값 숫자 중복 확인
                if(hasDuplicateDigits(input)){
                    System.out.println("동일한 숫자 사용 불가능 합니다.");
                    continue; //유요하지 않으면 반복문 처음으로
                }

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

