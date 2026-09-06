package com.qihoo.jiagu;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public class d {
    public static void a(String str) {
        try {
            if (Runtime.getRuntime().exec(str).waitFor() != 0) {
                new StringBuilder("Failed to execute cmd:").append(str);
            }
        } catch (Exception e) {
        }
    }
}
