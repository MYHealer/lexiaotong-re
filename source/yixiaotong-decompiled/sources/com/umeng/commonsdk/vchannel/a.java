package com.umeng.commonsdk.vchannel;

import com.kuaishou.weapon.p0.t;

/* JADX INFO: compiled from: Constant.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9294a = "https://pslog.umeng.com";
    public static String b = "https://pslog.umeng.com/";
    public static String c = "explog";
    public static final String d = "analytics";
    public static final String e = "ekv";
    public static final String f = "id";
    public static final String g = "ts";
    public static final String h = "ds";
    public static final String i = "pn";
    public static String j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        j = str + String.format("%0" + (32 - str.length()) + t.t, 0);
    }
}
