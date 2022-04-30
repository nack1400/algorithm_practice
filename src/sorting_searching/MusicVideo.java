package sorting_searching;

/*

설명
지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.

입력
첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.

출력
첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.

*/

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {
  public static void main(String[] args) {
    MusicVideo T = new MusicVideo();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
    System.out.println(T.solution(n, m, arr));
  }

  // 해결방법
  // 결정 트리 알고리즘
  // dvd의 용량이 될 수 있는 최소값과 최대값을 설정
  // 가운데 값을 검사하여 그 용량으로 조건을 만족하는 지 확인
  // 만족한다면 보다 큰 값들을 날리고, 그렇지 않다면 보다 작은 값들을 날려서 그 다음 중간값을 검사
  // 양쪽값이 교차할때까지 검사하여 가능한 최소용량을 저장하여 리턴
  public int solution(int n, int m, int[] arr) {
    int answer = 0;
    // 곡의 길이 중 가장 큰 값, 한 dvd에 한 곡만 들어가는 상황이 한개의 최소 크기
    int left = Arrays.stream(arr).max().getAsInt();
    // 곡의 길이를 모두 합한 값, 한 dvd에 모든 곡이 들어가는 상황이 한개의 최대 크기
    int right = Arrays.stream(arr).sum();
    // 검사하는 왼쪽 끝과 오른 쪽이 만나 교차할 때까지 반복
    while (left <= right) {
      int mid = (left + right) / 2; // 중간값 계산
      // dvd의 개수가 m개보다 많이 필요한지 적게 필요한지 확인
      if (count(arr, mid) <= m) { // 충분히 넣을 수 있다면 mid를 answer로 저장하고 큰 값들을 날리고 다시 검사
        answer = mid;
        right = mid - 1;
      } else left = mid + 1; // 충분히 넣을 수 없다면 작은 값들을 날리고 다시 검사
    }
    return answer;
  }

  // dvd의 크기가 capacity일때 모든 곡을 넣기 위해 필요한 dvd의 수
  public int count(int[] arr, int capacity) {
    int cnt = 1, sum = 0;
    for (int x : arr) {
      if (sum + x > capacity) { // 용량보다 커지면 다음 dvd로 넘어감
        cnt++;
        sum =x;
      }else sum+=x; // 용량이 아직 남아있다면 현재 dvd에 더 넣어줌
    }
    return cnt;
  }
}
