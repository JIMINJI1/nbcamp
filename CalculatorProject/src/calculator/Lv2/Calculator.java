package calculator.Lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 각 연산을 수행할 연산 클래스 인스턴스를 생성
    private final AddOperation addOperation = new AddOperation();
    private final SubstractOperation substractOperation = new SubstractOperation();
    private final MultiplyOperation multiplyOperation = new MultiplyOperation();
    private final DivideOperation divideOperation = new DivideOperation();

    // int result; => 컬렉션타입 필드
    private List<Integer> results = new ArrayList<Integer>();

    //계산 결과 리스트 추가 메소드
    public void addResult(int result){
        results.add(result);
    }

    //계산 결과값 가져오는 Getter 메소드
    public List<Integer> getResults(){
        return results;
    }

    // 계산 결과값 삭제 메소드 (첫 번째 결과 삭제)
    public void removeResult(){
        results.remove(0);
    }


    //계산 수정하는 Setter 메소드
    public List<Integer> setResults(){
        return results;
    }

    // 계산 수행 메소드
    // try~~ catch로 예외처리하기
    public int calculate(int firstNumber,char operator, int secondNumber) throws Exception {
        // 계산 결과 저장할 로컬 변수
        int resultValue;

        switch (operator){
            case '+':
                resultValue = addOperation.operate(firstNumber,secondNumber);
                break;
            case '-':
                resultValue =substractOperation.operate(firstNumber,secondNumber);
                break;
            case '*':
                resultValue = multiplyOperation.operate(firstNumber,secondNumber);
                break;
            case '/':
                if (secondNumber == 0) {
                    throw new Exception("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. 다시 입력 하세요.");
                } else {
                    resultValue = divideOperation.operate(firstNumber,secondNumber);
                }
                break;

            default:
                throw new Exception("잘못된 연산자입니다. (+, -, *, / 중 하나를 사용하세요.)") ;

        }

        // 계산 결과 리스트에 추가
        addResult(resultValue);
        // 계산 결과 반환
        return resultValue;
    }



}
