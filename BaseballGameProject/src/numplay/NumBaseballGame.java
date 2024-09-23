package numplay;

import java.util.*;

public class NumBaseballGame {


        //게임 기록
        private List<int[]> gameRecords = new ArrayList<>(); //최종 게임 기록 저장하는 리스트
        private static int gameCnt =0; // 몇 번째 게임인지 저장하는 변수
        private static int tryCnt=0;

        // 스트라이크 메서드
        private int cntStrike(String input, String randomNum) {
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
        private int cntBall(String input, String randomNum) {
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

        // 게임기록 메서드
        public void getGameRecords() {
            if(gameRecords.isEmpty()) {
                System.out.println("게임 기록이 없습니다.");
            } else{
                System.out.println("<게임 기록 보기>");
                for (int i = 0; i < gameRecords.size(); i++) {
                    int gameRound = gameRecords.get(i)[0]; // i번째 게임 번호
                    int tryCnt = gameRecords.get(i)[1]; // i번째 게임 시도 횟수
                    System.out.println(gameRound + "번째 게임 : " + tryCnt + "회 시도");
                }
            }
        }

    // 새로운 게임 초기화 메서드
    public void incrementGameCount() {
        // 새로운 게임 시작 시 게임 카운트 증가
        gameCnt++;
        // 새로운 게임 시작 시 시도 횟수 초기화
        tryCnt=0;
    }


    // 게임로직 메서드
        public Object gameLogic(String input, String randomNum){

            tryCnt++;// 시도 횟수 카운트 증가

            while(true){

                // 스트라이크,볼,아웃 계산
                int strike = cntStrike(input,randomNum);
                int ball = cntBall(input,randomNum);
                int out = 3 - strike - ball; // 총 자리수 3에서 스트라이크와 볼 제외 한 값

                // 결과 반환(스트라이크,볼,아웃)
                if (strike == 3) {
                    // 게임기록 리스트에 저장
                    gameRecords.add(new int[]{gameCnt,tryCnt});
                    return tryCnt;

                } else {
                    return new int[]{strike, ball, out};
                }
            }
        }
}
