import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, visited;
    public int solution(int[][] maps) {
        map = maps;
        visited = new int[maps.length][maps[0].length];
        bfs();
        return visited[maps.length-1][maps[0].length-1] == 0 ? -1 : visited[maps.length-1][maps[0].length-1]+1;
    }
    
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int[] position = q.poll();
            
            for (int i =0; i < 4; i++){
                
            int dr = dx[i] + position[0];
            int dc = dy[i] + position[1];
                
            if (dr <0 || dc < 0 || dr>= map.length || dc>= map[0].length)
                continue;
            
            if (visited[dr][dc] == 0 && map[dr][dc] == 1){
                visited[dr][dc] = visited[position[0]][position[1]] +1;
                q.add(new int[]{dr, dc});
            }
        }
            
        }

    }
}