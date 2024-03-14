class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum=0;
        int count=0;
        HashMap<Integer,Integer>presum=new HashMap<>();
        for(int j=0;j<nums.length;j++){
            sum=sum+nums[j];
            if(sum==goal){
                count++;
            }
            if(presum.containsKey(sum-goal)){
                count+=presum.get(sum-goal);
            }
            presum.put(sum,presum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}