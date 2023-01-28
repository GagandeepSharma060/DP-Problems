class Solution {
    public int maxSubArray(int[] arr) {

        int fsum=arr[0];
        int currsum=arr[0];

        for(int i=1;i<arr.length;i++)
        {
             currsum=Math.max(0,currsum);
            currsum+=arr[i];
            fsum=Math.max(currsum,fsum);
           
        }

     return fsum;   
    }
}
