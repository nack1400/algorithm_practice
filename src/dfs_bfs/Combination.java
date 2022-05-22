package dfs_bfs;

/*

설명
1부터 N까지 번호가 적힌 구슬이 있습니다.
이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.

입력
첫째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.

출력
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

*/

import java.util.Scanner;

public class Combination {
  static int[] combi;
  static int n, m;

  public static void main(String[] args) {
    Combination T = new Combination();
    Scanner kb = new Scanner(System.in);

    n = kb.nextInt();
    m = kb.nextInt();
    combi = new int[m];
    T.DFS(0, 1);
  }

  // 조합을 구하는 알고리즘
  // 제일 앞에서부터 하나씩 선택하며 순서를 고려하지 않으므로 다음 숫자는 뒤에 있는 숫자만 선택
  // 하나 선택 후 뒤에 것 중에 고르는 방식으로 재귀함수 호출
  public void DFS(int L, int s) {
    if (L == m) { // 모두 다 선택 되었다면 리턴
      for (int x : combi) System.out.print(x + " ");
      System.out.println();
    } else {
      for (int i = s; i <= n; i++) { // 앞에서부터 하나씩 선택
        combi[L] = i; // 선택된 수를 입력
        DFS(L + 1, i + 1); // 입력된 수 다음 수부터 하나씩 선택하도록 호출
      }
    }
  }
}
