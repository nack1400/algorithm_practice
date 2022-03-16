package string;

/*
설명
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
알파벳 이외의 문자들의 무시합니다.

입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

출력
첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
*/

import java.util.Scanner;

public class PalindromeAlphabetCheck {
  public static void main(String[] args) {
    PalindromeAlphabetCheck T = new PalindromeAlphabetCheck();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine();
    System.out.println(T.solution(str));
  }

  // 해결방법
  // 입력받은 문자열에서 알파벳을 제외한 문자 제거
  // 알파벳만 남은 문자열을 뒤집은 문자가 기존과 같은지 확인
  public String solution(String str) {
    String answer = "NO";

    // 모든 알파벳을 대문자로 바꾸고 알파벳이 아닌 것은 아무것도 없는 문자로 바꿈
    str = str.toUpperCase().replaceAll("[^A-Z]", "");
    // 바꾼 문자열의 뒤집은 문자열을 저장
    String tmp = new StringBuilder(str).reverse().toString();
    // 뒤집은 문자열과 같은 지 확인
    if (str.equals(tmp))
      answer = "YES";
    return answer;
  }
}
