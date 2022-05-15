package dfs_bfs;

/*

설명
철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.

입력
첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
둘째 줄부터 N마리 바둑이의 무게가 주어진다.

출력
첫 번째 줄에 가장 무거운 무게를 출력한다.

*/

import java.util.Scanner;

public class DogRide {
  static int answer = 0;
  static int c, n;

  public static void main(String[] args) {
    DogRide T = new DogRide();
    Scanner kb = new Scanner(System.in);
    c = kb.nextInt();
    n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
    T.DFS(0, 0, arr);
    System.out.println(answer);
  }

  // 해결방법
  // 입력된 바둑이들을 태운 경우과 태우지 않은 경우를 체크
  // 태운 경우에는 무게 합에 더해주고 태우지 않은 경우에는 더하지 않는다
  // 모든 경우를 재귀함수로 체크
  // 만약 무게가 c를 넘어가면 리턴하고 모든 바둑이를 체크한 합이 answer보다 크다면 answer을 현재 합으로 바꿔준다
  public void DFS(int L, int sum, int[] arr) {
    if (sum > c) return; // 바둑이의 무게가 c를 넘을 경우 바로 리턴
    if (L == n) { // 모든 바둑이의 경우의 수를 체크, 마지막 레벨에 도달한 경우
      answer = Math.max(sum, answer); // 바둑이의 무게를 더한 값과 현재 저장된 값 중 더 큰 값 입력
    } else {
      DFS(L + 1, sum + arr[L], arr); // 현재 바둑이를 태운 경우
      DFS(L + 1, sum, arr); // 현재 바둑이를 태우지 않은 경우
    }
  }
}
