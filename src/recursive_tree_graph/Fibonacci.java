package recursive_tree_graph;

/*

문제
피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
입력은 피보나치 수열의 총 항의 수이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

입력
첫 번째 줄은 총 항수 N(3<=N<=45)이 입력된다.

출력
첫째 줄에 피보나치 수열을 출력합니다.

*/

import java.util.Scanner;

public class Fibonacci {
  static int[] fibo; // 성능 개선을 위해 함수를 한번 돌았을때 값을 저장해줄 배열, 메모이제이션

  public static void main(String[] args) {
    Fibonacci T = new Fibonacci();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    fibo = new int[n + 1];
    T.DFS(n);
    for (int i = 1; i <= n; i++) System.out.print(fibo[i] + " ");
  }

  // 피보나치 수열
  // 1이나 2인 경우는 1이 리턴
  // 나머지의 경우는 바로 왼쪽의 값과 왼쪽 두번째의 값을 더한 값을 리턴
  public int DFS(int n) {
    if(fibo[n] > 0) return fibo[n]; // 만약 이미 계산 해놓은 값이 있다면 더 이상 계산하지 않고 그 값을 리턴
    if (n == 1) return fibo[n] = 1; // 1이면 1리턴
    else if (n == 2) return fibo[n] = 1; // 2이면 1리턴
    else return fibo[n] = DFS(n - 2) + DFS(n - 1);
  }
}
