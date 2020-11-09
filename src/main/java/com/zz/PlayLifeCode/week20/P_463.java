package com.zz.PlayLifeCode.week20;

/**
 * https://leetcode-cn.com/problems/island-perimeter/
 * DFS or 遍历
 *
 */
public class P_463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int x[] = new int[]{-1,0,1,0};
        int y[] = new int[]{0,1,0,-1};
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if (grid[i][j] == 1){
                    for(int l = 0;l<4;l++){
                        int xx = i+x[l],yy = j+y[l];
                        if(xx<0 || xx>=grid.length || yy<0 || yy>=grid[0].length){
                            ans++;
                        }else if(grid[xx][yy] != 1){
                            ans++;
                        }
                    }

                }
            }
        }
        return ans;
    }
}
