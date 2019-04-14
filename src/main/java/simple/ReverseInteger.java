package simple;

/**
 * Created by linc on 2018/8/20.
 */
public class ReverseInteger {
    public int reverse(int x) {
        String s=new Integer(x).toString();
        char[] chars;
        boolean isNegative=s.startsWith("-");
        if(isNegative){
            chars=s.substring(1).toCharArray();
        }else {
            chars=s.toCharArray();
        }
        int length=chars.length;
        char[] newChars=new char[length];
        for(int i=0;i<length;i++){
            newChars[i]=chars[length-i-1];
        }
        String newStr=new String(newChars);
        if(isNegative){
          newStr="-"+newStr;
        }
        Integer result=0;
        try {
             result=Integer.parseInt(newStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;


    }
}
