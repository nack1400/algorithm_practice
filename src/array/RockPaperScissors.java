package array;

/*
설명
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


출력
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class RockPaperScissors {
  public static void main(String[] args) {
    RockPaperScissors T = new RockPaperScissors();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    int[] arr2 = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    for (int i = 0; i < n; i++) {
      arr2[i] = kb.nextInt();
    }
    for (int x : T.solution(arr, arr2, n)) {
      System.out.println((char)x);
    }
  }

  // 해결방법
  // 두 개의 배열을 입력받고 가위바위보 경우에 수에 따라 새로운 배열에 결과 값 입력
  // 비기는 경우, 이기는 경우, 지는 경우 순으로 조건문 구성
  public ArrayList<Character> solution(int[] arr, int[] arr2, int n) {
    ArrayList<Character> answer = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (arr[i] == arr2[i]) answer.add('D');
      else if (arr[i] == 1 && arr2[i] == 3) answer.add('A');
      else if (arr[i] == 2 && arr2[i] == 1) answer.add('A');
      else if (arr[i] == 3 && arr2[i] == 2) answer.add('A');
      else answer.add('B');
    }
    return answer;
  }
}
