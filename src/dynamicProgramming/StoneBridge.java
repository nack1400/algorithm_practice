package dynamicProgramming;

/*

설명
철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
철수가 개울을 건너는 방법은 몇 가지일까요?

입력
첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.

출력
첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.

*/

import java.util.Scanner;

public class StoneBridge {
  static int[] dy;

  public static void main(String[] args) {
    StoneBridge T = new StoneBridge();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    dy = new int[n + 2];
    System.out.print(T.solution(n));
  }

  // 해결방법
  // 순차적으로 생각
  // 1,2번 방법의 수를 구해놓고 다음 돌다리로 가는 경우의 수를 생각
  // 3번은 1번에서 2칸 간 경우와 2번에서 1칸 간 경우의 수이므로 1,2번 경우의 수의 합
  // 4번은 2번에서 2칸 간 경우와 3번에서 1칸 간 경우의 수이므로 2,3번 경우의 수의 합
  // 그러므로 현재 돌다리 건너기의 방법의 수는 피보나치 수열과 같다
  public int solution(int n) {
    dy[1] = 1;
    dy[2] = 2;
    for (int i = 3; i <= n + 1; i++) dy[i] = dy[i - 2] + dy[i - 1];
    return dy[n + 1]; // 돌다리에서 다음 번까지 넘어가야하므로 n + 1
  }
}
