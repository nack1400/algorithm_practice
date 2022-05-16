package dfs_bfs;

/*

설명
이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
(해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)

입력
첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.

출력
첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.

*/

import java.util.Scanner;

public class MaximumScore {
  static int answer = 0;
  static int n, m;

  public static void main(String[] args) {
    MaximumScore T = new MaximumScore();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    m = kb.nextInt();
    int[] score = new int[n]; // 문제 점수
    int[] time = new int[n]; // 문제 푸는 데 소요되는 시간
    for (int i = 0; i < n; i++) {
      score[i] = kb.nextInt();
      time[i] = kb.nextInt();
    }
    T.DFS(0, 0, 0, score, time);
    System.out.println(answer);
  }

  // 해결방법
  // 문제를 맞춘 경우와 맞추지 않은 경우를 나누어서 체크
  // 문제를 푼 시간이 제한 시간보다 커지면 체크하지 않고 리턴
  // 모든 문제를 체크해서 마지막 레벨 도달 시 현재 합이 answer보다 크다면 변경
  public void DFS(int L, int sum, int t, int[] score, int[] time) {
    if (t > m) return; // 문제 시간 초과시 체크하지 않고 리턴
    if (L == n) { // 마지막 문제까지 도달 시
      answer = Math.max(sum, answer); // 더 큰 수를 대입
    } else {
      DFS(L + 1, sum + score[L], t + time[L], score, time); // 현재 문제를 푸는 경우
      DFS(L + 1, sum, t, score, time); // 현재 문제를 풀지 않는 경우
    }
  }
}
