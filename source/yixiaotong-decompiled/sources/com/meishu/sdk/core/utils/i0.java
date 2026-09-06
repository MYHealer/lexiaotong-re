package com.meishu.sdk.core.utils;

/* JADX INFO: compiled from: MemoryUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i0 {
    public static int a() {
        return ((int) (Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()))) / 2;
    }
}
