package recursive_tree_graph;

/*

설명
10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.
단 재귀함수를 이용해서 출력해야합니다.

입력
첫 번째 줄에 10진수 N(1<=N<=1000)이 주어집니다.

출력
첫 번째 줄에 이진수를 출력하세요.

*/

import java.util.Scanner;

public class BinaryNumber {
  public static void main(String[] args) {
    BinaryNumber T = new BinaryNumber();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    T.DFS(n);
  }

  // 이진수를 구하는 공식
  // 바꿔야하는 값을 2로 나눈 나머지를 구하고 나눈 몫을 다시 2로 나누어 반복한다
  // 값이 0이 될 때까지 반복
  // 0이 된다면 지금까지 나온 나머지를 역순으로 적어준다
  public void DFS(int n) {
    if (n == 0) return; // 더 나눌 것이 없다면 리턴

    // 반복해서 나누고 출력하도록 재귀함수 사용
    DFS(n / 2);
    // 역순으로 적기 위하여 재귀함수 뒤에 출력
    System.out.print(n % 2);
  }
}
