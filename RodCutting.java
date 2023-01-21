class Solution{
    public int cutRod(int price[], int n) {
        //code here
      int dp[][]= new int[price.length][n+1];
      
      for(int i=0;i<=n;i++)
      {
          dp[0][i]= price[0]*i;
      }
      
      for(int i=1;i<price.length;i++)
      {
          for(int j=0;j<=n;j++)
          {
              dp[i][j]=dp[i-1][j];
              int len=i+1;
              if(j-len>=0)
              {
                  dp[i][j]=Math.max(dp[i][j],price[i]+dp[i][j-(len)]);
              }
          }
      }
      
      return dp[price.length-1][n];
    }
}
