package numplay;


import java.util.*;

//랜덤으로 정답 숫자 생성
public class RandomNumbers {

    // 1~9 숫자 담은 HashSet 객체 생성
    // HashSet으로 중복 숫자 없는 숫자 집합 만듬
    private Set<Integer> numberSet = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    // 랜덤 숫자 생성 메서드
    public String createRandomNumber(){
        //Random 객체 선언 및 생성
        Random random = new Random();
        //HashSet타입 numberSet 리스트 타입으로 변환
        //HashSet은 순서 없어서 List로 변환 해서 순서를 섞게 함
        List<Integer> numberList = new ArrayList<>(numberSet);

        //Collections.shuffle로 리스트에 담긴 숫자 랜덤객체 사용해서 랜덤하게 골고루 섞음
        Collections.shuffle(numberList,random);

        // 리스트에서 3개 숫자 선택해서 문자열로 만듬
        StringBuilder treeNumber = new StringBuilder();
        for (int i = 0; i <3 ; i++) {
            // 리스트에서 숫자 가져와서 treeNumber에 담기
            treeNumber.append(numberList.get(i));
        }
        // 랜덤 3자리 숫자 반환
        return treeNumber.toString();
    }
}
