package hashMap;

/*

설명
Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.

입력
첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
단어의 길이는 100을 넘지 않습니다.

출력
두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.

*/

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
  public static void main(String[] args) {
    Anagram T = new Anagram();
    Scanner kb = new Scanner(System.in);
    String str1 = kb.next();
    String str2 = kb.next();
    System.out.println(T.solution(str1, str2));
  }

  // 해결방법
  // 받은 첫번째 문자열을 hashmap에 문자별 개수를 입력한다
  // 입력된 map의 값에서 두번째 문자열을 하나씩 검사한다
  // 이때 값이 존재하면 -1을 해주고, 0이거나 문자가 없으면 NO를 리턴한다
  // 반복문을 완전히 다 돌았다면 YES를 리턴
  public String solution(String str1, String str2) {
    String answer = "YES";

    HashMap<Character, Integer> map = new HashMap<>();
    // hashmap에 문자열 key, value 대입
    for (char x : str1.toCharArray()) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    // 두번째 문자열의 문자를 돌며 같은 조합인지 확인
    for (char x : str2.toCharArray()) {
      // 문자가 없거나 0보다 작다면(문자 수가 더 많다면) NO를 리턴
      if(!map.containsKey(x) || map.get(x)==0) return "NO";
      // 있다면 하나씩 빼줌
      map.put(x, map.get(x) - 1);
    }

    return answer;
  }

}
