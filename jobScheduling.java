class Pair{
    int st;
    int end;
    int pro;

    Pair(int i , int j , int k)
    {
        st=i;
        end=j;
        pro= k;
    }
}
class Solution {

    public int bs(Pair[] p , int st , int end , int val)
    {
        int ans=-1;

        while(st<=end)
        {
            int mid = (st+end)/2;

            if(p[mid].end <= val)
            {
                ans= mid;
                st=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
 
       int n= startTime.length;
        Pair[] p = new Pair[startTime.length];

        for(int i=0;i<startTime.length;i++)
        {
            p[i]= new Pair(startTime[i],endTime[i],profit[i]);
        }

        Arrays.sort(p,(a,b)->(a.end - b.end));

        int dp[] = new int[n];

        dp[0]=p[0].pro;
        for(int i=1;i<n;i++)
        {
            int idx= bs(p,0,i-1,p[i].st);
            if(idx==-1)
            {
                dp[i]=Math.max(dp[i-1],p[i].pro);
            }else{
                dp[i]=Math.max(dp[i-1],p[i].pro+dp[idx]);
            }
        }

        return dp[n-1];

        
    }
}
