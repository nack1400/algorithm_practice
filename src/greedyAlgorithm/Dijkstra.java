package greedyAlgorithm;

/*

설명
아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요.
(경로가 없으면 Impossible를 출력한다)

입력
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보와 거리비용이 주어진다.

출력
1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
  public int vex;
  public int cost;

  Edge(int vex, int cost) {
    this.vex = vex;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge ob) { // 길이를 오름차순으로 정렬
    return this.cost - ob.cost;
  }
}

public class Dijkstra {
  static int n, m;
  static ArrayList<ArrayList<Edge>> graph;
  static int[] dis;

  public static void main(String[] args) {
    Dijkstra T = new Dijkstra();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    m = kb.nextInt();
    graph = new ArrayList<ArrayList<Edge>>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Edge>());
    }
    dis = new int[n + 1];
    Arrays.fill(dis, Integer.MAX_VALUE);
    for (int i = 0; i < m; i++) { // 그래프를 입력
      int a = kb.nextInt();
      int b = kb.nextInt();
      int c = kb.nextInt();
      graph.get(a).add(new Edge(b, c)); // 정점 번호는 a, 이동 정점과 간선 길이는 b,c
    }
    T.solution(1); // 1번 정점에서 출발
    for (int i = 2; i <= n; i++) {
      if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
      else System.out.println(i + " : impossible");
    }
  }

  public void solution(int v) {
    PriorityQueue<Edge> pQ = new PriorityQueue<>();
    pQ.offer(new Edge(v, 0));
    dis[v] = 0; // 거리를 체크
    while (!pQ.isEmpty()) {
      Edge tmp = pQ.poll(); // 정점을 하나 꺼냄
      int now = tmp.vex; // 이동할 정점의 위치와
      int nowCost = tmp.cost; // 정점까지의 거리를 저장
      if (nowCost > dis[now]) continue; // 기존에 조사한 뻗어나간 값보다 더 큰 값이 나온다면 굳이 검사할 필요가 없다
      for (Edge ob : graph.get(now)) { // 현재 정점과 연결된 정점과 길이를 검사
        // dis 저장된 정점까지의 거리와 현재 정점에서 조사한 다음 정점까지 이동 거리의 합을 비교하여 dis에 저장된 값보다 더 작다면 바꿔줘야함
        if (dis[ob.vex] > nowCost + ob.cost) {
          dis[ob.vex] = nowCost + ob.cost; // 새로운 거리 값을 dis에 저장해주고
          pQ.offer(new Edge(ob.vex, nowCost + ob.cost)); // 해당 정점을 저장한 큐에 구한 거리 값을 넣어준다
        }
      }
    }
  }
}
