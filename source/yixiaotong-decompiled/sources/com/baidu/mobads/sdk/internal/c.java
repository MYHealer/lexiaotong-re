package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f1763a;

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1764a = "remote_adserv";
        public static final String b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (f1763a == null) {
            synchronized (c.class) {
                if (f1763a == null) {
                    f1763a = new c();
                }
            }
        }
        return f1763a;
    }

    public as a(String str) {
        return new as(str);
    }
}
