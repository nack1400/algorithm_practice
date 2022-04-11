package hashMap;

/*

설명

현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
각 구간별로 구하라고 했습니다.
만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
20 12 20 10 23 17 10
각 연속 4일간의 구간의 매출종류는
첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
매출액의 종류를 출력하는 프로그램을 작성하세요.

입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

출력
첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.

*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TypesOfSales {
  public static void main(String[] args) {
    TypesOfSales T = new TypesOfSales();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int k = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    for (int x : T.solution(n, k, arr)) {
      System.out.print(x + " ");
    }
  }

  // 해결방법
  // 먼저 0부터 k만큼 hashmap에 put
  // 첫번째 결과 추가
  // 두번째부터 앞의 값은 빼주고 뒤의 값은 더해주면서 검사
  // 이때 value의 값이 0이 되는 값을 remove 시킨다
  public ArrayList<Integer> solution(int n, int k, int[] arr) {
    ArrayList<Integer> answer = new ArrayList<>();
    int tmp = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    // 첫번째 매출액의 종류 put
    for (int i = tmp; i < k; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    // 첫번째 종류의 수 추가
    answer.add(map.size());

    // 두번째부터 마지막까지 반복
    while (k < n) {
      // 맨 앞은 빼주고 맨 뒤는 더해준다
      map.put(arr[k], map.getOrDefault(arr[k], 0) + 1);
      map.put(arr[tmp], map.get(arr[tmp]) - 1);
      // 빼준 값이 value가 0이 된다면 제거
      if (map.get(arr[tmp]) == 0) map.remove(arr[tmp]);
      // 종류의 수 추가
      answer.add(map.size());
      // 맨 앞과 맨 뒤의 위치 증가, 다음 번을 검사하기 위하여
      tmp++;
      k++;
    }
    return answer;
  }

}
