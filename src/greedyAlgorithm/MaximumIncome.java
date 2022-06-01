package greedyAlgorithm;

/*

설명
현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.

입력
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.

출력
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
  public int money;
  public int time;

  Lecture(int money, int time) {
    this.money = money;
    this.time = time;
  }

  @Override
  public int compareTo(Lecture ob) { // 시간이 큰 값을 우선으로 정렬
    return ob.time - this.time;
  }
}

public class MaximumIncome {
  static int n, max = Integer.MIN_VALUE;

  public static void main(String[] args) {
    MaximumIncome T = new MaximumIncome();
    Scanner kb = new Scanner(System.in);
    n = kb.nextInt();
    ArrayList<Lecture> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int m = kb.nextInt();
      int d = kb.nextInt();
      arr.add(new Lecture(m, d));
      if (d > max) max = d;
    }
    System.out.println(T.solution(arr));
  }

  // 해결방안
  // 시간이 큰 값부터 검사, 시간이 큰 값은 작은 시간때도 할 수 있으므로
  // 배열 리스트에 입력값을 시간의 내림차순으로 정렬
  // 입력된 값을 시간이 큰 값부터 우선순위 큐에 집어넣고 다음 시간으로 넘어가기 전에 가장 큰 값을 선택
  // 그 다음 시간에서 우선순위 큐에 남아있는 값 중 가장 큰 값을 선택, 그 이전에 선택되지 않은 값이 크다면 선택 가능하도록
  // 마지막까지 반복하고 선택된 값의 합을 출력
  public int solution(ArrayList<Lecture> arr) {
    int answer = 0;
    // 큰 값을 우선순위로 저장하는 우선순위 큐
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    Collections.sort(arr);
    int j = 0;
    for (int i = max; i >= 1; i--) {
      for (; j < n; j++) {
        if (arr.get(j).time < i) break; // 꺼낼 값이 시간보다 작아진다면 break하고 다음 시간대로 넘어감
        pQ.offer(arr.get(j).money); // 시간이 같다면 우선순위 큐에 입력
      }
      if (!pQ.isEmpty()) answer += pQ.poll(); // 큐에 있는 값 중 가장 큰 값을 꺼내서 더해줌
    }
    return answer;
  }
}
