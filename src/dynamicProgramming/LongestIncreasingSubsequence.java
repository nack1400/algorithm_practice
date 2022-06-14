package dynamicProgramming;

/*

설명
N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
길이가 5인 최대 부분 증가수열을 만들 수 있다.

입력
첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고,
둘째 줄은 N개의 입력데이터들이 주어진다.

출력
첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.

*/

import java.util.Scanner;

public class LongestIncreasingSubsequence {
  static int[] dy;

  public static void main(String[] args) {
    LongestIncreasingSubsequence T = new LongestIncreasingSubsequence();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    System.out.print(T.solution(arr));
  }

  // 해결방법
  // 첫번째부터 차례대로 현재 항을 마지막이라 가정했을 때 가능한 수열의 길이를 저장
  // 첫번째는 하나이므로 1
  // 두번째부터는 그 이전에 자신보다 작은 값에서 1을 더한 값이 수열의 길이로 가능하므로
  // 자신보다 작은 값의 수열의 길이 중 최대값에 1을 더한 값이 현재 항에 가능한 수열의 최대길이
  // 이것을 마지막까지 반복한 뒤 가장 큰 값이 수열의 최대 길이이다
  public int solution(int[] arr) {
    int answer = 0;
    dy = new int[arr.length];
    dy[0] = 1;
    for (int i = 1; i < arr.length; i++) { // 두번째 항부터 차례대로 수열의 길이를 입력
      int max = 0;
      // 현재 항에서 가능한 최대 수열의 길이를 검사
      // 이전에 검사한 값들 중 자신보다 작은 항들 중 수열 길이의 최대 값을 찾는다
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
      }
      dy[i] = max + 1; // 앞의 항에서 검사한 값 중 최대값에 +1 한 값이 현재 항의 최대 수열의 길이
      answer = Math.max(answer, dy[i]); // 값이 더 크다면 바꿔준다
    }
    return answer;
  }
}
