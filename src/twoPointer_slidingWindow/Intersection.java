package twoPointer_slidingWindow;

/*

설명
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
각 집합의 원소는 1,000,000,000이하의 자연수입니다.

출력
두 집합의 공통원소를 오름차순 정렬하여 출력합니다.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Intersection {
  public static void main(String[] args) {
    Intersection T = new Intersection();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr1 = new int[n];
    for (int i = 0; i < n; i++) {
      arr1[i] = kb.nextInt();
    }
    int m = kb.nextInt();
    int[] arr2 = new int[m];
    for (int i = 0; i < m; i++) {
      arr2[i] = kb.nextInt();
    }
    for (int x : T.solution(arr1, arr2, n, m)) {
      System.out.print(x + " ");
    }
  }

  // 해결방법
  // 두 개의 배열을 정렬 시킴
  // 앞에서부터 차례대로 비교
  // 더 작은 값을 가진 배열의 인덱스를 증가, 같다면 값을 추가하고 둘 다 증가
  public ArrayList<Integer> solution(int[] arr1, int[] arr2, int n, int m) {
    ArrayList<Integer> answer = new ArrayList<>();

    // 두 배열 정렬시키기
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    int p1 = 0, p2 = 0; // 비교할 인덱스 값

    while (p1 < n && p2 < m) {
      // 더 작은 값을 가진 배열의 인덱스를 증가
      if (arr1[p1] > arr2[p2]) p2++;
      else if (arr1[p1] < arr2[p2]) p1++;
      else { // 같을 경우 리턴할 배열리스트에 추가
        answer.add(arr1[p1++]);
        p2++;
      }
    }

    return answer;
  }
}
