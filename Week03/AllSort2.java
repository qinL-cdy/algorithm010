class Solution {
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0){
            return result;
        }
        
        Arrays.sort(nums);
        findUnique(nums,new boolean[nums.length],new LinkedList<Integer>());
        return result;
    }
    public void findUnique(int[] nums, boolean[] visited,LinkedList<Integer> trace){
        
        if(trace.size() == nums.length){
            result.add(new LinkedList(trace));
            return ;
        }
        for(int i = 0; i<nums.length; i++){
            if(visited[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && visited[i-1]) break;
            trace.add(nums[i]);
            visited[i] = true;
            findUnique(nums,visited,trace);
            trace.removeLast();
            visited[i] = false;
        }
    }
}