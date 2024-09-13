package calculator.Lv1;

import java.util.Scanner;

/* Lv1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
    - 양의 정수(0 포함)를 입력받기
    - 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
    - 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
    - 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
*/

public class App {
    public static void main(String[] args) {
        // 콘솔 입력값 받기 Scanner 사용
        Scanner sc = new Scanner(System.in);

        // 계산기 반복 While문
        while (true) {
            // 변수
            int firstNum = 0; //첫 번째 수
            int secondNum = 0; //두 번째 수
            char operator; // 사칙연산 기호
            int result = 0; // 결과값

            // 숫자 아닌 입력값 넣었을 경우 예외 처리
            try {
                /* 입력값 받기 */
                System.out.println("---------- 계산기 ----------");

                System.out.println("1. 첫 번째 숫자를 입력하세요.");
                firstNum = sc.nextInt();

                System.out.println("2. 두 번째 숫자를 입력하세요.");
                secondNum = sc.nextInt();

                System.out.println("3. 사칙연산 기호를 입력하세요.(+ , - , * , / )");
                operator = sc.next().charAt(0);

                /* 입력값 처리 */
                switch (operator) {
                    // 덧셈
                    case '+':
                        result = firstNum + secondNum;
                        System.out.println("연산결과: "+ firstNum + operator + secondNum + "=" + result);
                        break;
                    //뺄셈
                    case '-':
                        result = firstNum - secondNum;
                        System.out.println("연산결과: "+ firstNum + operator + secondNum + "=" + result);
                        break;
                    //곱셈
                    case '*':
                        result = firstNum * secondNum;
                        System.out.println("연산결과: "+ firstNum + operator + secondNum + "=" + result);
                        break;
                    // 나눗셈
                    case '/':
                        // 나눗셈 예외처리
                        if (secondNum == 0) {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. 다시 입력 하세요.");
                        } else {
                            result = firstNum / secondNum;
                            System.out.println("연산결과: "+ firstNum + operator + secondNum + "=" + result);
                        }
                        break;
                    //기본값
                    default:
                        System.out.println("잘못된 입력입니다. 사칙연산 기호를 입력하세요.(+ , - , * , / )");
                        continue;
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요");
                sc.nextLine(); //버퍼정리
                continue;
            }

            // 계산 계속 진행 여부 처리
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료 , exit 이외에 아무거나 입력 시 새로운 계산 진행) ");
            sc.nextLine(); // 개행 문자 처리
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
