package calculator.Lv2;

import java.util.List;
import java.util.Scanner;

/* Lv2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
    1.사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
        -사칙연산을 수행한 후, 결과값을 반환하는 메서드 구현
        - 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
        -  1) 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산 기능을 수행한 후 2) 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
    2.  App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
        - 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현 (Getter 메서드)
        - 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현 (Setter 메서드)
    3. Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정
*/

public class App {
    public static void main(String[] args) {
        // Scanner 객체 생성 (콘솔 입력값 받기)
        Scanner sc = new Scanner(System.in);
        // Calculator 객체 생성 (계산)
        Calculator calculator = new Calculator();
        // Paser 객체 생성 (입력값 유효성 검사)
        Parser parser = new Parser();

        // 계산기 반복 while문
        while (true) {
            // 변수
            int firstNum; //첫 번째 수
            int secondNum; //두 번째 수
            char operator; // 사칙연산 기호

            // try~~ catch 예외처리 : 잘못된 값 입력 하면 에러 메세지로 알려줌
            try {
            // 입력값 받기
            System.out.println("---------- 계산기 ----------");

            System.out.println("1. 첫 번째 숫자를 입력하세요.");
            String firstInput = sc.nextLine();
            //입렵값 문자로 받아서 검사한 뒤 숫자로 반환, 잘못된 입력값이 때 오류 메시지 반환
            firstNum = parser.parseNumber(firstInput);

            System.out.println("2. 사칙연산 기호를 입력하세요.(+ , - , * , / )");
            String operatorInput = sc.nextLine();
            // 입력값 문자로 받아 검사한 뒤 반환
            operator = parser.parseOperator(operatorInput);

            System.out.println("3. 두 번째 숫자를 입력하세요.");
            String secondInput = sc.nextLine();
            //입렵값 문자로 받아서 검사한 뒤 숫자로 반환, 잘못된 입력값이 때 오류 메시지 반환
            secondNum = parser.parseNumber(secondInput);

            // 계산 수행
            calculator.calculate(firstNum, operator, secondNum);

            // 계산 결과 출력
            List<Integer> results = calculator.getResults();
            System.out.println("계산 결과값 " + firstNum + operator + secondNum + "=" +  results.get(0));

            // 계산 결과 값 삭제
            calculator.removeResult();


            } catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            // 계산 계속 진행 여부 처리
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, exit 이외에 아무거나 입력 시 새로운 계산 진행) ");
            String exitContinue = sc.nextLine(); // 사용자 입력 받기


            // exit 입력시 종료
            if (exitContinue.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            //exit가 아니면 자동으로 계산 반복됨
        }

        //Scanner 닫기
        sc.close();

    }
}
