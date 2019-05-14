package simple;

/**
 * Created by linc on 2018/8/22.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int size=stringSize(x);
        for(int i=1;i<=size/2;i++){

            int a=(x/((int)(Math.pow(10,i-1))))%10;
            int b=(x/((int)(Math.pow(10,size-i))))%10;
            if(a != b)
                return false;
        }
        return true;

    }

    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

    public static void main(String[] args){
        boolean b=new PalindromeNumber().isPalindrome(121);
    }
}
