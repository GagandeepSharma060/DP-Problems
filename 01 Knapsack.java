class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][]= new int[n+1][w+1];
         
         for(int i=0;i<=n;i++)
         {
             
             for(int j=0;j<=w;j++)
             {
                 if(i==0|| j==0)
                 {
                     dp[i][j]=0;
                 }else{
                     
                      dp[i][j]= dp[i-1][j];
                     if(j>=wt[i-1])
                     {
                     int rc= j-wt[i-1];
                     int max2 = dp[i-1][rc]+ val[i-1];
                     
                     dp[i][j]=Math.max( dp[i][j],max2);
                     }
                 }
                 
                 
                 
             }
         }
         
         return dp[n][w];
    } 
}
