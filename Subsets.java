import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>>subset(int[]nums){
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>chosen=new ArrayList<>();
        subsetHelper(nums, res, chosen,0);
        return res;
    }
    public void subsetHelper(int[]nums, List<List<Integer>>res, List<Integer>chosen, int start){
        res.add(new ArrayList<>(chosen));
        for(int i=start;i<nums.length;i++){
            chosen.add(nums[i]);
            subsetHelper(nums, res, chosen, i+1);
            chosen.remove(chosen.size()-1);
        }
    }
    public static void main(String[] args){
        List<List<Integer>>res=new ArrayList<>();
        int[]nums={1, 2,3,4};
        Subsets perm=new Subsets();
        res=perm.subset(nums);
        System.out.println(res);
    }
}
