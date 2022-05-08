package recursive_tree_graph;

/*

설명
현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
송아지는 움직이지 않고 제자리에 있다.
현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.

입력
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.

출력
점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindACalf {
  int[] dis = {1, -1, 5};
  int[] ch;
  Queue<Integer> Q = new LinkedList<>();

  public static void main(String[] args) {
    FindACalf T = new FindACalf();
    Scanner kb = new Scanner(System.in);
    int s = kb.nextInt();
    int e = kb.nextInt();
    System.out.println(T.BFS(s, e));
  }

  // 최단거리 알고리즘
  // 처음 현수의 위치에서 시작해서 3가지 경우의 수를 큐에 저장
  // 저장된 값을 하나씩 꺼내가며 송아지의 위치와 일치하는 지 확인
  // 일치한다면 현재 레벨, 곧 이동한 횟수를 리턴
  // 그렇지 않다면 다시 다음 레벨에 검사할 3가지 경우의 수를 큐에 저장하고 다음 값 확인
  // 같은 레벨에 있는 모든 값을 확인하고 없다면 다음 레벨로 넘어감
  // 위의 과정을 송아지를 찾을 때까지 반복
  public int BFS(int s, int e) {
    ch = new int[10001];
    ch[s] = 1; // 현수가 위치했던 곳을 1로 표시
    Q.offer(s); // 첫번째 위치를 큐에 저장
    int L = 0; // 현재 레벨, 이동한 횟수
    while (!Q.isEmpty()) {
      int len = Q.size(); // 현재 레벨에 저장된 현수의 위치의 갯수
      for (int i = 0; i < len; i++) { // 현재 레벨에 해당하는 값들을 확인
        int x = Q.poll(); // 하나씩 검사
        for (int j = 0; j < 3; j++) {
          int nx = x + dis[j]; // 1, -1, 5만큼 이동시킨다
          // 만약 이동시킨 값이 송아지의 위치와 같다면 위치를 +1 해서 리턴
          if (nx == e) return L + 1;
          // 값이 좌표안에 있고 현수가 있었던 위치가 아니었다면 큐에 현재 위치를 저장, 다음 레벨에서 확인하기 위해서
          if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
            ch[nx] = 1; // 현수가 확인한 위치에 1을 저장
            Q.offer(nx);
          }
        }
      }
      L++; // 다음 레벨로 이동
    }
    return 0;
  }
}
