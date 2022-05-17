package dfs_bfs;

/*

설명
1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.

입력
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.

출력
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

*/

import java.util.Scanner;

public class PermutationWithRepetition {
  static int[] pm;
  static int n, m;

  public static void main(String[] args) {
    PermutationWithRepetition T = new PermutationWithRepetition();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    m = kb.nextInt();
    pm = new int[m];
    T.DFS(0);
  }

  // 해결방법
  // 중복 가능한 수열의 경우의 수
  // 만약 마지막 번째의 수를 선택한 경우 배열에 저장된 수를 차례대로 출력
  // 마지막 번째가 아니라면 현재 선택된 수를 배열에 저장하고 재귀함수 출력
  // 각 경우의 수를 스택프레임으로 쌓았기 때문에 배열에는 현재 선택된 순열이 저장되어 있음
  // 그러므로 출력하고 재귀함수 리턴하고 다음 경우의 수로 넘어가는 것을 반복
  public void DFS(int L) {
    if (L == m) { // 마지막 레벨까지 도달한 경우 현재 배열에 저장된 순열을 출력
      for (int x : pm) System.out.print(x + " ");
      System.out.println();
    } else {
      for (int i = 1; i <= n; i++) {
        pm[L] = i; // i가 선택된 경우의 순열을 저장
        DFS(L+1); // 현재 i가 선택된 상태로 다음 수를 저장하는 경우의 수를 찾으러 재귀함수 호출
      }
    }
  }
}
