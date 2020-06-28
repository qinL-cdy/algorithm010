class Solution {
  public void backtrack(int n,
                        ArrayList<Integer> output,
                        List<List<Integer>> res,
                        int first) {
    if (first == n)
      res.add(new ArrayList<Integer>(output));
    for (int i = first; i < n; i++) {
      Collections.swap(output, first, i);
      backtrack(n, output, res, first + 1);
      Collections.swap(output, first, i);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new LinkedList();

    ArrayList<Integer> output = new ArrayList<Integer>();
    for (int num : nums)
      output.add(num);

    int n = nums.length;
    backtrack(n, output, res, 0);
    return res;
  }
}
