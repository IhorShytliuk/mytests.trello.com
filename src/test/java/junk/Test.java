package junk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Test {
    public static String allSwap(String[] strings) {

        TreeMap<String, Integer> fch = new TreeMap<>();
        String res = "";

        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            int cnt = 0;

            if (fch.containsKey(str)) {
                cnt = fch.get(str);
            }
            cnt++;
            fch.put(str, cnt);

            if (cnt > 1 && cnt % 2 == 0) {
                res += str;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"a", "b", "a", "c", "a", "d", "a"};
        System.out.println(allSwap(s));
    }
}
