class Solution {
    public int minCut(String s) {
       int n=s.length();
        boolean part[][]= new boolean[n][n];

        for(int i=0;i<n;i++)
        {
            part[i][i]=true;
        }
        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                part[i][i+1]=true;
            }
        }

        for(int gap=2;gap<n;gap++)
        {
            for(int i=0;i<n;i++)
            {
                int j=gap+i;
                if(j>=n) break;

                if(s.charAt(i)==s.charAt(j))
                {
                    part[i][j]=part[i+1][j-1];
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
               // System.out.print(part[i][j]+" ");
            }
            //System.out.println();
        }

        int dp[]= new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--)
        {
            int min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++)
            {
                if(part[i][j]==true)
                {
                    min=Math.min(dp[j+1],min);
                }
            }

            dp[i]=1+min;
        }
        return dp[0]-1;

        
    }
}
