package simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by linc on 2018/9/23.
 */
public class RegularExpretion {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty() && s.isEmpty())
            return true;
        if (p.isEmpty() && !s.isEmpty())
            return false;

        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < p.length(); ) {
            Element e = new Element();
            e.p = p.charAt(i);
            i++;
            if (i < p.length() && p.charAt(i) == '*') {
                e.hasXin = true;
                i++;
            }
            elements.add(e);
        }

        int a = 0, b = 0;
        return check(a, b, s, elements);
    }

    private boolean check(int a, int b, String s, List<Element> e) {
        if (a == s.length() - 1 && b == e.size() - 1) {
            return e.get(b).doMatch(s.charAt(a));
        }
        if (a >= s.length() && b < e.size()) {
            while (b < e.size()) {
                if (e.get(b).hasXin) {
                    b++;
                } else {
                    return false;
                }
            }
            return true;
        }
        if (a < s.length() && b >= e.size()) {
            return false;
        }
        if (e.get(b).hasXin) {
            if (e.get(b).doMatch(s.charAt(a))) {
                if (check(a + 1, b, s, e)) {
                    return true;
                } else {
                    if (check(a + 1, b + 1, s, e)) {
                        return true;
                    } else {
                        return check(a, b + 1, s, e);
                    }
                }
            } else {
                return check(a, b + 1, s, e);
            }

        } else {
            if (e.get(b).doMatch(s.charAt(a))) {
                return check(a + 1, b + 1, s, e);
            } else {
                return false;
            }

        }

    }

    class Element {
        char p;
        boolean hasXin = false;

        boolean doMatch(char s) {
            if (p == '.')
                return true;
            return s == p;
        }
    }

    public static void main(String args[]) {
        RegularExpretion expretion = new RegularExpretion();
        Boolean b = expretion.isMatch("bbbba", ".*a*a");
        int a = 1;
    }

}
