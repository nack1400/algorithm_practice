package dynamicProgramming;

import java.util.Scanner;

public class MaximumScore {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    // 시간을 차례로 줄이면서 얻을 수 있는 최대 점수를 구하기
    int[] dy = new int[m + 1];
    for (int i = 0; i < n; i++) {
      int ps = kb.nextInt();
      int pt = kb.nextInt();
      // 시간이 정해져 있고 문제의 수가 정해져 있기 때문에 최대에서 줄이면서 해야함
      // 하나씩 넣으면서 이 문제를 넣었을 때가 점수가 더 큰지 기존의 값이 큰지 비교
      // 현재 넣을 시간에서 문제의 시간만큼 작은 시간에 들어있는 수에서 점수를 더한 값을 기존값과 비교하여 더 큰 값을 넣는다
      // 마지막 문제를 넣을 때까지 반복
      for (int j = m; j >= pt; j--) {
        dy[j] = Math.max(dy[j], dy[j - pt] + ps);
      }
    }
    System.out.print(dy[m]);
  }
}
