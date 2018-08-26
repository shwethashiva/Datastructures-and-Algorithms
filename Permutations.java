/*Given a collection of distinct integers, return all possible permutations.*/
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>>permutate(int[]nums){
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>chosen = new ArrayList<>();
        permute(res, chosen, nums);
        return res;
    }
    public void permute(List<List<Integer>>res, List<Integer>chosen, int[]nums){
        if(chosen.size()==nums.length){
            res.add(new ArrayList<>(chosen));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(chosen.contains(nums[i]))continue;
                chosen.add(nums[i]);
                permute(res, chosen, nums);
                chosen.remove(chosen.size()-1);
            }
        }
    }
    public static void main(String[] args){
        List<List<Integer>>res=new ArrayList<>();
        int[]nums={1, 1,2};
        Permutations perm=new Permutations();
        res=perm.permutate(nums);
        System.out.println(res);
    }
}
