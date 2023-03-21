import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] board) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        
        int answer = -1;
        String str = board[0];
        char[][] map = new char[board.length][str.length()];
        boolean[][] visited = new boolean[board.length][str.length()];
        int x=0, y = 0;
        for (int i =0; i<board.length; i++) {
            String s = board[i];
            for (int j=0; j<s.length(); j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'R')
                {x=i; y=j;}
            }
        }
        
        Queue<Point> q = new LinkedList<>();
        
        q.add(new Point(x,y,0));
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Point p = q.poll();

            if (map[p.x][p.y] == 'G')
                return p.depth;
            
            for (int i=0; i<4; i++) {
                int dr = p.x + dx[i];
                int dc = p.y + dy[i];
                
                if (isOut(dr, dc, map) || visited[dr][dc] || map[dr][dc] =='D')
                    continue;
                
                while (true) {
                    if (isOut(dr+dx[i],dc+dy[i], map) || map[dr+dx[i]][dc+dy[i]] == 'D'){
                        if (!visited[dr][dc]){
                        q.add(new Point(dr,dc, p.depth+1));
                        visited[dr][dc] = true;}
                        break;
                    }
                    else
                    {dr = dr+dx[i];
                    dc = dc+dy[i];
                    }
                }
                
            }

        }
        
        return answer;
    }
    
    public boolean isOut (int x, int y, char[][] map) {
        if (x <0 || y <0 || x >= map.length || y >= map[0].length)
            return true;
        return false;
    }
    
    class Point {
        int x;
        int y;
        int depth;
        Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}