package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1068 {
  static TreeNode tree;
  static int cnt = 0;

  static void checkAndMakeTreeNode(TreeNode node, int parentData, int data){
    if (node.data == parentData) {
      if (node.left == null) node.left = new TreeNode(data);
      else node.right = new TreeNode(data);
    }
    if (node.left != null) checkAndMakeTreeNode(node.left, parentData, data);
    if (node.right != null) checkAndMakeTreeNode(node.right, parentData, data);
  }

  static boolean delChildNode(TreeNode node, int data){
    if (node.data == data) return true;
    if (node.left != null) {
      if (delChildNode(node.left, data)){
        node.left = null;
      }
    }
    if (node.right != null) {
      if (delChildNode(node.right, data)){
        node.right = null;
      }
    }
    return false;
  }

  static void getLeafNode(TreeNode node){
    boolean isLeaf = false;
    if (node.left != null) {
      isLeaf = true;
      getLeafNode(node.left);
    }
    if (node.right != null) {
      isLeaf = true;
      getLeafNode(node.right);
    }
    if (isLeaf){
      cnt++;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int i = 0;
    while (st.hasMoreTokens()){
      int parent = Integer.parseInt(st.nextToken());
      if (parent == -1) {
        tree = new TreeNode(i);
      }
      else {
        checkAndMakeTreeNode(tree, parent, i);
      }
      i++;
    }
    int targetIndex = Integer.parseInt(br.readLine());
    if(!delChildNode(tree, targetIndex)){
      getLeafNode(tree);
    }
    System.out.println(cnt);
  }
}
class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  public TreeNode(int data){
    this.data = data;
    left = null;
    right = null;
  }
}
