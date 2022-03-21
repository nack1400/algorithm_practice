package array;

/*
설명
선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)

입력
첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.

출력
선생님이 볼 수 있는 최대학생수를 출력한다.
*/

import java.util.Scanner;

public class VisibleStudent {
  public static void main(String[] args) {
    VisibleStudent T = new VisibleStudent();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    System.out.println(T.solution(n, arr));
  }

  // 해결방법
  // 배열 첫번째부터 돌면서 새로 만나는 값이 커질때마다 변수에 저장
  // 변수에는 선생님이 볼 수 없는 최대 키가 저장됨
  // 그래서 그 값보다 큰 수가 나올때만 세어주고 큰 값을 저장
  public int solution(int n, int[] arr) {
    int answer = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        answer++;
        max = arr[i];
      }
    }
    return answer;
  }
}
