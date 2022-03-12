package string;

/*
설명
N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.

입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.

출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class WordFlip {
  public static void main(String[] args) {
    WordFlip T = new WordFlip();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt(); //배열의 크기를 입력받기
    String[] str = new String[n]; //받은 크기만큼 동적으로 배열 생성
    for (int i = 0; i < n; i++) { //str배열을 돌며 단어 입력받기
      str[i] = kb.next();
    }
    for (String s : T.solution(n, str)) { //리버스 시키는 메서드에 넣어 출력
      System.out.println(s);
    }
  }

  //해결방법
  //StringBuilder의 reverse 메서드를 이용하자
  public ArrayList<String> solution(int n, String[] str) {
    ArrayList<String> answer = new ArrayList<>();
    for (String s : str) {
      String tmp = new StringBuilder(s).reverse().toString(); //단어를 리버스시키고 스트링화 시키서 리턴
      answer.add(tmp); //리버스 시킨 단어를 answer 배열리스트에 하나씩 저장
    }
    return answer;

    /*
    //reverse 쓰지 않고 직접 구현
    ArrayList<String> answer = new ArrayList<>();
    for (String x : str) {
      char[] s = x.toCharArray();
      int lt = 0, rt = x.length() - 1;
      while (lt < rt) {
        char tmp = s[lt];
        s[lt] = s[rt];
        s[rt] = tmp;
        lt++;
        rt--;
      }
      String tmp = String.valueOf(s);
      answer.add(tmp);
    }
    return answer;
    */

  }
}
