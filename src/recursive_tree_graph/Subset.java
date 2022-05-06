package recursive_tree_graph;

/*

문제
자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.

출력
첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같와 같은 순서로 출력한다.
단 공집합은 출력하지 않습니다.

*/

import java.util.Scanner;

public class Subset {
  static int n;
  static int[] ch; // 값을 사용할 지 안할지 체크하는 배열

  public static void main(String[] args) {
    Subset T = new Subset();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    ch = new int[n + 1];
    T.DFS(1); // 1부터 재귀함수 시작
  }

  public void DFS(int L) {
    if (L == n + 1) { // DFS가 가장 끝까지 도달했을때
      String tmp = "";
      // 배열에 있는 각 값들을 확인하여 1인 경우만 출력
      for (int i = 1; i <= n; i++) {
        if (ch[i] == 1) tmp += (i + " ");
      }
      if (tmp.length() > 0) System.out.println(tmp);
    } else {
      ch[L] = 1; // 문자열 출력을 L을 사용하여 만들겠다는 의미
      DFS(L + 1); // L을 출력하도록 만들어놓고 다음 메서드 실행
      ch[L] = 0; // L을 사용하지 않고 만들겠다는 의미
      DFS(L + 1); // L을 출력하지 않도록 만들어놓고 다음 메서드 실행
    }
  }
}