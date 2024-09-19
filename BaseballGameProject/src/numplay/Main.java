package numplay;

public class Main {
    public static void main(String[] args) {
        // InputNumbers 객체 생성
        InputNumbers inputNumbers = new InputNumbers();
        // 사용자 옵션 입력
        inputNumbers.inputNumbers();

        //게임시작
        NumBaseballGame numBaseballGame = new NumBaseballGame();
        numBaseballGame.gameLogic();
    }
}
