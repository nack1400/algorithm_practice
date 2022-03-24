package array;

/*
설명
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.

입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.

출력
첫 줄에 소수의 개수를 출력합니다.
*/

import java.util.Scanner;

public class PrimeNumber {
  public static void main(String[] args) {
    PrimeNumber T = new PrimeNumber();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    System.out.println(T.solution(n));
  }

  // 해결방법
  // 숫자+1 크기 만큼의 배열을 생성
  // 0인 값을 만나면 answer의 값을 증가시키고 그 수의 모든 배수를 1로 변경
  // 0이면 소수, 1이면 소수가 아닌 수
  public int solution(int n) {
    int answer = 0;
    int[] arr = new int[n + 1];
    // 2부터 시작, 소수 찾기
    for (int i = 2; i < n; i++) {
      if (arr[i] == 0) {
        answer++;
        // 소수의 배수번째 값을 1로 바꾸어줌
        for (int j = i; j <= n; j = j + i) arr[j] = 1;
      }
    }
    return answer;
  }
}
