class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] res=new int[points.length];
        for(int i=0;i<points.length;i++){
            res[i]=points[i][0];
        }
        Arrays.sort(res);
        int i=0;
        int j=1;
        int max=Integer.MIN_VALUE;
        while(j<=res.length-1){
            int diff=res[j]-res[i];
            max=Math.max(max,diff);
            i++;
            j++;
        }
        return max;
    }
}