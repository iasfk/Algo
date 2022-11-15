import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    public int solution(int[][] maps) {
        map = maps;
        visited = new boolean[maps.length][maps[0].length];
        return bfs();
    }
    
    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new Node(0,0,1));
        while (!q.isEmpty()){
            Node nd = q.poll();
            
            for (int i =0; i < 4; i++){
                
            int dr = dx[i] + nd.x;
            int dc = dy[i] + nd.y;
                
            if (dr <0 || dc < 0 || dr>= map.length || dc>= map[0].length|| visited[dr][dc] || map[dr][dc] == 0)
                continue;
            if (dr == map.length-1 && dc == map[0].length-1)
                return nd.depth+1;
                
            visited[dr][dc] = true;
            Node ne = new Node(dr, dc, nd.depth+1);
            q.add(ne);
            }  
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    int depth;
    
    Node(int x, int y, int depth){
        this.x =x;
        this.y =y;
        this.depth = depth;
    }
}