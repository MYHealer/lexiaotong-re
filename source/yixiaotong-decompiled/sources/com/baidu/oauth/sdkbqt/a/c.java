package com.baidu.oauth.sdkbqt.a;

import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1859a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private static final String d = "aHR0cHM6Ly9wYXNzcG9ydC5iYWlkdS5jb20=";
    private static final String e = "aHR0cHM6Ly93YXBwYXNzLmJhaWR1LmNvbQ==";
    private static final String f = "aHR0cHM6Ly9vcGVuYXBpLmJhaWR1LmNvbQ==";
    private static final String g = "aHR0cHM6Ly9jcTAxLXBhc3Nwb3J0LW1pczAwLmNxMDEuYmFpZHUuY29tOjg1ODM=";
    private static final String h = "aHR0cHM6Ly9jcTAxLXBhc3Nwb3J0LW1pczAwLmNxMDEuYmFpZHUuY29tOjg1ODM=";
    private static final String i = "aHR0cHM6Ly9uc2NsaWNrLmJhaWR1LmNvbS92LmdpZg==";
    private static final String j = "aHR0cHM6Ly93d3cuYmFpZHUuY29t";
    private static int k = 1;

    public static void a(int i2) {
        k = i2;
    }

    public static String a(String str) {
        int i2 = k;
        String str2 = f;
        if (i2 != 1 && (i2 == 2 || i2 == 3)) {
            str2 = "aHR0cHM6Ly9jcTAxLXBhc3Nwb3J0LW1pczAwLmNxMDEuYmFpZHUuY29tOjg1ODM=";
        }
        return b(str2) + b(str);
    }

    public static String a() {
        return b(d);
    }

    public static String b() {
        return b(e);
    }

    public static String c() {
        return b(i);
    }

    public static ArrayList<String> d() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        arrayList.add(b(d).replace("https://", ""));
        arrayList.add(b(e).replace("https://", ""));
        arrayList.add(b(i).replace("https://", ""));
        return arrayList;
    }

    public static ArrayList<String> e() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(b(d).replace("https://", ""));
        arrayList.add(b(e).replace("https://", ""));
        return arrayList;
    }

    public static ArrayList<String> f() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        arrayList.add(b("YmFpZHUuY29t"));
        arrayList.add(b("aGFvMTIzLmNvbQ=="));
        arrayList.add(b("bnVvbWkuY29t"));
        arrayList.add(b("YmFpZnViYW8uY29t"));
        return arrayList;
    }

    public static String g() {
        return b(j);
    }

    private static String b(String str) {
        return h.b(str);
    }
}
