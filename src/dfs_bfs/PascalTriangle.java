package dfs_bfs;

/*

설명
가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
3 1 2 4
 4 3 6
  7 9
   16
N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.

입력
첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.

출력
첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
답이 존재하지 않는 경우는 입력으로 주어지지 않는다.

*/

import java.util.Scanner;

public class PascalTriangle {
  static int[] b, p, ch;
  static int n, f;
  boolean flag = false;
  int[][] dy = new int[35][35]; // 먼저 계산된 조합을 저장하는 배열

  public static void main(String[] args) {
    PascalTriangle T = new PascalTriangle();
    Scanner kb = new Scanner(System.in);

    n = kb.nextInt();
    f = kb.nextInt();
    b = new int[n];
    p = new int[n];
    ch = new int[n + 1];

    // 곱해줄 조합을 저장
    for (int i = 0; i < n; i++) {
      b[i] = T.combi(n - 1, i);
    }
    T.DFS(0, 0);
  }

  public void DFS(int L, int sum) {
    if (flag) return; // 답을 발견했다면 그 뒤는 모두 리턴
    if (L == n) {
      if(sum == f){
        for (int x : p) System.out.print(x + " ");
        flag = true; // 답을 발견했다고 알림
      }
    } else {
      for (int i = 1; i <= n; i++) { // 현재 위치에 1부터 차례대로 넣어서 확인
        if (ch[i] == 0) { // 사용하지 않은 수일때 실행
          ch[i] = 1; // 사용했다고 체크
          p[L] = i; // 수열에 현재 값을 넣어주고
          // 다음번으로 넘어가서 재귀함수 실행, 합에 조합과 선택된 수를 곱하고 더하여 넘겨준다
          DFS(L + 1, sum + (p[L] * b[L]));
          ch[i] = 0; // 끝난 뒤 체크해제
        }
      }
    }
  }

  // 이전에 했던 조합 코드
  // 파스칼의 삼각형의 마지막 값은 각 값에 일정한 규칙의 조합을 곱하고 더한 것으로 구할 수 있다
  // 각 항에 해당하는 조합을 저장해놓고 값과 곱하고 더하여 구하자
  public int combi(int n, int r) {
    if (dy[n][r] > 0) return dy[n][r]; // 먼저 계산된 조합이 있다면 재귀함수를 돌리지 않고 리턴
    if (n == r || r == 0) return 1; // 가장 끝 노드에 도달했을 때, 곧 조합의 값이 1일때 리턴
    else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r); // 주어진 공식을 사용
  }
}
