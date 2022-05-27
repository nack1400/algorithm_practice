package dfs_bfs;

/*

설명
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.

1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

만약 위와 같다면 섬의 개수는 5개입니다.

입력
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 격자판 정보가 주어진다.


출력
첫 번째 줄에 섬의 개수를 출력한다.

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
class Point {
  public int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
*/

public class Island_BFS {
  static int answer = 0, n;
  static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
  static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
  Queue<Point> queue = new LinkedList<>();

  public static void main(String[] args) {
    Island_BFS T = new Island_BFS();
    Scanner kb = new Scanner(System.in);

    n = kb.nextInt();
    int arr[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = kb.nextInt();
      }
    }
    T.solution(arr);
    System.out.println(answer);
  }

  // 찾은 섬을 0으로 바꿔주는 재귀 함수
  // board에서 1을 찾았을 때 인접한 1을 모두 0으로 바꿔줌
  public void BFS(int x, int y, int[][] board) {
    queue.add(new Point(x, y)); // 현재 위치 넣고
    while (!queue.isEmpty()) { // 큐가 비어 있지 않다면
      Point pos = queue.poll();
      for (int i = 0; i < 8; i++) {
        int nx = pos.x + dx[i];
        int ny = pos.y + dy[i];
        // 육지일때만 0으로 바꿔줌
        if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
          board[nx][ny] = 0;
          queue.add(new Point(nx, ny));
        }
      }
    }
  }

  // board를 탐색하며 1이 존재하는 지 찾음
  // 찾았다면 섬의 개수 answer을 +1을 하고 BFS를 돌려서 인접한 모든 1을 0으로 바꿔줌
  public void solution(int[][] board) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 1) { // 육지를 만나면
          answer++;
          board[i][j] = 0; // 지점을 0으로 만들어주고
          BFS(i, j, board); // 인접한 곳을 0으로 만들도록 재귀 함수
        }
      }
    }
  }
}