package array;

/*

설명
현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.

출력
첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.

*/

import java.util.Scanner;

public class Mentoring {
  public static void main(String[] args) {
    Mentoring T = new Mentoring();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    int[][] arr = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = kb.nextInt();
      }
    }
    System.out.println(T.solution(arr, n, m));
  }

  // 해결방법
  // 먼저 멘토, 멘티로 짝지을 수 있는 모든 경우의 수를 체크
  // 짝지은 멘토, 멘티에서 조건에 만족하는 지 체크
  // 멘토, 멘티의 등수를 찾고 모든 테스트에서 멘토가 앞선다면 카운트
  public int solution(int[][] arr, int n, int m) {
    int answer = 0;
    for (int i = 1; i <= n; i++) { // 모든 경우의 수를 위한 반복문
      for (int j = 1; j <= n; j++) { // 모든 경우의 수를 위한 반복문
        int cnt = 0;
        // (멘토, 멘티) 모든 경우의 수에서 조건에 만족하는 것을 체크
        for (int k = 0; k < m; k++) { // 각 테스트에서 등수 비교
          int pi = 0, pj = 0; // 각 학생의 등수를 저장
          for (int s = 0; s < n; s++) { // 등수를 찾기 위한 반복문
            if (arr[k][s] == i) pi = s; // 멘토의 등수 찾기
            if (arr[k][s] == j) pj = s; // 멘티의 등수 찾기
          }
          if (pi < pj) cnt++; // 등수가 앞서는 경우
        }
        if (cnt == m) { // 모든 경우에 등수가 앞선다면
          answer++;
        }
      }
    }
    return answer;
  }
}
