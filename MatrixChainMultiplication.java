import java.util.* ;
import java.io.*; 

public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
		int dp[][]= new int[N][N];
		for(int i=0;i<N;i++)
		{
			dp[i][i]=0;
		}

		for(int i=N-1;i>=1;i--)
		{
			for(int j=i+1;j<N;j++)
			{
				int min=Integer.MAX_VALUE;
				for(int k=i;k<j;k++)
				{
					int steps= arr[i-1]*arr[k]*arr[j] +dp[i][k]+dp[k+1][j];
					min=Math.min(steps,min);
				}
			
			dp[i][j]=min;
		}
		}
		return dp[1][N-1];

	}
}
