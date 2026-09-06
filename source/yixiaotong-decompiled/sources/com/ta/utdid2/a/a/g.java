package com.ta.utdid2.a.a;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8530a = Pattern.compile("([\t\r\n])+");

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m1003a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            i = (i * 31) + c;
        }
        return i;
    }
}
