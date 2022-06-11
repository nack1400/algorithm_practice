package greedyAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 그래프를 표현하기 위한 클래스
class Edge3 implements Comparable<Edge3> {
  public int vex;
  public int cost;

  Edge3(int vex, int cost) {
    this.vex = vex;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge3 ob) {
    return this.cost - ob.cost;
  }
}

public class WonderlandPrim {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    ArrayList<ArrayList<Edge3>> graph = new ArrayList<ArrayList<Edge3>>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Edge3>());
    }
    int[] ch = new int[n + 1];

    // 그래프 입력
    for (int i = 0; i < m; i++) {
      int a = kb.nextInt();
      int b = kb.nextInt();
      int c = kb.nextInt();
      graph.get(a).add(new Edge3(b, c));
      graph.get(b).add(new Edge3(a, c));
    }
    int answer = 0;

    // 간선의 길이가 작은 것을 뽑기위한 우선순위 큐
    PriorityQueue<Edge3> pQ = new PriorityQueue<>();
    pQ.offer(new Edge3(1, 0)); // 간선하나를 넣어주고 시작

    while (!pQ.isEmpty()) {
      Edge3 tmp = pQ.poll(); // 길이가 작은 정점 하나를 꺼내고
      int ev = tmp.vex;
      // 정점을 연결
      if (ch[ev] == 0) { // 가려하는 정점이 연결되어있지 않을 때만 실행
        ch[ev] = 1; // 체크해주고
        answer += tmp.cost; // 간선의 길이를 추가
        for (Edge3 ob : graph.get(ev)) { // 도달한 뒤 그 정점에 연결된 다른 정점을 큐에 저장
          // 이전에 확인한 현재 정점에 도달하기 위한 간선을 제외하고 모두 저장
          if (ch[ob.vex] == 0) pQ.offer(new Edge3(ob.vex, ob.cost));
        }
      }
    }
    System.out.println(answer);
  }
}
