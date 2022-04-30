package sorting_searching;

/*

설명
N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.

입력
첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.

출력
첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.

*/

import java.util.Arrays;
import java.util.Scanner;

public class DecidingStable {
  public static void main(String[] args) {
    DecidingStable T = new DecidingStable();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
    System.out.println(T.solution(n, m, arr));
  }

  // 해결방법
  // 결정 트리 알고리즘
  // 마굿간의 좌표를 오름차순 정렬 후 가능한 거리의 최소값과 최대값을 설정
  // 최소값과 최대값의 가운데 값이 말 사이의 거리의 가장 작은 값으로 가능한지 확인
  // 가능하다면 왼쪽을 날려서 더 큰 값을 찾고
  // 아니라면 오른쪽을 날려서 가능한 더 작은 값을 찾는다
  // 두 지점이 교차할 때까지 반복
  public int solution(int n, int m, int[] arr) {
    int answer = 0;

    Arrays.sort(arr); // 마굿간의 좌표를 정렬
    int left = 1, right = arr[n - 1]; // 거리의 최소값은 1, 최대값은 가장 마지막 좌표보다 작음

    while (left <= right) {
      int mid = (left + right) / 2;
      if (count(mid, arr) >= m) { // 배치가능한 말의 수가 m보다 많다면 mid는 값의 후보가 될 수 있음
        answer = mid;
        left = mid + 1; // 더 큰 쪽에서도 가능한 값이 있는지 찾아보자
      } else right = mid - 1; // 아니라면 더 작은 쪽에서 값을 찾아보자
    }

    return answer;
  }

  // mid의 값이 말 사이의 거리의 최솟값일때 배치 가능한 말의 수
  public int count(int mid, int[] arr) {
    int cnt = 1; // 현재 배치된 말의 수
    int pre = arr[0]; // 가장 최근에 배치된 말의 위치
    // 좌표마다 말이 배치 가능한지 검사
    for (int x : arr) {
      if ((x - pre) >= mid) { // mid값보다 먼 거리에 배치되어있다면 배치하고 카운트 해준 후 최근 값 변경
        pre = x;
        cnt++;
      }
    }
    return cnt;
  }

}
