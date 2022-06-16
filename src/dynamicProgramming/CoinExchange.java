package dynamicProgramming;

/*

설명
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.

입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
각 동전의 종류는 100원을 넘지 않는다.

출력
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.

*/

import java.util.Arrays;
import java.util.Scanner;

public class CoinExchange {
  static int n, m;
  static int[] dy;

  public static void main(String[] args) {
    CoinExchange T = new CoinExchange();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    m = kb.nextInt();
    dy = new int[m + 1];
    System.out.print(T.solution(arr));
  }

  // 해결방법
  // 적은 금액부터 구해야하는 금액까지 작은 동전부터 차례대로 사용하는 경우를 체크
  // 먼저 가장 작은 동전을 사용한 경우에 사용하는 동전의 개수를 구한다
  // 그 다음 동전을 사용하는 경우를 구할때 동전의 금액부터 마지막 금액까지 체크할 때
  // 현재 금액보다 동전 금액만큼 작은 금액에서의 경우의 수에서 1을 더한 값과 기존의 값을 비교한다
  // 동전 금액보다 작은 금액에서 동전을 하나 추가해준다는 개념
  // 마지막 동전까지 구하고 구한 경우의 수를 리턴한다
  public int solution(int[] coin) {
    Arrays.fill(dy, Integer.MAX_VALUE);
    dy[0] = 0;
    for (int i = 0; i < n; i++) { // 각 동전의 경우의 수를 구함
      for (int j = coin[i]; j <= m; j++) { // 현재 동전의 금액부터 끝까지 검사
        // 현재 값보다 동전값만큼 작은 금액에서의 경우의 수에서 1을 더한 값과 기존의 값을 비교해서 작은 값으로 바꾼다
        dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
      }
    }
    return dy[m];
  }
}
