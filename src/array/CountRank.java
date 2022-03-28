package array;

/*
설명
N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

입력
첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.

출력
입력된 순서대로 등수를 출력한다.
*/

import java.util.Scanner;

public class CountRank {
  public static void main(String[] args) {
    CountRank T = new CountRank();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    for (int x : T.solution(n, arr)) {
      System.out.print(x + " ");
    }
  }

  // 해결방법
  // 받은 배열의 크기 만큼 새로운 배열 생성
  // 받은 배열을 한번씩 돌며 자신보다 큰 값이 있을 때 등수를 1씩 증가
  // 모든 값의 등수를 구한 배열을 출력
  public int[] solution(int n, int[] arr) {
    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      int cnt = 1;
      for (int j = 0; j < n; j++) { // j번째 값의 등수 구하기
        if (arr[j] > arr[i]) cnt++; // 큰 값이 나올때마다 등수 올려주기
      }
      answer[i] = cnt; // 등수 저장
    }
    return answer;
  }
}
