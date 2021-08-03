class Solution {
    public int maxAreaOfIsland(int[][] grid) {
     int ans = 0;

    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
          //goes through each element in the arrays
        ans = Math.max(ans, dfs(grid, i, j));
          //sets ans to the larger island between the previous largest and the new island that was checked
      }
    }
    return ans;   
    }
    
    //the below code is similar to last week's, since it returns the number of land tiles connected, so all the code above does is it compares the two numbers and returns the largest

  private int dfs(int[][] grid, int i, int j) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
        //checks for in-bounds
      return 0;
    }
    if (grid[i][j] != 1) {
        //if grid[i][j] isn't 1, then it has to be 0
      return 0;
    }
    
     //if the below runs, then the nummber at grid[i][j] is 0, so it sets the number to 0 (which would get caught in the if statement above)
    grid[i][j] = 0;

    //goes throuth all surrounding elements
    return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j)
             + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
  }
}