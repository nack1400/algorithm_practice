package recursive_tree_graph;

/*

문제
Tree 말단 노드까지의 가장 짧은 경로
이진트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짧은 길이를 구하시오.
각 경로의 길이는 간선의 개수로 한다.

출력
말단 노드까지의 길이 중 가장 짧은 길이를 출력한다.

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

public class Tree_BFS {
  Node root;

  public static void main(String[] args) {
    Tree_BFS tree = new Tree_BFS();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    System.out.println(tree.BFS(tree.root));
  }

  // BFS 최단 거리 알고리즘
  public int BFS(Node root) {
    Queue<Node> Q = new LinkedList<>();
    Q.offer(root);
    int L = 0; // 노드 레벨, 루트 노드로부터의 거리
    while(!Q.isEmpty()){
      int len = Q.size(); // 현재 레벨에 있는 노드의 수
      for(int i = 0; i<len; i++){
        Node cur = Q.poll(); // 노드를 하나씩 빼서 검사
        if(cur.lt == null && cur.rt == null) return L; // 자식 노드가 없다면 말단 노드이므로 현재 거리를 출력
        // 자식 노드가 있다면 큐에 저장하고 다음 레벨에서 검사
        if(cur.lt != null) Q.offer(cur.lt);
        if(cur.rt != null) Q.offer(cur.rt);
      }
      L++;
    }
    return 0;
  }
}
