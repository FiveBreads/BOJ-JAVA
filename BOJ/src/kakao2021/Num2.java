package kakao2021;

public class Num2 {
  boolean[][] board;
  int[] xMove = {-1, 1, 0, 0};
  int[] yMove = {0, 0, -1, 1};

  public int dfs (int outerLoop, int x, int y, int depth, String[][] places) {
    if(depth > 2 || board[y][x] || places[outerLoop][y].charAt(x) == 'X') return 1;
    else if(places[outerLoop][y].charAt(x) == 'P') return 0;
    board[y][x] = true;
    for(int moveLoop = 0; moveLoop < 4; moveLoop++){
      y += yMove[moveLoop];
      x += xMove[moveLoop];
      if (x > 4 || x < 0 || y > 4 || y < 0) continue;
      int res = dfs(outerLoop, x, y, depth+1, places);
      if (res == 0) {
        board[y][x] = false;
        return 0;
      }
    }
    board[y][x] = false;
    return 1;
  }

  public int[] solution(String[][] places) {
    int[] answer = new int[5];
    for (int outerLoop = 0; outerLoop < 5; outerLoop++) {
      boolean isTeemo = false;
      board = new boolean[5][5];
      for (int roomYLoop = 0; roomYLoop < 5; roomYLoop++) {
        if (isTeemo) break;
        for (int roomXLoop = 0; roomXLoop < 5; roomXLoop++){
          if (isTeemo) break;
          if (places[outerLoop][roomYLoop].charAt(roomXLoop) == 'P'){
            board[roomYLoop][roomXLoop] = true;
            for(int moveLoop = 0; moveLoop < 4; moveLoop++){
              if (isTeemo) break;
              int y = roomYLoop + yMove[moveLoop];
              int x = roomXLoop + xMove[moveLoop];
              if (x > 4 || x < 0 || y > 4 || y < 0) continue;
              int res = dfs(outerLoop, x,y,1, places);
              if (res == 0) {
                isTeemo = true;
                break;
              }
            }
            board[roomYLoop][roomXLoop] = false;
          }
        }
      }
      if (isTeemo){
        answer[outerLoop] = 0;
      }else {
        answer[outerLoop] = 1;
      }
    }
    return answer;
  }

  public static void main(String[] args){
    String[][] places = {
        {
          "POOOP",
          "OXXOX",
          "OPXPX",
          "OOXOX",
          "POXXP"
        },
        {
          "POOPX",
          "OXPXP",
          "PXXXO",
          "OXXXO",
          "OOOPP"
        },
        {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
    };
    Num2 num2 = new Num2();
    int[] res = num2.solution(places);
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i]);
    }
  }
}
