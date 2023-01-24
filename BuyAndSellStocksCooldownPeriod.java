class Solution {
    public int maxProfit(int[] prices) {
        
        // int bs = -prices[0];
        // int ss=0;
        // int cds =0;
        
        // for(int i=0;i<prices.length ;i++)
        // {
            
        //     int nbs = Math.max(bs , cds -prices[i]);
        //     int nss = Math.max(ss,bs+prices[i]);
        //     int ncds= Math.max(cds , ss);
            
        //     bs=nbs;
            
        //     ss=nss;
            
        //     cds=ncds;
            
        // }
        
        // return Math.max(ss,cds);
        int n=prices.length;
        int dp[][]= new int[n+2][2];

        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<=1;j++)
            {
                if(j==0)
                {
                    dp[i][j]=Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
                }else{
                    dp[i][j]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
            }
        }
        return dp[0][1];


    }
}
