package greedyAlgorithm;

/*

설명
한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.

입력
첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.

출력
첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.

*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
  public int s, e;

  Time(int s, int e) {
    this.s = s;
    this.e = e;
  }

  @Override
  public int compareTo(Time o) {
    if (this.e == o.e) return this.s - o.s; // 끝나는 시간이 같으면 시작시간으로 오름차순
    else return this.e - o.e; // 끝나는 시간으로 오름차순
  }
}

public class ConferenceRoomAssignment {
  public static void main(String[] args) {
    ConferenceRoomAssignment T = new ConferenceRoomAssignment();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    ArrayList<Time> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int x = kb.nextInt();
      int y = kb.nextInt();
      arr.add(new Time(x, y));
    }
    System.out.println(T.solution(arr, n));
  }

  // 해결방법
  // 회의의 끝나는 시간으로 먼저 오름차순 정렬
  // 가장 먼저 끝나는 회의를 하나 넣고
  // 그 다음번부터 그 전 회의의 끝나는 시간보다 시작시간이 같거나 큰 경우를 차례대로 체크
  // 끝 시간이 같은 경우도 있으므로 끝시간이 같은 경우는 시작시간으로 오름차순 정렬
  public int solution(ArrayList<Time> arr, int n) {
    int cnt = 0;
    Collections.sort(arr);
    int et = 0;
    for (Time ob : arr) { // 정렬된 회의를 하나씩 확인
      if (ob.s >= et) { // 이전 회의의 끝나는 시간보다 현재 시작시간이 큰 경유
        cnt++; // 회의 하나 추가하고
        et = ob.e; // 끝나는 시간 변경
      }
    }
    return cnt;
  }
}