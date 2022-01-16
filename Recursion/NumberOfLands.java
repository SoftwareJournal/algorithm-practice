package Recursion;

class NumberOfLands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int lands = 0;
        boolean[][] visited = new boolean[m][n];   
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    findAdjacentLands(grid, visited,i,j);
                    lands++;
                }
            }
        }
        
        return lands;
    }
    
    private void findAdjacentLands(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0'){
            return;
        }
        
        visited[i][j] = true; //visited this node
        findAdjacentLands(grid, visited, i-1, j); //top
        findAdjacentLands(grid, visited, i, j-1); //left
        findAdjacentLands(grid, visited, i, j+1); //right
        findAdjacentLands(grid, visited, i+1, j); //bottom
    }
    
}