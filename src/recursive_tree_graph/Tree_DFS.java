package recursive_tree_graph;

/*

문제
Tree 말단 노드까지의 가장 짧은 경로
이진트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짧은 길이를 구하시오.
각 경로의 길이는 간선의 개수로 한다.

출력
말단 노드까지의 길이 중 가장 짧은 길이를 출력한다.

*/


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

public class Tree_DFS {
  Node root;

  public static void main(String[] args) {
    Tree_DFS tree = new Tree_DFS();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    System.out.println(tree.DFS(0, tree.root));
  }

  // DFS 최단 거리 알고리즘
  public int DFS(int L, Node root) {
    // 자식 노드가 없는 노드까지의 거리 중 가장 짧은 거리를 리턴
    if (root.lt == null && root.rt == null) return L; // 만약 자식 노드가 없다면 리턴
    else return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt)); // 자식 노드 중 작은 값을 리턴

  }
}
