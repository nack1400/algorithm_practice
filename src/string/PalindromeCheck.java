package string;

/*
설명
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.

입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

출력
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
*/

import java.util.Locale;
import java.util.Scanner;

public class PalindromeCheck {
  public static void main(String[] args) {
    PalindromeCheck T = new PalindromeCheck();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

  // 해결방법
  // 1
  // 문자열 길이의 절반만큼만 체크
  // 맨 앞과 맨 뒤부터 시작해서 가운데로 이동시키며 비교
  // 다르다면 NO를 바로 리턴 아니면 YES 리턴
  public String solution(String str) {
    str=str.toUpperCase(Locale.ROOT); // 대소문자 구분 X
    int len = str.length();
    for (int i = 0; i < len / 2; i++) {
      // 앞과 뒤에서 가운데로 오며 차례로 비교
      if (str.charAt(i) != str.charAt(len - i - 1)) {
        return "NO";
      }
    }
    return "YES";
  }

  // 2
  // StringBuilder의 reverse를 이용하여 뒤집고 난 뒤에 같은 지 비교
  public String solution2(String str) {
    //뒤집은 문자 저장
    String tmp = new StringBuilder(str).reverse().toString();
    if(str.equalsIgnoreCase(tmp)) // 대소문자 구분 없이 비교
      return "YES";
    return "NO";
  }
}
