package stack_queue;

/*

설명
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
남은 문자만 출력한다.

*/


import java.util.Scanner;
import java.util.Stack;

public class RemoveBracket {
  public static void main(String[] args) {
    RemoveBracket T = new RemoveBracket();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

  // 해결방법
  // 문자를 하나씩 스택에 저장
  // 닫히는 괄호가 나오면 여는 괄호가 나올때 까지 스택에서 모든 문자 제거
  // 끝까지 검사 후 남은 문자 출력
  public String solution(String str) {
    String answer = "";
    // 스택 생성
    Stack<Character> stack = new Stack<>();
    // 문자를 하나씩 검사
    for (char x : str.toCharArray()) {
      if (x != ')') stack.push(x); // ')'이 아닌 경우 스택 추가
      else {
        while (stack.pop() != '(') ; // '('가 나올 때까지 스택 제거
      }
    }
    // 남은 스택 아래서부터 출력
    for (int i = 0; i < stack.size(); i++) {
      answer += stack.get(i);
    }
    return answer;
  }

}
