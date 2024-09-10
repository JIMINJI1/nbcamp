package calculator.Lv2;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]"; // 사칙연산 기호
    private static final String NUMBER_REG = "^[0-9]+$"; // 양수 정수

    // 올바른값: 문자로 입력 받은 숫자 검증하고 정수로 리턴 , 아니면 예외 처리
    public int parseNumber(String input) throws BadInputException {
        if (!Pattern.matches(NUMBER_REG, input)) { //입력값 비교
            throw new BadInputException("정수값"); //예외처리
        }
        return Integer.parseInt(input);
    }

    // 올바른값 : 연산자 검증하고 문자로 변환 , 아니면 예외처리
    public char parseOperator(String input) throws BadInputException {
        if (!Pattern.matches(OPERATION_REG, input)) { // 입력값 비교
            throw new BadInputException("사칙연산 기호(+, -, *, /)"); // 예외처리
        }
        return input.charAt(0);
    }
}
