package twoPointer_slidingWindow;

/*

설명

0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면

1 1 0 0 1 1 0 1 1 0 1 1 0 1

여러분이 만들 수 있는 1이 연속된 연속부분수열은

1 1 0 0 1 1 1 1 1 1 1 1

이며 그 길이는 8입니다.

입력
첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

출력
첫 줄에 최대 길이를 출력하세요.

*/


import java.util.Scanner;

public class MaximumLengthContinuousSubsequence {
  public static void main(String[] args) {
    MaximumLengthContinuousSubsequence T = new MaximumLengthContinuousSubsequence();
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
  // cnt로 0이 나온 횟수를 계산해서 m보다 작거나 같으면 뒷자리를 추가하고
  // m보다 크면 앞자리를 빼준다
  // 이때 나오는 수열의 길이를 answer과 비교하여 큰 값을 answer에 넣는다
  public int solution(int[] arr, int n, int m) {
    int answer = 0;
    int front = 0, last = 0;
    int cnt = 0; // 0이 들어있는 갯수

    while (last < n) {
      if (arr[last] == 0) cnt++; // 뒷자리에 0이 나오면 더해준다
      while (cnt > m) {
        if (arr[front] == 0) cnt--; // 앞자리를 하나씩 빼주면서 0이 나올때까지 빼준다
        front++;
      }
      answer = Math.max(answer, last - front + 1); //큰 값을 대입
      last++;
    }

    return answer;
  }

}
