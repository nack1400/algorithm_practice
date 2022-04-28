package sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
  public static void main(String[] args) {
    BinarySearch T = new BinarySearch();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
    System.out.println(T.solution(n, m, arr));
  }

  // 해결방법
  // 기본적인 이분검색 알고리즘
  // 배열을 정렬
  // 첫번째와 마지막에 인덱스 변수를 설정
  // 두 인덱스의 가운데 값을 검사하여 찾을 값과 같다면 가운데 값을 리턴
  // 가운데 값이 크다면 마지막 값을 가운데 값으로 작다면 첫번째 값을 가운데 값+1으로 바꿔준다
  // 값을 찾을 때까지 반복
  public int solution(int n, int m, int[] arr) {
    int answer = 0;
    int left = 0, right = n - 1; // 검색 배열의 가장 왼쪽과 오른쪽 위치 변수
    // 이분검색을 위한 배열 정렬
    Arrays.sort(arr);

    while (true) {
      int mid = (left + right) / 2;
      if (arr[mid] == m) { // 가운데 값과 같다면 즉 찾았다면 값을 리턴
        answer = mid + 1;
        break;
      } else if (arr[mid] > m) right = mid; // 크다면 오른쪽을 날림
      else left = mid + 1; // 작다면 왼쪽을 날림
    }
    return answer;
  }
}
