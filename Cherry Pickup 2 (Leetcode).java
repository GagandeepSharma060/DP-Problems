class Solution {

    public static int helper(int[][]grid , int n , int j1 , int j2 , int[][][] dp)
    {

            if(j1<0 || j1==grid[0].length || j2<0 || j2==grid[0].length )
            {
                return -1;
            }

            if(dp[n][j1][j2]!=0)
            {
                return dp[n][j1][j2];
            }

            if(n==grid.length-1)
            {

              return  (j1==j2)?(grid[n][j1]):(grid[n][j1]+grid[n][j2]);
            }

          int max=-1;
          int res= (j1==j2)?(grid[n][j1]):(grid[n][j1]+grid[n][j2]);

          for(int i=-1;i<2;i++ )
          {
              for(int j=-1;j<2;j++)
              max=Math.max(max,helper(grid,n+1,j1+i,j2+j,dp));
              
          }
           dp[n][j1][j2]=res;
          res+=max;
          dp[n][j1][j2]=res;
          return res;




    }
    public int cherryPickup(int[][] grid) {
        int dp[][][]= new int[grid.length][grid[0].length][grid[0].length];
        // int res = helper(grid , 0, 0 , grid[0].length-1 , dp);
        // return res;
        int n=dp.length;

        

            for(int j1=0;j1<grid[0].length;j1++)
            {
                for(int j2=0;j2<grid[0].length;j2++)
                {
                          dp[n-1][j1][j2]=((j1==j2)?(grid[n-1][j1]):(grid[n-1][j1]+grid[n-1][j2]));

                }
            }

            for(int i=n-2;i>=0;i--)
            {
                for(int a=0;a<grid[0].length;a++)
                {

                    for(int b=0;b<grid[0].length;b++)
                    {



                         int max=-1;
                            int res= (a==b)?(grid[i][a]):(grid[i][a]+grid[i][b]);

                            for(int j1=-1;j1<2;j1++ )
                            {
                                for(int j2=-1;j2<2;j2++){
                    if(a+j1>=0 && a+j1<dp[0].length && b+j2>=0 && b+j2<dp[0].length)                                   max=Math.max(max,dp[i+1][a+j1][b+j2]);
                                }
                                
                            }

                            dp[i][a][b]=res+max;




                    }
                }


            }

            return dp[0][0][dp[0].length-1];
            
            
        
        
    }
}
