package recursive_tree_graph;

/*

문제
넓이 우선 탐색 이진트리 순회 코드짜기

출력
1~7까지 입력된 레벨 탐색 순회를 출력합니다

*/

import java.util.LinkedList;
import java.util.Queue;

// 이진 트리의 노드 클래스
/*
class Node {
  int data;
  Node lt, rt;

  public Node(int val) {
    data = val;
    lt = rt = null;
  }
}
*/

public class BFS {
  Node root;

  public static void main(String[] args) {
    BFS tree = new BFS();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    tree.root.rt.lt = new Node(6);
    tree.root.rt.rt = new Node(7);
    tree.BFS(tree.root);
  }

  // 넓이 우선 탐색(레벨 탐색) 이진트리 순회
  public void BFS(Node root) {
    Queue<Node> Q = new LinkedList<>();
    Q.offer(root);
    int L = 0;

    while (!Q.isEmpty()) {
      int len = Q.size(); // 현재 큐의 사이즈
      System.out.print("레벨 " + L + " : ");

      // 현재 노드의 값을 출력하고 자식 노드를 큐에 삽입하는 반복문
      // 같은 레벨의 노드들을 모두 출력하고 다음 레벨로 넘어감
      for (int i = 0; i < len; i++) {
        // 하나씩 꺼내고 출력
        Node cur = Q.poll();
        System.out.print(cur.data + " ");
        // 현재 노드의 값을 출력해주고 자식 노드가 있다면 큐에 넣어준다
        if (cur.lt != null) Q.offer(cur.lt);
        if (cur.rt != null) Q.offer(cur.rt);
      }
      L++; // 다음 레벨을 저장
      System.out.println();
    }

  }
}
