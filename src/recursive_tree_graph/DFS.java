package recursive_tree_graph;

/*

문제
1~7까지 입력된 이진트리를 전위, 중위, 후위 순회를 출력해보시오

출력
전위, 중위, 후위 순회를 출력합니다.

*/

// 이진 트리의 노드 클래스
class Node {
  int data;
  Node lt, rt;

  public Node(int val) {
    data = val;
    lt = rt = null;
  }
}

public class DFS {
  Node root;

  public static void main(String[] args) {
    DFS tree = new DFS();

    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    tree.root.rt.lt = new Node(6);
    tree.root.rt.rt = new Node(7);

    System.out.print("전위 순회 : ");
    tree.pre(tree.root);
    System.out.println();

    System.out.print("중위 순회 : ");
    tree.in(tree.root);
    System.out.println();

    System.out.print("후위 순회 : ");
    tree.post(tree.root);
    System.out.println();
  }

  // 전위 순회 메서드
  public void pre(Node root) {
    if (root == null) return;
    else {
      System.out.print(root.data + " ");
      pre(root.lt);
      pre(root.rt);
    }
  }
  // 중위 순회 메서드
  public void in(Node root) {
    if (root == null) return;
    else {
      in(root.lt);
      System.out.print(root.data + " ");
      in(root.rt);
    }
  }
  // 후위 순회 메서드
  public void post(Node root) {
    if (root == null) return;
    else {
      post(root.lt);
      post(root.rt);
      System.out.print(root.data + " ");
    }
  }
}
