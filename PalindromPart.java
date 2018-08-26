import java.util.ArrayList;
import java.util.List;

public class PalindromPart {
    public List<List<String>>partitioning(String s){
        List<List<String>>res=new ArrayList<>();
        List<String>chosen=new ArrayList<>();
        partitionHelper(res, chosen, s, 0);
        return res;
    }
    public void partitionHelper(List<List<String>>res, List<String>chosen, String s, int start){
        if(start==s.length())
        res.add(new ArrayList<>(chosen));
        else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    chosen.add(s.substring(start, i + 1));
                    partitionHelper(res, chosen, s, i + 1);
                    chosen.remove(chosen.size() - 1);
                }
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
        List<List<String>>res=new ArrayList<>();
        PalindromPart p=new PalindromPart();
        res=p.partitioning("aab");
        System.out.println(res);
    }
}
