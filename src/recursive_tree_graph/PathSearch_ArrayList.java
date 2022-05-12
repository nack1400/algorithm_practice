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

import java.util.ArrayList;
import java.util.Scanner;

public class PathSearch_ArrayList {
  static int n, m, answer = 0;
  static ArrayList<ArrayList<Integer>> graph;
  static int[] ch;

  public static void main(String[] args) {
    PathSearch_ArrayList T = new PathSearch_ArrayList();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    m = kb.nextInt();
    // 그래프를 2차원 배열리스트로 표현
    graph = new ArrayList<ArrayList<Integer>>();
    // 배열리스트안에 배열리스트를 생성
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
    }
    ch = new int[n + 1]; // 이미 온 경로인지 체크
    // 그래프 정보 입력
    for (int i = 0; i < m; i++) {
      int a = kb.nextInt();
      int b = kb.nextInt();
      graph.get(a).add(b); // 각 정점에 연결된 정점을 입력
    }
    ch[1] = 1; // 1부터 시작하므로 1에 체크
    T.DFS(1);
    System.out.println(answer);
  }

  // DFS 그래프 경로탐색 알고리즘, 배열리스트 활용
  // 정점의 개수가 많을 때 사용
  public void DFS(int v) {
    if (v == n) answer++; // 정점에 도착했다면 가지 수 추가
    else { // 아직 도착하지 못했다면
      // 현재 정점에서 연결되어있는 정점들에서 하나씩 검사
      for (int nv : graph.get(v)) {
        if (ch[nv] == 0) {
          ch[nv] = 1; // 지나온 경로로 체크
          DFS(nv);
          ch[nv] = 0; // 찾은 후에 경로 초기화
        }
      }
    }
  }
}
