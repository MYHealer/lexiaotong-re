package com.miui.zeus.safe.sdk.config;

import com.miui.zeus.safe.sdk.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RootConfig {
    public boolean isRooted() {
        if (c.h == null) {
            synchronized (c.class) {
                if (c.h == null) {
                    c.h = new c();
                }
            }
        }
        return c.h.f5768a;
    }
}
