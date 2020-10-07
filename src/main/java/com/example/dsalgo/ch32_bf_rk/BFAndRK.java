package com.example.dsalgo.ch32_bf_rk;

/**
 * @Description: BF和RK字符串匹配算法
 * @Author: paladin
 * @date: 2020/10/5 23:24
 */
public class BFAndRK {

    private static int bf(char[] mainStr, char[] pattern) {
        int n = mainStr.length;
        int m = pattern.length;
        if (n <= m) {
            return mainStr.equals(pattern) ? 0 : -1;
        }
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (mainStr[i + j] == pattern[j]) {
                    if (j == m - 1) {
                        return 1;
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    private static long hash(char[] ch, int start, int end) {
        // 当start等于end的时候，单个字符串的hash值怎么处理？
        if (start >= end) {
            return 0;
        }
        long ret = 0;
        for (int i = start; i < end + 1; i++) {
            ret += ch[i];
        }
        return ret;
    }

    public static int rk(char[] mainStr, char[] pattern) {
        int n = mainStr.length;
        int m = pattern.length;
        if (n <= m) {
            return mainStr.equals(pattern) ? 0 : -1;
        }

        long[] hash = new long[n - m];
        hash[0] = hash(mainStr, 0, m - 1);
        for (int i = 1; i < n - m + 1; i++) {
            hash[i] = hash[i - 1] - hash(mainStr, i - 1, i - 1) + hash(mainStr, i + m - 1, i + m - 1);
        }
        long hashP = hash(pattern, 0, m - 1);
        for (int i = 0; i < n-m+1; i++) {
            if (hash[i] == hashP) {
                String str = "";
                for (int j = i; j < i + m; j++) {
                    str = str + mainStr[j];
                }
                if (pattern.equals(str)) {
                    return i;
                }else {
                    continue;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] mStr = new char[10000];
        char[] pStr = new char[201];
        for (int i = 0; i < 10000; i++) {
            mStr[i] = 'a';
        }
        for (int i = 0; i < 200; i++) {
            pStr[i] = 'a';
        }
        pStr[200] = 'b';

        System.out.println(bf(mStr, pStr));

//        mStr = "thequickbrownfoxjumpsoverthelazydog";
//        pStr = "jump";

    }
}
