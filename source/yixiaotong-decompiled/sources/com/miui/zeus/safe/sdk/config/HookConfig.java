package com.miui.zeus.safe.sdk.config;

import com.miui.zeus.safe.sdk.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HookConfig {
    public boolean isHaveAppium() {
        b.a().getClass();
        return b.f.f5764a;
    }

    public boolean isHaveFrida() {
        b.a().getClass();
        return b.e.f5765a;
    }

    public boolean isHaveSubstrate() {
        b.a().getClass();
        b.c cVar = b.d;
        return cVar.f5766a || cVar.b || cVar.c;
    }

    public boolean isHaveXposed() {
        b.a().getClass();
        b.d dVar = b.c;
        return dVar.f5767a || dVar.b || dVar.c || dVar.d || dVar.e || dVar.f || dVar.g || dVar.h || dVar.i;
    }
}
