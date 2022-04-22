package sorting_searching;

/*

설명
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 버블정렬입니다.

입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

*/

import java.util.Scanner;

public class BubbleSort {
  public static void main(String[] args) {
    BubbleSort T = new BubbleSort();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
    for (int x : T.solution(n, arr)) System.out.print(x + " ");
  }

  // 해결방법
  // 기본적인 버블정렬 알고리즘
  // 첫번째 값과 두번쨰 값을 비교
  // 첫번째 값이 크다면 바꾸고 아니라면 그대로 둔다
  // 그 다음 두번째와 세번째 비교하고 이 과정을 반복하여 제일 마지막에 가장 큰 값이 오도록 한다
  // 다시 처음부터 위 과정을 반복하여 뒤에서 부터 큰 값으로 하나씩 정렬한다
  public int[] solution(int n, int[] arr) {
    // 맨 뒤에 가장 큰 값을 채우는 반복문
    for (int i = n-1; i > 0; i--) { // i는 가장 마지막에 비교할 값
      // j부터 i까지 비교하며 바꿔주기
      for (int j = 0; j < i; j++) {
        // 앞의 값이 더 크다면 교체
        if (arr[j] > arr[j+1]) {
          int tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }
      }
    }

    return arr;
  }
}
