/*
LC90. Subsets II -- duplicates allowed
Idea: iteratively append the rest into the list level by level (like BFS)
e.g. [1, 2, 2]
Steps: First update startIndex, and then update size

list = [ [] ] 

-- startIndex = 0 -- sz = 1
list = [ [], [1]] 

-- startIndex = 0 -- sz = 2 
list = [ [], [1]; [2], [1,2]]

-- startIndex = 2 (duplicate) -- sz = 4
list = [ [], [1]; [2], [1,2]; [2,2], [1,2,2]]
*/

public class SubsetII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        int startIndex = 0, sz = 0;
        for (int i = 0; i < nums.length; ++i) {		// for each new number at i
        	int startIndex = (i > 0 && nums[i] == nums[i - 1]) ? sz : 0;
        	sz = ans.size();
        	for (int j = startIndex; j < sz; ++j) {
        		List<Integer> sublist = new ArrayList<>(ans.get(j));
        		sublist.add(nums[i]);
        		ans.add(sublist);
        	}
        }
        return ans;
    }
}