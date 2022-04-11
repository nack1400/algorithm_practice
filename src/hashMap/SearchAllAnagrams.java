package hashMap;

/*

설명
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

*/

import java.util.HashMap;
import java.util.Scanner;

public class SearchAllAnagrams {
  public static void main(String[] args) {
    SearchAllAnagrams T = new SearchAllAnagrams();
    Scanner kb = new Scanner(System.in);
    String str1 = kb.next();
    String str2 = kb.next();
    System.out.println(T.solution(str1, str2));
  }

  // 해결방법
  // 앞에서 한 아나그램과 매출액 합치기
  // 문자열 두 개를 받아서 검사할 문자열 hashmap
  // 검사받을 문자열을 잘라서 hashmap
  // 두 개의 hashmap이 같은지 검사
  // 자른 문자열은 맨 앞의 것을 빼주고 다음 값을 더해서 마지막까지 반복
  public int solution(String str1, String str2) {
    int answer = 0;
    char[] arr1 = str1.toCharArray();
    char[] arr2 = str2.toCharArray();

    // str2을 key, value 로 맵핑시켜놓기
    HashMap<Character, Integer> s2 = new HashMap<>();
    for (int i = 0; i < str2.length(); i++) {
      s2.put(arr2[i], s2.getOrDefault(arr2[i], 0) + 1);
    }

    // str1의 첫번째 경우 대입
    HashMap<Character, Integer> s1 = new HashMap<>();
    for (int i = 0; i < str2.length(); i++) {
      s1.put(arr1[i], s1.getOrDefault(arr1[i], 0) + 1);
    }
    // 첫번째 확인
    if(s1.equals(s2)) answer++;

    for (int i = 0, j = str2.length(); j < str1.length(); i++, j++) {
      // 맨 앞의 값을 빼주고 다음 값을 더해서 다음 검사 문자 hashmap 만들기
      s1.put(arr1[j], s1.getOrDefault(arr1[j], 0) + 1);
      s1.put(arr1[i], s1.get(arr1[i]) - 1);
      // 빼준 값이 value가 0이 된다면 제거
      if (s1.get(arr1[i]) == 0) s1.remove(arr1[i]);
      // 같다면 개수 세기
      if(s1.equals(s2)) answer++;
    }


    return answer;
  }
}
