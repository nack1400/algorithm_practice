package dynamicProgramming;

/*

설명
밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.
아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.
(조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
(조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
(조건3) 벽돌들의 높이는 같을 수도 있다.
(조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
(조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.

입력
입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대 100개이다.
둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높이 그리고 무게가 차례대로 양의 정수로 주어진다.
각 벽돌은 입력되는 순서대로 1부터 연속적인 번호를 가진다. 벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.

출력
첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
  public int s, h, w;

  Brick(int s, int h, int w) {
    this.s = s;
    this.h = h;
    this.w = w;
  }

  @Override
  public int compareTo(Brick o) {
    return o.s - this.s;
  }
}

public class TallestTower {
  static int[] dy;

  public static void main(String[] args) {
    TallestTower T = new TallestTower();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    ArrayList<Brick> arr = new ArrayList<>();
    dy = new int[n];
    for (int i = 0; i < n; i++) {
      int a = kb.nextInt();
      int b = kb.nextInt();
      int c = kb.nextInt();
      arr.add(new Brick(a, b, c));
    }
    System.out.print(T.solution(arr));
  }

  // 해결방법
  // LIS 응용
  // 차례대로 쌓을 수 있도록 먼저 넓이의 내림차순으로 정렬하고 무게만 고려
  // 첫번째 벽돌의 높이를 최대 높이를 저장할 배열에 첫번째 항에 저장
  // 다음 벽돌부터 바로 밑에 쌓을 수 있는 벽돌들과 무게를 비교
  // 무게가 큰 것의 바로 위에만 쌓을 수 있으므로 가능한 벽돌 중 높이가 가장 높게 쌓이는 벽돌을 선택
  // 선택된 벽돌의 높이에서 자신의 높이를 더하면 자신이 꼭대기일 경우 쌓을 수 있는 가장 높은 높이
  // 만약 밑에 쌓을 수 있는 벽돌이 없다면 최대 높이는 자기 자신
  // 차례대로 마지막 벽돌까지 검사 후 가장 큰 값이 쌓을 수 있는 최대 높이
  public int solution(ArrayList<Brick> arr) {
    int answer = 0;
    Collections.sort(arr);
    dy[0] = arr.get(0).h; // 처음 벽돌 높이 입력
    answer = dy[0]; // 하나만 쌓은 경우로 처음 값 입력
    for (int i = 1; i < arr.size(); i++) { // 두번째 벽돌부터 차례대로 검사
      int max_h = 0; // 최대 높이 변수
      for (int j = i - 1; j >= 0; j--) { // 현재 벽돌보다 아래에 있을 수 있는 벽돌들을 검사
        // 무게가 더 크고 높이가 더 크다면 최대 높이를 변경
        if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
          max_h = dy[j];
        }
      }
      // 구한 높이를 현재 벽돌의 높이랑 더해주면 현재 벽돌이 꼭대기일 때 가능한 최대 높이
      dy[i] = max_h + arr.get(i).h;
      answer = Math.max(answer, dy[i]); // 더 큰 값으로 변경
    }
    return answer;
  }
}
