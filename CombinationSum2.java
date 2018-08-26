import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSum2 {
    public List<List<Integer>> combo2(int[]nums, int target){
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>chosen = new ArrayList<>();
        Arrays.sort(nums);
        combine(res, chosen, nums, target, 0);
        return res;
    }
    public void combine(List<List<Integer>>res, List<Integer>chosen, int[]nums, int target, int start){
        if(target<0)return;
        if(target==0){
            res.add(new ArrayList<>(chosen));
        }
        else{
            for(int i=start;i<nums.length;i++){
                if(i>start && nums[i]==nums[i-1])continue;
                chosen.add(nums[i]);
                combine(res, chosen, nums, target-nums[i], i+1);
                chosen.remove(chosen.size()-1);
            }
        }
    }
    public static void main(String[] args){
        List<List<Integer>>res=new ArrayList<>();
        int[]nums={2, 3, 5, 6, 8, 10};
        int target=10;
        CombinationSum2 sum2=new CombinationSum2();
        res=sum2.combo2(nums, target);
        System.out.println(res);
    }
}
