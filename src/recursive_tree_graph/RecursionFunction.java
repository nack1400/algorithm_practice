package recursive_tree_graph;

/*

문제
자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요

입력
첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.

출력
첫째 줄에 출력한다.

*/

public class RecursionFunction {
  public static void main(String[] args) {
    RecursionFunction T = new RecursionFunction();
    T.DFS(3);
  }

  // 재귀함수
  // 자신을 다시 호출
  // 0을 받을 때 바로 리턴
  public void DFS(int n){
    if(n==0) return; // 0일때 재귀종료

    // 재귀함수 실행
    DFS(n-1);

    // 스택 프레임, 실행되기 전에 재귀함수가 실행되어 스택처럼 작업이 쌓임
    // 그래서 역순으로 실행됨
    System.out.println(n);
  }
}
