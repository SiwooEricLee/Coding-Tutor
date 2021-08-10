class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public void dfs(char[][] grid, int r, int c) {
        //set m to number of rows and n to number of columns 
        int m = grid.length;
        int n = grid[0].length;
        //in-bounds check
        if(r < 0 || c < 0 || r >= m || c >= n) {
            return;
        }
        
        //return if water
        if(grid[r][c] == '0') {
            return;
        }
        
        //if grid[r][c] is land, set to water
        grid[r][c] = '0';
        
        //check all surrounding elements
        for(int i = 0; i < 4; i++) {
            dfs(grid, r + dr[i], c + dc[i]);
        }
    }   
        
    public int numIslands(char[][] grid) {
        //set m to number of rows and n to number of columns 
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        //go through each element in the grid
        for(int i = 0; i < m; i++) {
            //could also replace m with grid.length
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    //add one to count
                    cnt++;
                    //check the tile
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
}