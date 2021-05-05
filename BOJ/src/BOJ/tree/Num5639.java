package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num5639 {

  static StringBuilder sb = new StringBuilder();
  static void postOrder(BTree tree){
    if (tree.left != null) postOrder(tree.left);
    if (tree.right != null) postOrder(tree.right);
    sb.append(tree.value + "\n");
  }

  static void preOrder(BTree tree){
    sb.append(tree.value + "\n");
    if (tree.left != null) postOrder(tree.left);
    if (tree.right != null) postOrder(tree.right);
  }

  static void inOrder(BTree tree){
    if (tree.left != null) postOrder(tree.left);
    sb.append(tree.value + "\n");
    if (tree.right != null) postOrder(tree.right);
  }

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BTree tree = new BTree(Integer.parseInt(br.readLine()));
    String str = "";
    while((str = br.readLine()) != null && (str.length() != 0)){
      tree = tree.createTree(tree, Integer.parseInt(str));
    }
    postOrder(tree);
    System.out.println(sb.toString());
  }
}

class BTree {
  int value;
  BTree left;
  BTree right;
  public BTree(){}
  public BTree(int value){
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public BTree createTree(BTree tree, int value){
    BTree child = null;
    if (tree == null) return new BTree(value); //빈트리일경우 생성후 리턴
    if (tree.value > value) {
      child = createTree(tree.left, value);
      tree.left = child;
    }else if (tree.value < value) {
      child = createTree(tree.right, value);
      tree.right = child;
    }
    return tree;
  }
}