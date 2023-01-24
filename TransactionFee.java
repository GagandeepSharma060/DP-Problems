class Solution {
    public int maxProfit(int[] prices, int fee) {
       int n=prices.length;
       int dp[][]= new int[n+1][2];
       for(int i=n-1;i>=0;i--)
       {
           for(int j=0;j<=1;j++)
           {
               if(j==1)
               {
                    dp[i][j]=Math.max(dp[i+1][j],-prices[i]+dp[i+1][0]);

                   
               }else{
                   dp[i][j]=Math.max(dp[i+1][j],prices[i]+dp[i+1][1]-fee);

               }
           }


       }
       return dp[0][1];
        
    }
}
