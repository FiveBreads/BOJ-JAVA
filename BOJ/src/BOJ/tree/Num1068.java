package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num1068 {
  static TreeNode[] tree;
  static int cnt = 0;
  static ArrayList<Integer> delList = new ArrayList<>();

  static void makeDeleteList(int targetIndex){
    delList.add(targetIndex);
    ArrayList<Integer> child = tree[targetIndex].getChild();
    for (int loop = 0; loop < child.size(); loop++) {
      makeDeleteList(child.get(loop));
    }
  }

  static void deleteNodes(){
    for (int loop = 0; loop < delList.size(); loop++) {
      int parentIndex = tree[delList.get(loop)].getParent();
      if (parentIndex == -1) {
        tree = null;
        break;
      }
      tree[parentIndex].deleteChild(delList.get(loop));
    }
  }

  static void getLeafNodeCount(int index){
    if (tree[index].getChild().size() == 0){
      cnt++;
      return;
    }
    for (int loop = 0; loop < tree[index].getChild().size(); loop++) {
      getLeafNodeCount(tree[index].getChild().get(loop));
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    tree = new TreeNode[n];

    String[] parents = br.readLine().split(" ");
    int del = Integer.parseInt(br.readLine());

    for (int loop = 0; loop < n; loop++) {
      tree[loop] = new TreeNode();
    }

    int root = 0;

    for (int loop = 0; loop < n; loop++) {
      int parent = Integer.parseInt(parents[loop]);
      tree[loop].setParent(parent);
      if (parent >= 0){
        tree[parent].setChild(loop);
      }else {
        root = loop;
      }
    }
    makeDeleteList(del);
    deleteNodes();
    if (tree != null){
      getLeafNodeCount(root);
    }
    System.out.println(cnt);
  }
}
class TreeNode {
  private int parent;
  private ArrayList<Integer> child = new ArrayList<>();

  public void deleteChild(int target){
    child.remove(child.indexOf(target));
  }

  public void setChild(int childNum){
    child.add(childNum);
  }

  public ArrayList<Integer> getChild(){
    return child;
  }

  public int getParent() {
    return parent;
  }

  public void setParent(int parent) {
    this.parent = parent;
  }
}
