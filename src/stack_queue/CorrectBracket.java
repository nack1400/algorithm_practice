package stack_queue;

/*

설명
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.

입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

출력
첫 번째 줄에 YES, NO를 출력한다.

*/

import java.util.Scanner;
import java.util.Stack;

public class CorrectBracket {
  public static void main(String[] args) {
    CorrectBracket T = new CorrectBracket();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

  // 해결방법
  // 기본적인 스택 활용
  // '(' 가 나오면 스택 추가 ')'가 나오면 스택 제거
  // 만약 스택이 없다면 NO 리턴, 문자열을 모두 읽었는데 스택이 남았다면 NO 리턴
 public String solution(String str){
    String answer = "YES";
    // 스택 생성
    Stack<Character> stack = new Stack<>();
    // 문자를 하나씩 검사하며 스택 추가 및 삭제
    for (char x : str.toCharArray()) {
      if(x=='(') stack.push(x); // '('인 경우 스택 추가
      else{ // ')'인 경우 스택 빼주고 남은 스택이 없으면 NO 리턴
        if(stack.isEmpty()) return "NO";
        stack.pop();
      }
    }
    if(!stack.isEmpty()) return "NO"; // 모든 문자를 다 검사했는데 스택이 남았으면 NO 리턴
    return answer;
  }

}
