package twoPointer_slidingWindow;

/*

설명
N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
만약 N=15이면
7+8=15
4+5+6=15
1+2+3+4+5=15
와 같이 총 3가지의 경우가 존재한다.

입력
첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

출력
첫 줄에 총 경우수를 출력합니다.

*/

import java.util.Scanner;

public class ContinuousSum {
  public static void main(String[] args) {
    ContinuousSum T = new ContinuousSum();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    System.out.println(T.solution(n));
  }

  // 해결방법
  // 연속된 자연수의 합을 작은 것부터 차례대로 비교
  // 합이 만약 작은 경우는 맨 앞에 더해진 값을 빼주고
  // 큰 경우는 바로 다음 값을 더해주어서 비교
  // 같다면 answer++
  public int solution(int n) {
    int answer = 0;
    int sum = 1, m = n/2;
    int front = 1 , last =2;

    // front의 값이 n의 절반이 넘어가는 경우 답이 나올 수 없으므로
    while(front <= m){
      if (sum > n){ // 작을 경우 앞의 값 빼주기
        sum -= front++;
        if(sum == n) answer++;
      } else { // 크거나 같을 경우 뒤의 값 더해주기
        sum += last++;
        if(sum == n) answer++;
      }
    }

    return answer;
  }
}
