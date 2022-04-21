package sorting_searching;

/*

설명
N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 선택정렬입니다.

입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

출력
오름차순으로 정렬된 수열을 출력합니다.

*/

import java.util.Scanner;

public class SelectionSort {
  public static void main(String[] args) {
    SelectionSort T = new SelectionSort();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
    for (int x : T.solution(n, arr)) System.out.print(x + " ");
  }

  // 해결방법
  // 기본적인 선택정렬 알고리즘
  // 전체 배열값에서 가장 작은 값을 찾아 첫번째와 바꿔준다
  // 첫번째를 제외한 전체 배열값에서 가장 작은 값을 두번째와 바꿔준다
  // 위의 과정을 마지막 이전 자리를 바꿔줄 때까지 반복
  public int[] solution(int n, int[] arr) {
    // 첫번째부터 차례대로 가장 작은 값을 찾아 넣는 반복문
    for (int i = 0; i < n - 1; i++) {
      int idx = i; // 바꿔줄 위치 인덱스
      // 가장 작은 값을 찾는 반복문
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[idx]) idx = j; // 더 작은 값으로 인덱스 바꿔줌
      }
      // 배열 값을 인덱스 위치의 값과 바꿔줌
      int tmp = arr[i];
      arr[i] = arr[idx];
      arr[idx] = tmp;
    }

    return arr;
  }
}
