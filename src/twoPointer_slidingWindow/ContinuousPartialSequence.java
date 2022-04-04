package twoPointer_slidingWindow;

/*

설명
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
만약 N=8, M=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2
합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

입력
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
수열의 원소값은 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다.

*/

import java.util.Scanner;

public class ContinuousPartialSequence {
  public static void main(String[] args) {
    ContinuousPartialSequence T = new ContinuousPartialSequence();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    System.out.println(T.solution(arr, n, m));
  }

  // 해결방법
  // 연속된 수열의 합을 계속 m값과 비교하면서 같으면 answer++
  // 만약 작은 경우는 맨 앞에 더해진 값을 빼주고
  // 큰 경우는 바로 다음 값을 더해주어서 비교
  public int solution(int[] arr, int n, int m) {
    int answer = 0;
    int sum = 0;
    int front = 0, last = 0;

    while (last < n) {
      if (sum > m) { // 합이 m보다 크면 맨 앞 값 뺴주기
        sum -= arr[front++];
        if (sum == m) answer++;
      } else if (sum <= m) { // 합이 m보다 작거나 같으면 맨 뒷 값 더하기
        sum += arr[last++];
        if (sum == m) answer++;
      }
    }

    return answer;
  }
}
