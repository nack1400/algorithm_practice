package dfs_bfs;

/*

설명
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.

입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.

출력
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.

*/

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinExchange {
  static int answer = Integer.MAX_VALUE;
  static int n, m;

  public static void main(String[] args) {
    CoinExchange T = new CoinExchange();
    Scanner kb = new Scanner(System.in);

    n = kb.nextInt();
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
    // 시간효율성을 위해 큰 수부터 대입하도록 내림차순 정렬
    Arrays.sort(arr, Collections.reverseOrder());

    m = kb.nextInt();
    T.DFS(0, 0, arr);
    System.out.println(answer);
  }

  // 해결방법
  // 선택 가능한 동전 개수의 최소값
  // 동전을 하나씩 선택하는 경우의 수를 체크하여 재귀함수
  // 금액과 같아질때 저장된 answer의 값보다 작다면 교체
  // 동전의 합이 금액을 넘어갈때 리턴
  public void DFS(int L, int sum, Integer[] arr) {
    if (sum > m) return; // 금액의 합이 넘어가면 더 이상 계산하지 않음
    if (L >= answer) return; // 동전 개수가 현재 answer보다 커진다면 계산할 필요없이 리턴
    if (sum == m) { // 금액의 합과 같아질때 현재 추가된 동전의 개수를 현재 값과 비교하여 작은값으로 교체
      answer = Math.min(answer, L);
    } else { // 각 동전을 추가한 각각의 경우를 나누어서 재귀함수 호출
      for (int i = 0; i < n; i++) {
        DFS(L + 1, sum + arr[i], arr);
      }
    }
  }
}
