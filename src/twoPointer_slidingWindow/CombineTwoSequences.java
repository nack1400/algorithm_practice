package twoPointer_slidingWindow;

/*

설명
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

출력
오름차순으로 정렬된 배열을 출력합니다.

*/

import java.util.ArrayList;
import java.util.Scanner;

public class CombineTwoSequences {
  public static void main(String[] args) {
    CombineTwoSequences T = new CombineTwoSequences();
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
  // 두 개의 배열에서 앞에서 부터 차례대로 값을 비교
  // 비교한 값 중 작은 값을 넣고 넣어진 배열은 다음 것으로 비교
  // 다 비교 후 나머지를 배열에 그대로 입력
  public ArrayList<Integer> solution(int[] arr1, int[] arr2, int n, int m) {
    ArrayList<Integer> answer = new ArrayList<>();
    int p1=0, p2=0; // 비교할 위치
    while(p1<n && p2<m){ // 배열 한쪽이 끝까지 갈때까지 비교 후 입력
      if(arr1[p1]<arr2[p2]) answer.add(arr1[p1++]);
      else answer.add(arr2[p2++]);
    }
    // 두 배열 중 하나가 모두 입력 되었을 경우 나머지를 입력
    while(p1<n) answer.add(arr1[p1++]);
    while(p2<m) answer.add(arr2[p2++]);
    return answer;
  }
}
