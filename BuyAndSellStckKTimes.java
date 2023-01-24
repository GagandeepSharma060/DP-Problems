class Solution {
    public int maxProfit(int d, int[] arr) {
       int n=arr.length;
        int dp[][][]= new int[n+1][2][d+1];

       for(int i=n-1;i>=0;i--)
       {
           for(int j=0;j<=1;j++)
           {
               for(int k=1;k<=d;k++)
               {

                   if(j==1)
                   {
                       dp[i][j][k]=Math.max(dp[i+1][0][k]-arr[i],dp[i+1][1][k]);
                   }else{
                       dp[i][j][k]=Math.max(dp[i+1][0][k],dp[i+1][1][k-1]+arr[i]);
                   }

               }
           }

       }
       return dp[0][1][d];


        
    }
}
