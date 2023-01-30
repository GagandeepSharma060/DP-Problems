class Solution {
    public boolean isMatch(String A, String B) {
        
        if(B.length()==0)
          {
              return A.length()==0;
          }
          if(B.charAt(0)=='*' && B.length()==1) return true;
          if(B.length()==0)
          {
              return A.length()==0;
          }
        
        int n=A.length();
        int m =B.length();
        int dp[][]= new int[m+1][n+1];
        
        dp[0][0]=1;
        for(int i=1;i<=n;i++)
        {
            dp[0][i]=0;
        }
        
        for(int i=1;i<m+1;i++)
        {
            if(B.charAt(i-1)=='*')
            {
                dp[i][0]=dp[i-1][0];
            }
        }
        
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                char ch1= A.charAt(j-1);
                char  ch2= B.charAt(i-1);
                
                if(ch2=='*')
                {
                    
                    dp[i][j]=dp[i-1][j]|dp[i][j-1];
                }
                else{
                    
                    if(ch1==ch2 || ch2=='?')
                    {
                        dp[i][j]=dp[i-1][j-1];
                    }
                    
                    
                }
            }
        }
        return dp[m][n]==1;
    }
}
