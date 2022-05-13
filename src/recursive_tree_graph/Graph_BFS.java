package recursive_tree_graph;

/*

문제
방향그래프가 주어지면 1번 정점에서 각 정점으로 가는 최소 이동 간선 수를 출력하는 프로그램을 작성하세요

입력
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다.
그 다음부터 M 줄에 걸쳐 연결정보가 주어진다.

출력
1번 정점에서 각 정점으로 가는 최소 간선 수를 2번 정점부터 차례대로 출력하세요.

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_BFS {
  static int n, m;
  static ArrayList<ArrayList<Integer>> graph;
  static int[] ch, dis;

  public static void main(String[] args) {
    Graph_BFS T = new Graph_BFS();
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
    dis = new int[n + 1]; // 각 정점의 거리 체크
    // 그래프 정보 입력
    for (int i = 0; i < m; i++) {
      int a = kb.nextInt();
      int b = kb.nextInt();
      graph.get(a).add(b); // 각 정점에 연결된 정점을 입력
    }
    ch[1] = 1; // 1부터 시작하므로 1에 체크
    T.BFS(1);
    for (int i = 2; i <= n; i++) {
      System.out.println(i + " : " + dis[i]);
    }
  }

  // BFS 그래프 최단거리 알고리즘
  public void BFS(int v) {
    Queue<Integer> queue = new LinkedList<>();
    ch[v] = 1; // 현재 정점을 지나쳤음을 체크
    dis[v] = 0; // 현재 정점의 거리를 초기화
    queue.offer(v);
    // 큐에 값이 없을 때까지, 모든 정점을 지나칠때까지
    while (!queue.isEmpty()) {
      int cv = queue.poll();
      for (int nv : graph.get(cv)) {
        if (ch[nv] == 0) { // 체크되어있지 않은 지나온 적이 없는 정점만 실행
          ch[nv] = 1; // 지나왔다고 체크
          queue.offer(nv); // 다음 레벨에서 검사하도록 큐에 추가
          dis[nv] = dis[cv] + 1; // 이전 정점까지 거리에서 +1 한 값을 입력
        }
      }
    }

  }
}
