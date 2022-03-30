package array;

/*

설명
김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.

입력
첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
주어지는 정수는 모두 1 이상 9 이하의 정수이다.

출력
첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.

*/

import java.util.Scanner;

public class ChoosePresident {
  public static void main(String[] args) {
    ChoosePresident T = new ChoosePresident();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[][] arr = new int[n][5];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 5; j++) {
        arr[i][j] = kb.nextInt();
      }
    }
    System.out.println(T.solution(arr, n));
  }

  // 해결방법
  // 각 학생 별로 반복문을 돌려서 같은 값을 비교
  // 삼중 반복문을 사용하여 각 학생의 학년별, 학생별 중복 값 비교
  public int solution(int[][] arr, int n) {
    int answer = 0, max = 0;
    for (int i = 0; i < n; i++) { // 각 학생별로 반복
      int cnt = 0;
      for (int j = 0; j < n; j++) { // 선택된 학생과 다른 학생을 비교 반복
        for (int k = 0; k < 5; k++) { // 다른 학생과 학년별로 같은 경우가 있는지 확인
          // 비교시에 같은 경우가 있다면 카운트 후 break
          if (arr[i][k] == arr[j][k]){
            cnt++;
            break;
          }
        }
      }
      // 카운트했을때 더 클때만 바꾸어줌
      // 더 클때만 바꾸기에 같을 경우 먼저 비교한 학생의 번호가 저장됨
      if(cnt>max){
        max = cnt;
        answer = i + 1; // 0번부터 시작했으니 1 더해줌
      }
    }
    return answer;
  }
}
