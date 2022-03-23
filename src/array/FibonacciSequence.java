package array;

/*

설명
1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.

출력
첫 줄에 피보나치 수열을 출력합니다.

*/

import java.util.Scanner;

public class FibonacciSequence {
  public static void main(String[] args) {
    FibonacciSequence T = new FibonacciSequence();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    System.out.println(T.solution(n));
  }

  // 해결방법
  // 입력된 수 크기의 배열 생성
  // 1,2번째 수를 1로 초기화 시킨 후 앞의 두개를 더한 값을 다음 값으로
  public String solution(int n) {
    String answer = "";
    int[] arr = new int[n];
    arr[0] = 1;
    arr[1] = 1;
    for (int i = 2; i < n; i++) {
      arr[i] = arr[i-1] + arr[i-2];
    }
    for (int x : arr) {
      answer += (x + " ");
    }
    return answer;
  }
}
