package dfs_bfs;

/*

설명
다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
nCr = c-1Cr-1 + n-1Cr

입력
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.

출력
첫째 줄에 조합수를 출력합니다.

*/

import java.util.Scanner;

public class NumberOfCombinations {
  int[][] dy = new int[35][35]; // 먼저 계산된 조합을 저장하는 배열

  public static void main(String[] args) {
    NumberOfCombinations T = new NumberOfCombinations();
    Scanner kb = new Scanner(System.in);

    int n = kb.nextInt();
    int r = kb.nextInt();
    System.out.println(T.DFS(n, r));
  }

  public int DFS(int n, int r) {
    if (dy[n][r] > 0) return dy[n][r]; // 먼저 계산된 조합이 있다면 재귀함수를 돌리지 않고 리턴
    if (n == r || r == 0) return 1; // 가장 끝 노드에 도달했을 때, 곧 조합의 값이 1일때 리턴
    else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r); // 주어진 공식을 사용
  }
}
