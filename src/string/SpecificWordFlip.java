package string;

/*
설명
영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

입력
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.

출력
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
*/

import java.util.Scanner;

public class SpecificWordFlip {
  public static void main(String[] args) {
    SpecificWordFlip T = new SpecificWordFlip();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

  // 해결방법
  // 기본 뒤집기 알고리즘을 활용하자
  // 알고리즘에서 특수문자일때 인덱스를 다음 거로 넘겨주도록 핮자
  public String solution(String str) {
    String answer;
    char[] s = str.toCharArray(); // string 기반 문자 배열 생성
    int lt = 0, rt = str.length() - 1; // 맨 앞, 맨 뒤를 가리키는 변수 생성
    while (lt < rt) {
      // Character 객체의 isAlphabetic 메서드를 활용
      // 알파벳이 아닐때 변경지점을 다음으로 넘겨준다
      if (!Character.isAlphabetic(s[lt])) lt++;
      else if (!Character.isAlphabetic(s[rt])) rt--;
      else {
        char tmp = s[lt];
        s[lt] = s[rt];
        s[rt] = tmp;
        lt++;
        rt--;
      }
    }
    answer = String.valueOf(s);
    return answer;
  }
}
