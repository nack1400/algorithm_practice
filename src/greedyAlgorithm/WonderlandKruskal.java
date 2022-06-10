package greedyAlgorithm;

/*

설명
원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
아래의 그림은 그 한 예를 설명하는 그림이다.
위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.

입력
첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.

출력
모든 도시를 연결하면서 드는 최소비용을 출려한다.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 그래프를 표현하기 위한 클래스
class Edge2 implements Comparable<Edge2> {
  public int v1;
  public int v2;
  public int cost;

  Edge2(int v1, int v2, int cost) {
    this.v1 = v1;
    this.v2 = v2;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge2 ob) {
    return this.cost - ob.cost;
  }
}

public class WonderlandKruskal {
  static int[] unf;

  // 같은 그룹인지 확인
  public static int Find(int v) {
    if (v == unf[v]) return v;
    else return unf[v] = Find(unf[v]);
  }

  // 같은 그룹으로 만들어줌
  public static void Union(int a, int b) {
    int fa = Find(a);
    int fb = Find(b);
    if (fa != fb) unf[fa] = fb;
  }

  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    unf = new int[n + 1];
    ArrayList<Edge2> arr = new ArrayList<>();
    for (int i = 1; i <= n; i++) unf[i] = i;
    for (int i = 0; i < m; i++) {
      int a = kb.nextInt();
      int b = kb.nextInt();
      int c = kb.nextInt();
      arr.add(new Edge2(a, b, c));
    }
    int answer = 0;
    // 간선의 길이로 오름차순으로 정렬
    Collections.sort(arr);
    // 오름차순으로 정렬되어있으므로 간선의 길이가 작은 것부터 우선적으로 선택됨
    for (Edge2 ob : arr) {
      int fv1 = Find(ob.v1);
      int fv2 = Find(ob.v2);
      if (fv1 != fv2) {
        answer += ob.cost;
        Union(ob.v1, ob.v2);
      }
    }
    System.out.println(answer);
  }
}
