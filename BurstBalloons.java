class Solution {
    public int maxCoins(int[] nums) {
        

        int n=nums.length+2;
        int arr[]= new int[n];
        for(int i=0;i<nums.length;i++)
        {
            arr[i+1]=nums[i];


        }
        arr[0]=arr[n-1]=1;
    
    n=n-2;
    int dp[][]= new int[n+2][n+2];
    for(int i=n;i>=1;i--)
    {
        for(int j=1;j<=n;j++)
        {
            if(i>j) continue;
            int min=Integer.MIN_VALUE;

            for(int idx=i;idx<=j;idx++)
            {
                int cost = arr[i-1]*arr[idx]*arr[j+1]+ dp[i][idx-1]+dp[idx+1][j];
                min=Math.max(min,cost);
            }
            dp[i][j]=min;

        }
    }
    return dp[1][n];


}
}
