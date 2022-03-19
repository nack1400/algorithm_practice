package string;

/*

설명
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
단 반복횟수가 1인 경우 생략합니다.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
첫 줄에 압축된 문자열을 출력한다.

*/

import java.util.Scanner;

public class StringCompression {
  public static void main(String[] args) {
    StringCompression T = new StringCompression();
    Scanner kb = new Scanner(System.in);
    String s = kb.next();
    System.out.println(T.solution(s));
  }

  // 해결방법 (혼자 풀어본 것)
  // 입력받은 문자열을 문자배열로
  // 배열을 돌며 같은 문자가 나오면 카운트
  // 다른 문자면 문자 출력, 카운트는 1이 아닐때만 출력
  public String solution(String s) {
    String answer = "";
    char c = ' '; // 비교를 위해 미리 빈 문자 삽입
    s += " "; // 마지막 문자 출력을 위해 빈 문자 더해줌
    int n = 1;
    for (char x : s.toCharArray()) {
      if (x == c) { // 앞 문자와 같다면 카운트만 증가
        n++;
      } else {
        if (n == 1) { // 앞 문자와 다르고 카운트가 1이라면 문자만 출력
          answer += x;
          c = x;
        } else { // 앞 문자와 다르고 카운트가 2이상이라면 둘 다 출력
          answer += n;
          answer += x;
          c = x;
          n = 1; //숫자 출력 후 카운트 초기화
        }
      }
    }
    return answer;
  }

  // 해결방법 2
  // 아이디어는 위와 비슷
  public String solution2(String s) {
    String answer = "";
    s = s + " "; // 마지막 문자 출력을 위한 빈 문자
    int cnt = 1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i + 1)) cnt++; // 앞의 문자와 같다면 카운트
      else {
        answer += s.charAt(i); // 앞의 문자와 다르다면 출력
        if (cnt > 1) answer += String.valueOf(cnt); //카운트가 1보다 클때만 출력
        cnt = 1;
      }
    }
    return answer;
  }
}