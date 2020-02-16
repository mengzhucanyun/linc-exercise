package simple;

/**
 * Created by linc on 2020/2/16.
 */
public class Test44 {

    public static void main(String[] args){
        boolean b=new Test44().isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
                ,"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb");
        System.out.println(b);
    }


    public boolean isMatch(String s, String p) {
        int ss=0,pp=0;
        int marked = -1;
        String p2 = p+'^'; // In case that the last char in p is *
        int count=0;

        while(ss<s.length() && pp<p2.length()){
            count++;
            System.out.println(count);
            if(s.charAt(ss) == p2.charAt(pp) || p2.charAt(pp)=='?'){
                ss++;
                pp++;
            }
            else if(p2.charAt(pp)=='*'){
                pp++;
                marked = pp;
            }
            else{
                if(pp==marked){
                    ss++;
                }
                else{
                    if(marked!=-1){
                        ss = ss - (pp - marked - 1);
                        pp = marked;
                    }
                    else return false;
                }
            }
        }

        while(pp<p.length()){
            if(p.charAt(pp)!='*'){
                return false;
            }
            pp++;
        }
        return ss>=s.length();
    }
}
