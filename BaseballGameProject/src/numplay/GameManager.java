package numplay;

public class GameManager {
    private InputNumbers inputNumbers;
    private NumBaseballGame numBaseballGame;
    private RandomNumbers randomNumbers;
    private String randomNum;



    public GameManager(InputNumbers inputNumbers, NumBaseballGame numBaseballGame,RandomNumbers randomNumbers) {
        this.inputNumbers = inputNumbers;
        this.numBaseballGame = numBaseballGame;
        this.randomNumbers =  randomNumbers;
    }

    public void startGame() {
        boolean exit = false;

        while (!exit) {
            String option = inputNumbers.getUserInput();

            if (option.equals("1")) {
                // 게임 시작
                // 게임 라운드, 시도 횟수 초기화
                numBaseballGame.incrementGameCount();
                System.out.println("<게임을 시작합니다>");
                //랜덤 숫자 생성
                randomNum = randomNumbers.createRandomNumber(); // 랜덤 숫자 생성

                while (true) {
                    // 유효한 입력값을 NumBaseballGame에 전달
                    String validInput = inputNumbers.getValidInput();
                    // numBaseballGame.gameLogic 호출
                    Object result=numBaseballGame.gameLogic(validInput,randomNum);

                    if (result instanceof Integer) {
                        int tryCnt=(Integer)result;
                        // 3스트라이크 게임 끝났을 때
                        System.out.println("3 스트라이크!!");
                        System.out.println("정답입니다! 총 " + tryCnt + "번 시도했습니다.");
                        break; // 게임 종료, 내부 루프 빠져나옴

                    } else if (result instanceof int[]) {
                        // 게임 계속 진행 -> 볼, 스트라이크, 아웃 수 출력
                        int[] cnt = (int[]) result;
                        System.out.println(cnt[0] + " 스트라이크 " + cnt[1] + " 볼 " + cnt[2] + " 아웃");

                    }
                }

            } else if (option.equals("2")) {
                // numBaseballGame.getGameRecords 메서드로 기록 가져오기
                numBaseballGame.getGameRecords();

            } else if (option.equals("3")) {
                System.out.println("게임을 종료합니다.");
                exit = true; // 루프 종료

            } else {
                System.out.println("올바른 옵션을 선택하세요.");
            }
        }
    }


}

