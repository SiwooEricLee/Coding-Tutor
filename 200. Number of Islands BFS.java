class Solution {
    int m, n;
    int[] dr = {0, 0, -1, 1};
    int[] dc = {-1, 1, 0, 0};
    
    //custom class to store 2d-index
    class pair {
        int row, col;
        
        public pair(int a, int b) {
            this.row = a;
            this.col = b;
        }
    }
    
    public void bfs(char[][] grid, int r, int c) {
        //making a queue
        Queue<pair> q = new LinkedList<pair>();
        
        //add r,c to queue and set grid[r][c] to 0
        q.add(new pair(r, c));
        grid[r][c] = 0;
        
        //run bfs
        while(!q.isEmpty()) {
            //get current coords and remove from queue
            int i = q.peek().row;
            int j = q.peek().col;
            q.remove();
            
            //check neighbors and add to queue if in bounds and equal to one
            for(int k = 0; k < 4; k++) {
                int nextR = i + dr[k];
                int nextC = j + dc[k];
                
                if(0 <= nextR && nextR < m && 0 <= nextC && nextC < n) {
                    if(grid[nextR][nextC] == 1) {
                        //add to queue and set grid[nextR][nextC] to 0
                        q.add(new pair(nextR, nextC));
                        grid[nextR][nextC] = 0;
                    }
                }
            }
        }
    }
        
    public int numIslands(char[][] grid) {
        //set m to number of rows and n to number of columns 
        m = grid.length;
        n = grid[0].length;
        int cnt = 0;
        //go through each element in the grid
        for(int i = 0; i < m; i++) {
            //could also replace m with grid.length
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    //add one to count
                    cnt++;
                    //check the tile
                    bfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
}