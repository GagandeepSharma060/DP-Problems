class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][]= new int[n][w+1];
         
         for(int i=wt[0];i<=w;i++)
         {
             dp[0][i]=val[0];
         }
         
         for(int i=1;i<n;i++)
         {
             for(int j=1;j<=w;j++)
             {
                 dp[i][j]=dp[i-1][j];
                 if(wt[i]<=j)
                 {
                     dp[i][j]=Math.max(dp[i][j],val[i]+dp[i-1][j-wt[i]]);
                 }
             }
         }
         
         
         
         return dp[n-1][w];
    } 
}
