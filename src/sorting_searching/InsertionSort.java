package sorting_searching;

import java.util.Scanner;

public class InsertionSort {
  public static void main(String[] args) {
    InsertionSort T = new InsertionSort();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
    for (int x : T.solution(n, arr)) System.out.print(x + " ");
  }

  // 해결방법
  // 기본적인 삽입정렬 알고리즘
  // 첫번째 값이 정렬이 되어있다고 가정
  // 두번째 값에서 왼쪽으로 비교, 작다면 바꾸고 크다면 교환 -> 2번째까지 정렬
  // 세번째 값에서 왼쪽으로 한칸씩 비교, 작다면 바꾸고 크다면 교환 -> 3번째까지 정렬
  // 위의 과정을 반복하여 배열 전체가 정렬되도록
  public int[] solution(int n, int[] arr) {
    for (int i = 1; i < n; i++) {
      int tmp = arr[i], j; // tmp에 현재 값 저장, 값 변경을 위해 j 밖에 선언
      for (j = i; j > 0; j--) {
        // 바로 앞의 값과 비교하여 바로 앞의 값이 더 크다면 현재 값과 바꿔주고
        if (arr[j - 1] > tmp) arr[j] = arr[j - 1];
        // 아니라면 반복문 탈출
        else break;
      }
      // 반복문이 끝나고 들어가야 할 위치에 삽입
      arr[j] = tmp;
    }
    return arr;
  }
}
