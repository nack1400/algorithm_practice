package array;

/*

설명
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
0 0 0 0 0 0 0
0 5 3 7 2 3 0
0 3 7 1 6 1 0
0 7 2 5 3 4 0
0 4 3 6 4 1 0
0 8 7 3 5 2 0
0 0 0 0 0 0 0

입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)
두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

출력
봉우리의 개수를 출력하세요.

*/

import java.util.Scanner;

public class CountPeaks {
  public static void main(String[] args) {
    CountPeaks T = new CountPeaks();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[][] arr = new int[n + 2][n + 2];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        arr[i][j] = kb.nextInt();
      }
    }
    System.out.println(T.solution(arr, n));
  }

  // 해결방법
  // 주어진 배열에 제일 바깥쪽에 0으로만 이루어진 값들을 추가
  // 각각 값에 대하여 위, 아래, 왼, 오른쪽의 값보다 큰 값만 카운트
  public int solution(int[][] arr, int n) {
    int answer = 0;
    // 반복문 사용을 위한 좌표이동 상수
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        boolean flag = true; // 큰 값이 있는지 확인하는 변수
        for (int k = 0; k < 4; k++) {
          // 주변에 큰 값이 있다면 false로 바꾸고 바로 break
          if (arr[i][j] <= arr[i + dx[k]][j + dy[k]]) {
            flag = false;
            break;
          }
        }
        // 큰 값이 없는 경우 카운트
        if (flag == true) answer++;
      }
    }

    return answer;
  }
}
