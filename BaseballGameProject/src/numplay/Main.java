package numplay;

public class Main {
    public static void main(String[] args) {
        // InputNumbers 선언 및 객체 생성
        InputNumbers inputNumbers = new InputNumbers();
        // NumBaseballGame 객체 선언 및 생성
        NumBaseballGame numBaseballGame = new NumBaseballGame();
        // RandomNumbers 객체 선언 및 생성
        RandomNumbers randomNumbers = new RandomNumbers(); // RandomNumbers 객체 생성

        // GameManager 객체 선언 및 생성
        GameManager gameManager = new GameManager(inputNumbers,numBaseballGame,randomNumbers);

        // 게임 시작, 기록 보기, 종료
        gameManager.startGame();
    }
}

