package numplay;

public class Main {
    public static void main(String[] args) {
        // NumBaseballGame 객체 선언 및 생성
        NumBaseballGame numBaseballGame = new NumBaseballGame();

        // InputNumbers 선언 및 객체 생성 (게임 객체 전달)
        InputNumbers inputNumbers = new InputNumbers(numBaseballGame);

        // 사용자 옵션 입력 (게임 시작, 기록 보기, 종료)
        inputNumbers.inputNumbers();
    }
}

