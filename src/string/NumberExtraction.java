package string;

/*

설명
문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.

입력
첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.

출력
첫 줄에 자연수를 출력합니다.

*/

import java.util.Scanner;

public class NumberExtraction {
  public static void main(String[] args) {
    NumberExtraction T = new NumberExtraction();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine();
    System.out.println(T.solution(str));
  }

  // 해결방법 1
  // 문자열 앞에서 부터 숫자일때만 계산
  // 숫자가 나오면 그 숫자를 1의 자리 숫자로 넣어준다
  // 이미 앞에 나온 숫자에서 10을 곱하여 더해준다 -> 자릿수를 계속 밀어줌
  public int solution(String str) {
    int answer = 0;
    for (char x : str.toCharArray()) { //문자 하나씩 검사
      // 숫자일때만 1의 자리 수로 넣고 나머지 자릿수를 하나씩 올린다
      if (x >= 48 && x <= 57) answer = answer * 10 + (x - 48);
    }
    return answer;
  }

  // 해결방법 2
  // 위의 방법에서 아스키 넘버로 확인하는 것이 아닌 숫자로 된 문자를 그대로 더해 준다
  // 리턴을 할 때 int형으로 리턴해줘서 맨 앞의 0을 없엔다
  public int solution2(String str) {
    String answer = "";
    for (char x : str.toCharArray()) {
      if (Character.isDigit(x)) answer += x;
    }
    return Integer.parseInt(answer); // int 형으로 바꿔서 리턴
  }
}
