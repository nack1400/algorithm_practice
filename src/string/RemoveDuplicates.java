package string;


/*
설명
소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.

입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.

출력
첫 줄에 중복문자가 제거된 문자열을 출력합니다.
*/

import java.util.Scanner;

public class RemoveDuplicates {
  public static void main(String[] args) {
    RemoveDuplicates T = new RemoveDuplicates();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

  // 해결방법
  // 맨 앞에 중복되지 않는 문자만 남기자
  // 앞에 동일한 문자가 나왔다면 뒤에 문자는 포함시키지 말자
  public String solution(String str) {
    String answer = "";
    for (int i = 0; i < str.length(); i++) {
      //str.indexOf(str)은 str의 배열에서 처음 검색되는 위치를 리턴
      //그래서 str.indexOf(str.charAt(i))가 배열의 위치 i와 같다면 그 문자는 맨 앞에 있는 중복되지 않은 문자
      //만약 같지 않다면 이미 앞에 동일한 문자가 있다는 말
      if (str.indexOf(str.charAt(i)) == i) //같을 때만 리턴, 중복되지 않은 문자만 카운트
        answer += str.charAt(i);
    }
    return answer;
  }
}
