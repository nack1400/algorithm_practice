package recursive_tree_graph;

/*

문제
자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
예를 들어 5!=5*4*3*2*1=120입니다

입력
첫 번째 줄은 자연수 N(1<=N<=10)이 입력된다.

출력
첫째 줄에 N팩토리얼 값을 출력합니다.

*/

import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    Factorial T = new Factorial();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    System.out.println(T.DFS(n));
  }

  // 팩토리얼
  // 입력받은 값에서 하나씩 줄이며 곱해준다
  public int DFS(int n) {
    if (n == 1) return 1; // 1이면 리턴
    return n * DFS(n - 1); // 입력받은 값을 n-1이 입력된 값에 곱해준다
  }
}
