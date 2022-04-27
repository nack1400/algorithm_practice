package sorting_searching;

/*

설명
N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

출력
N개의 좌표를 정렬하여 출력하세요.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 좌표를 정렬하는 인터페이스 클래스
class Point implements Comparable<Point> {
  public int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point o) {
    // 객체 o와 현재 클래스의 x,y 값을 비교하여 오름차순으로 정렬
    // this가 앞에 있고 o가 뒤에 있다고 생각했을때 오름차순이 된다고 가정하고 음수가 리턴되도록 하면 된다
    // 예) this.y = 1, o.y = 2 this가 더 작으므로 오름차순이 되려면 this.y - o.y를 리턴
    if (this.x == o.x) return this.y - o.y; // x값이 같다면 y값으로 오름차순 정렬
    else return this.x - o.x; // 같지 않다면 x값으로 오름차순 정렬
  }
}

public class CompareTo {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    ArrayList<Point> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int x = kb.nextInt();
      int y = kb.nextInt();
      arr.add(new Point(x, y)); // 객체 생성하여 삽입
    }
    Collections.sort(arr); // Comparable의 인터페이스를 호출하여 정렬
    for (Point o : arr) System.out.println(o.x + " " + o.y);
  }
}
