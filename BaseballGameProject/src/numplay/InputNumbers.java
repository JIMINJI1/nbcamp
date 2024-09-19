package numplay;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputNumbers {
    // 중복 숫자 확인 메서드
    private boolean hasDuplicateDigits(String numberStr) {
        // 중복 숫자 확인하기 위해 Set 선언 및 생성
        Set<Character> digits = new HashSet<>();

        //입력값 문자열 -> 문자로 변환
        for (char c : numberStr.toCharArray()) {
            // digits에 문자 추가 안되면 중복이라서 안되는거임
            if (!digits.add(c)) {
                return true; // 중복된 숫자가 발견되면 T 반환
            }
        }
        // 중복된 숫자 없으면 F 반환
        return false;
    }

    // 사용자 값 입력 받고 유효성 검사
    public String inputNumbers() {
        //Scanner 선언 및 생성
        Scanner scanner = new Scanner(System.in);
        // input 선언 및 초기화
        String input = null;
        System.out.println("게임을 시작합니다. 3자리 숫자를 입력해 주세요. 동일한 숫자 사용 불가능");

        while(true){
            // Scanner로 입력값 받음
            input =scanner.nextLine();

            //입력값 3자리 숫자인지 확인 ->  "\\d": 숫자인지   "\\d{3}" : 세자리 숫자인지
            if(!input.matches("\\d{3}")){
                System.out.println("올바르지 않은 입력값입니다. 3자리 숫자를 입력하세요.");
                continue; //유효하지 않으면 반복문 처음으로
            }

            // 입력값 숫자 중복 확인
            if(hasDuplicateDigits(input)){
                System.out.println("올바르지 않은 입력값입니다. 동일한 숫자 사용 불가능 합니다.");
                continue; //유요하지 않으면 반복문 처음으로
            }
            // 유요한 입력값 반환 하고 반복문 종료
            break;
    }
        //input 반환
        return input;
    }
}
