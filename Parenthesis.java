
import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    public List<String>GenerateParen(int n){
        List<String>res=new ArrayList<>();
        generate(res, "", n, n);
        return res;
    }
    public void generate(List<String>res, String chosen, int left, int right){
        if(left>right)return;
        if(left==right){
            res.add(chosen);
        }
            if(left>0){
                generate(res, chosen+"(", left-1, right);
            }
            if(right>0){
                generate(res, chosen+")", left, right-1);
            }

    }
    public static void main(String[] args){
        List<String>res=new ArrayList<>();
        Parenthesis pa=new Parenthesis();
        res=pa.GenerateParen(3);
        System.out.println(res);
    }
}
