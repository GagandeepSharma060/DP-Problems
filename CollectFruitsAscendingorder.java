class Solution {
    public static long minTime(int n, int[] locations, int[] types) {
        // code here
        
        
        
        int max=Integer.MIN_VALUE;
        for(int a:types)
        {
            max=Math.max(max,a);
            
            
        }
        
        
        int temp[][]= new int[max+1][2];
        
        for(int i=0;i<=max;i++)
        {
            temp[i][0]=Integer.MAX_VALUE;
            temp[i][1]=Integer.MIN_VALUE;
        }
        for(int i=0;i<locations.length;i++)
        {
            
            int cur= types[i];
            
            temp[cur][0]=Math.min(temp[cur][0],locations[i]);
                temp[cur][1]=Math.max(temp[cur][1],locations[i]); 
        }
        ArrayList<ArrayList<Integer>> al= new ArrayList<>();
    
        for(int i=0;i<=max;i++)
        {
            if(temp[i][0]!=Integer.MAX_VALUE)
            {
                ArrayList<Integer> ccc= new ArrayList<>();
                ccc.add(temp[i][0]);
                ccc.add(temp[i][1]);
                
                al.add(ccc);
                
                
            }
        }
        
        long dp[][]= new long[al.size()+1][3];
        
        for(long a[]: dp)
        {
            Arrays.fill(a,-1);
        }
        
        
        return help( 0 , dp , al , 2);
        
    }
    
    public static long help(int idx , long dp[][] , ArrayList<ArrayList<Integer>> al , int st)
    {
        
        if(idx==al.size())
        {
            return dp[idx][st]= Math.abs(al.get(idx-1).get(st));
        }
        
        if(dp[idx][st]!=-1)
        {
            
            return dp[idx][st];
            
        }
        
        
        
        
        int x=0;
        
        if(st==0)
        {
            x= al.get(idx-1).get(0);
        }else if(st==1){
             x= al.get(idx-1).get(1);
        }
        
        if(x<=al.get(idx).get(0))
        {
            dp[idx][st]= al.get(idx).get(1)-x +help(idx+1,dp,al,1);
        }else if(x>=al.get(idx).get(1))
        {
            dp[idx][st]=x-al.get(idx).get(0)+help(idx+1,dp,al,0);
        }else{
            
            
            int rt= al.get(idx).get(1);
            int lt= al.get(idx).get(0);
            dp[idx][st]= Math.min( 2*(x-lt)+ rt-x +help(idx+1,dp,al,1),2*(rt-x)+(x-lt)+help(idx+1,dp,al,0));
        }
        
        
        return dp[idx][st];
        
        
        
    }
}
        
