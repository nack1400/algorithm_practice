package twoPointer_slidingWindow;

/*

설명
현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
12 1511 20 2510 20 19 13 15
연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
여러분이 현수를 도와주세요.

입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

출력
첫 줄에 최대 매출액을 출력합니다.

*/

import java.util.Scanner;

public class MaximumSales {
  public static void main(String[] args) {
    MaximumSales T = new MaximumSales();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    System.out.println(T.solution(arr, n, m));
  }

  // 해결방법
  // 입력받은 수를 m개 만큼 잘라서 더해주고 큰값으로 리턴 값을 교체
  // 다음 차례로 넘어갈 때마다 앞의 값은 빼주고 뒤에 값을 더해주는 방법을 사용
  // 시간복잡도를 줄이기 위하여
  public int solution(int[] arr, int n, int m) {
    int answer = 0;
    int sum = 0;

    for (int i = 0; i < m; i++) { // 첫번째 합 구하기
      sum += arr[i];
    }
    answer = sum; // 첫번째 합 대입

    // 앞에 값은 빼주고 뒤에 값을 더해주며 비교
    for (int i = m; i < n; i++) {
      sum = sum + arr[i] - arr[i - m];
      if (answer < sum) answer = sum;
    }

    return answer;
  }

  // 잘못된 방법 O(n^2)
  // 시간이 너무 오래걸림, 이중 반복문
  public int solution2(int[] arr, int n, int m) {
    int answer = 0;
    for (int i = m - 1; i < n; i++) {
      int sum = 0;
      for (int j = m - 1; j >= 0; j--) {
        sum += arr[i - j];
      }
      if (answer < sum) answer = sum;
    }

    return answer;
  }
}
