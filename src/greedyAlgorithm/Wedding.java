package greedyAlgorithm;

/*

설명
현수는 다음 달에 결혼을 합니다.
현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.

입력
첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.
두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.
시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.

출력
첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time2 implements Comparable<Time2> {
  public int time;
  public char state;

  Time2(int time, char state) {
    this.time = time;
    this.state = state;
  }

  @Override
  public int compareTo(Time2 ob) { // 시간을 오름차순으로 정렬하고 시간이 같을시 가는 시간 우선으로 정렬
    if (this.time == ob.time) return this.state - ob.state;
    else return this.time - ob.time;
  }
}

public class Wedding {
  public static void main(String[] args) {
    Wedding T = new Wedding();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    ArrayList<Time2> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int sT = kb.nextInt();
      int eT = kb.nextInt();
      arr.add(new Time2(sT, 's'));
      arr.add(new Time2(eT, 'e'));
    }
    System.out.println(T.solution(arr));
  }

  // 해결방안
  // 먼저 각 사람의 오는 시간과 가는 시간을 받는다
  // 이때 오는 시간과 가는 시간을 구분해서 따로 받는다
  // 받은 정보를 시간 순서에 따라 오름차순 정렬을 한다
  // 정렬된 정보를 오름차순으로 확인하며 그 시간대에 들어오는 사람이면 +, 나가는 사람이면 -를 한다
  // 이때 가는 시간에는 사람이 없다고 가정하므로 정렬시 가는 시간이 먼저 오도록 정렬된 상태에서 실행한다
  // answer을 가장 큰 경우로 업데이트 해주며 마지막까지 돌고 난 뒤 answer을 리턴한다
  public int solution(ArrayList<Time2> arr) {
    int answer = Integer.MIN_VALUE; // 가장 작은 수를 넣어주고
    Collections.sort(arr); // 배열리스트를 정렬, 오름차순에 가는 시간 우선으로
    int cnt = 0;
    for (Time2 ob : arr) {
      if (ob.state == 's') cnt++; // 들어오는 시간이면 +
      else cnt--; // 나가는 시간이면 -
      answer = Math.max(answer, cnt); // 더 커졌다면 교체
    }
    return answer;
  }
}
