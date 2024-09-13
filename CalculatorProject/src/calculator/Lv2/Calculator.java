package calculator.Lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 컬렉션타입 필드
    private List<Integer> results = new ArrayList<Integer>();

    //계산 결과값 가져오는 Getter 메소드
    public List<Integer> getResults(){
        return results;
    }
    //계산 수정하는 Setter 메소드
    public void setResults(List<Integer> newResults) {
        this.results = newResults;
    }

    //계산 결과 리스트 추가 메소드
    public void addResult(int result){
        results.add(result);
    }

    // 계산 결과값 삭제 메소드 (첫 번째 결과 삭제)
    public void removeResult(){
        results.remove(0);
    }

    /* 사칙연산 메소드 */
    // 덧셈 메소드
    private int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    // 뺄셈 메소드
    private int subtract(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    // 곱셈 메소드
    private int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    // 나눗셈 메소드
    private int divide(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    // 계산 수행 메소드
    // try~~ catch로 예외처리하기
    public int calculate(int firstNumber,char operator, int secondNumber) throws Exception {
        int resultValue=0;
        // 입력받은 연산 기호에 따라 처리
        switch (operator){
            case '+':
                resultValue = add(firstNumber, secondNumber);
                break;
            case '-':
                resultValue = subtract(firstNumber, secondNumber);
                break;
            case '*':
                resultValue = multiply(firstNumber, secondNumber);
                break;
            case '/':
                if (secondNumber == 0) {
                    // 두번째 숫자 0 예외 처리
                    throw new Exception("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. 다시 입력 하세요.");
                } else {
                    resultValue = divide(firstNumber, secondNumber);
                }
                break;
            // 기본값 
            default:
                throw new Exception("잘못된 연산자입니다. (+, -, *, / 중 하나를 사용하세요.)") ;

        }
        // 계산 결과 리스트에 추가
        addResult(resultValue);
        // 계산 결과 반환
        return resultValue;
    }

}
