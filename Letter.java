/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.*/
import java.util.ArrayList;
import java.util.List;

public class Letter {
    public List<String>phone(String s){
        List<String>res=new ArrayList<>();
        String []letter={"", " ", "abc","def", "ghi","jkl","mno", "pqrs", "tuv", "wxyz"};
        phoneHelper(res, s, letter, "");
        return res;
    }
    public void phoneHelper(List<String>res, String digits, String[]letter, String path){
        if(digits.length()==0){
            res.add(path);
        }
        else{
            String first=digits.substring(0,1);
            String rest=digits.substring(1);
            String chars=letter[Integer.parseInt(first)];
            for(char c: chars.toCharArray()){
                phoneHelper(res, rest, letter, path+c);
            }
        }
    }
    public static void main(String[]args){
        List<String>res=new ArrayList<>();
        Letter l=new Letter();
        res=l.phone("234");
        System.out.println(res);
    }
}
