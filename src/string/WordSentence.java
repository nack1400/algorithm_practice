package string;

import java.util.Scanner;

/*
설명
한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
문장속의 각 단어는 공백으로 구분됩니다.

입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다.
문장은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 가장 긴 단어를 출력한다.
가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
*/

public class WordSentence {
  public static void main(String[] args) {
    WordSentence T = new WordSentence();
    Scanner kb = new Scanner(System.in);
    String str = kb.nextLine();
    System.out.println(T.solution(str));
  }

  //해결방법
  //받은 문자열을 배열에 띄어쓰기 단위로 나누어 주자
  //배열을 반복문을 사용해서 더 긴 길이의 단어가 나올 경우 리턴 값을 변경해준다
  public String solution(String str) {
    String answer = "";
    int m = Integer.MIN_VALUE;
    int pos;

    //split을 사용하는 방법
    String[] s = str.split(" "); //입력받은 문자열을 나누어 배열에 저장
    for (String x : s) { //더 긴 단어가 나올때마다 answer에 저장
      int len = x.length();
      if (len > m) { //같을때는 실행하지 않음으로 길이가 같을 경우 앞쪽에 있는 것을 답으로 함
        m = len;
        answer = x;
      }
    }

    //indexOf와 substring을 사용하는 방법
    while ((pos = str.indexOf(' ')) != -1) {
      String tmp = str.substring(0, pos); //문자열 처음부터 다음 띄어쓰기까지 잘라내기
      int len = tmp.length(); //잘라낸 길이를 저장
      if (len > m) { //잘라낸 길이가 기존보다 크다면 저장
        m = len;
        answer = tmp;
      }
      str = str.substring(pos+1); //다음 단계로 넘어가기 위해 띄어쓰기 다음부터 끝까지 저장
    }

    return answer;
  }
}
