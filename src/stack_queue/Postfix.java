package stack_queue;

/*

설명
후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.

입력
첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.

출력
연산한 결과를 출력합니다.

*/

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
  public static void main(String[] args) {
    Postfix T = new Postfix();
    Scanner kb = new Scanner(System.in);
    String str = kb.next();
    System.out.println(T.solution(str));
  }

  // 해결방법
  // 문자열을 앞에서부터 읽으며 숫자가 나오면 숫자로 변환 후 스택에 저장
  // 연산자가 나오면 스택에 있는 두 개의 숫자를 pop하여 저장하고 계산
  // 계산된 값을 다시 push
  // 모든 문자열을 읽은 뒤 남은 값을 리턴
  public int solution(String str) {
    int answer = 0;
    // 스택 생성
    Stack<Integer> stack = new Stack<>();
    // 문자를 하나씩 검사
    for (char x : str.toCharArray()) {
      // 숫자일때는 push, 연산자일때는 계산
      if (Character.isDigit(x)) stack.push(x - '0');
      else {
        // 저장된 두개의 값을 저장
        int a = stack.pop();
        int b = stack.pop();
        // 연산자에 따라 계산
        switch (x) {
          case '+':
            stack.push(b+a);
            break;
          case '-':
            stack.push(b-a);
            break;
          case '*':
            stack.push(b*a);
            break;
          case '/':
            stack.push(b/a);
            break;
        }
      }
    }
    answer = stack.pop(); // 계산된 남은 값을 리턴
    return answer;
  }
}
