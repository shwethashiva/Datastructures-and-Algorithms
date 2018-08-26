import java.util.ArrayList;
import java.util.List;

/*Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.*/
public class CombinationSum {

    public List<List<Integer>> comboSum(int[]nums, int target){
        List<List<Integer>>res=new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        combineHelper(res, chosen, target, nums, 0);
        return res;
    }
    public void combineHelper(List<List<Integer>>res, List<Integer>chosen, int target, int[]nums, int start){
        if(target<0)return;
        if(target==0){
            res.add(new ArrayList<>(chosen));
        }
        else{
            for(int i=start;i<nums.length;i++){
                chosen.add(nums[i]);
                combineHelper(res, chosen, target-nums[i], nums, i);
                chosen.remove(chosen.size()-1);
            }
        }
    }
    public static void main(String[] args){
        CombinationSum sum=new CombinationSum();
        List<List<Integer>>res=new ArrayList<>();
        int[]nums={2, 3, 5, 6, 8, 10};
        int target=10;
        res=sum.comboSum(nums, target);
        System.out.println(res);
    }

}
