package greedyAlgorithm;

/*

설명
현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.

입력
첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.
두 번째 줄부터 N명의 키와 몸무게 정보가 차례로 주어집니다.
각 선수의 키와 몸무게도 모두 다릅니다. 능력치 값은 1,000,000이하의 자연수입니다.

출력
첫째 줄에 씨름 선수로 뽑히는 최대 인원을 출력하세요.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body> {
  public int h, w;

  Body(int h, int w) {
    this.h = h;
    this.w = w;
  }

  @Override
  public int compareTo(Body o) { // 키를 기준으로 내림차순
    return o.h - this.h;
  }
}


public class Wrestling {
  public static void main(String[] args) {
    Wrestling T = new Wrestling();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    ArrayList<Body> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int h = kb.nextInt();
      int w = kb.nextInt();
      arr.add(new Body(h, w));
    }
    System.out.println(T.solution(arr, n));
  }

  // 해결방법
  // 키를 기준으로 내림차순으로 정렬
  // 정렬해놓은 상태에서 몸무게를 차례대로 비교
  // 제일 첫번째는 선수를 키가 가장 크므로 선택
  // 두번째부터는 몸무게를 체크하며 현재까지 나온 몸무게의 최대값보다 큰 경우에만 선택
  public int solution(ArrayList<Body> arr, int n) {
    int cnt = 0;
    Collections.sort(arr); // 키를 기준으로 내림차순 정렬
    int max = Integer.MIN_VALUE;
    for (Body ob : arr) {
      if (ob.w > max) { // 몸무게가 더 큰 값이 나올때 바꿔주고 카운트
        max = ob.w;
        cnt++;
      }
    }
    return cnt;
  }
}
