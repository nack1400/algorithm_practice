package recursive_tree_graph;

/*

문제
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요

입력
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다.
그 다음부터 M 줄에 걸쳐 연결정보가 주어진다.

출력
총 가지 수를 출력한다.

*/

import java.util.Scanner;

public class PathSearch_DFS {
  static int n, m, answer = 0;
  static int[][] graph;
  static int[] ch;

  public static void main(String[] args) {
    PathSearch_DFS T = new PathSearch_DFS();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    m = kb.nextInt();
    graph = new int[n + 1][n + 1];
    ch = new int[n + 1]; // 이미 온 경로인지 체크
    // 그래프 정보 입력
    for (int i = 0; i < m; i++) {
      int a = kb.nextInt();
      int b = kb.nextInt();
      graph[a][b] = 1;
    }
    ch[1] = 1; // 1부터 시작하므로 1에 체크
    T.DFS(1);
    System.out.println(answer);
  }

  // DFS 그래프 경로탐색 알고리즘
  public void DFS(int v) {
    if (v == n) answer++; // 정점이라면 가지 수 추가
    else { // 정점이 아니라면
      for (int i = 1; i <= n; i++) { // 1번부터 5번까지 경우의 수를 체크
        if (graph[v][i] == 1 && ch[i] == 0) { // v번째 노드가 갈 수 있는 노드라면
          ch[i] = 1; // 다음 노드로 갔으므로 체크
          DFS(i); // 다음 노드에서 다시 함수 실행
          ch[i] = 0; // 함수 실행을 완료했으므로 체크해제하고 이전 노드로
        }
      }
    }
  }
}
