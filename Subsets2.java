import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>>subset2(int[]nums){
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>chosen=new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, res, chosen, 0);
        return res;
    }
    public void helper(int[]nums, List<List<Integer>>res, List<Integer>chosen, int start){
        res.add(new ArrayList<>(chosen));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])continue;
            chosen.add(nums[i]);
            helper(nums, res, chosen, i+1);
            chosen.remove(chosen.size()-1);
        }
    }
    public static void main(String[] args){
        List<List<Integer>>res=new ArrayList<>();
        int[]nums={1, 2,2};
        Subsets perm=new Subsets();
        res=perm.subset(nums);
        System.out.println(res);
    }
}
