package string;

/*
설명
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.


출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
*/

import java.util.Scanner;

public class CharacterDistance {
  public static void main(String[] args) {
    CharacterDistance T = new CharacterDistance();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    char t = kb.next().charAt(0);
    for (int x : T.solution(str, t)) {
      System.out.print(x + " ");
    }
  }

  // 해결방법
  // 문자열과 동일한 길이의 int 배열을 만들고 문자열을 첫번째 문자부터 검사
  // 처음 입력한 문자를 만나기 전에는 큰 숫자로 입력
  // 만나면 0을 입력하고 +1을 해주며 끝까지 진행
  // 마지막에 도달하면 반대 방향으로 진행하며 동일하게 진행
  // 검사해서 나온 수 중 작은 숫자를 선택
  public int[] solution(String s, char t) {
    int[] answer = new int[s.length()]; //문자열 길이만큼 int 배열 생성
    int p = 1000; //큰 수를 정의

    //배열 전체를 돌며 만나면 0아니면 +1을 시켜주며 int 배열을 채움
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t) {
        p = 0;
        answer[i] = p;
      } else {
        p++;
        answer[i] = p;
      }
    }
    p = 1000;

    //반대로 돌며 만나면 0 아니면 +1을 시켜주고
    //배열을 채울 떄 기존의 값과 비교하여 더 작을 경우 교체
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == t) p = 0;
      else {
        p++;
        answer[i] = Math.min(answer[i], p);
      }
    }
    return answer;
  }

}
