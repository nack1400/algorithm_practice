package dfs_bfs;

/*

설명
N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.

입력
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.

출력
첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.

*/

import java.util.Scanner;

public class SubsetOfEqualSum {
  static String answer = "NO";
  static int n, total = 0;
  boolean flag = false;

  public static void main(String[] args) {
    SubsetOfEqualSum T = new SubsetOfEqualSum();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
      total += arr[i]; // 모든 원소의 합을 미리 저장
    }
    T.DFS(0, 0, arr);
    System.out.println(answer);
  }

  // 해결방법
  // 한쪽 부분집합만 구한다고 가정
  // 첫번째 원소부터 차례대로 경우의 수를 체크
  // 해당 원소가 합해진 경우, 빠진 경우를 나누어서 체크
  // 이때 구해진 부분집합의 합 중 전체합의 절반인 값이 있다면 두 부분집합의 합이 같은 경우이므로 YES리턴
  // 만약 없다면 그대로 NO리턴
  public void DFS(int L, int sum, int[] arr) {
    if (flag) return; // yes가 발견되면 나머지를 다 리턴
    if (sum > total / 2) return; // 만약 합이 전체 합의 절반보다 커진다면 두 개의 부분집합의 합이 같을 수 없으므로 리턴
    if (L == n) {
      // 부분집합의 합이 전체 합의 절반일 경우 합이 같은 부분집합이 있으므로 YES리턴
      if ((total - sum) == sum) {
        answer = "YES";
        flag = true; // yes가 발견되었다고 알리는 변수
      }
    } else {
      DFS(L + 1, sum + arr[L], arr); // 현재 원소를 더한 경우
      DFS(L + 1, sum, arr); // 현재 원소를 더하지 않은 경우
    }
  }
}
