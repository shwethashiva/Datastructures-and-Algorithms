import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>>permutate2(int[]nums){
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer>chosen=new ArrayList<>();
        permuteHelper(res, chosen, nums, new boolean[nums.length]);
        return res;
    }
    public void permuteHelper(List<List<Integer>>res, List<Integer>chosen, int[]nums, boolean[]used){
        if(chosen.size()==nums.length){
            res.add(new ArrayList<>(chosen));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(used[i] || i>0 &&nums[i]==nums[i-1] && !used[i-1])continue;
                used[i]=true;
                chosen.add(nums[i]);
                permuteHelper(res,chosen, nums, used);
                chosen.remove(chosen.size()-1);
                used[i]=false;
            }
        }
    }
    public static void main(String[] args){
        List<List<Integer>>res=new ArrayList<>();
        int[]nums={1, 1,2};
        Permutations2 perm=new Permutations2();
        res=perm.permutate2(nums);
        System.out.println(res);
    }
}
