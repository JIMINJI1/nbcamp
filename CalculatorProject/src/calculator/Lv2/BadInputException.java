package calculator.Lv2;

public class BadInputException extends Exception {
    public BadInputException(String expectedType) {
        super("잘못된 입력입니다. " + expectedType + "을(를) 입력하세요.");
    }
}

