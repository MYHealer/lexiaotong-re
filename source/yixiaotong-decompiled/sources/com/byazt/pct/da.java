package com.byazt.pct;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 72})
public class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2619a;
    public com.byazt.nl.uj c;
    public yp da;
    public u i;
    public sl.tt m;
    public Context n;
    public Looper nu;
    public boolean sp;
    public c tt;
    public x uj;
    public boolean x;
    public boolean yp;
    public boolean z;
    public String ve = "IESJSBridge";
    public String sl = "host";
    public final Set<String> t = new LinkedHashSet();
    public final Set<String> u = new LinkedHashSet();

    public da c() {
        this.z = true;
        return this;
    }

    public da c(c cVar) {
        this.tt = cVar;
        return this;
    }

    public da c(String str) {
        this.ve = str;
        return this;
    }

    public da c(boolean z) {
        this.f2619a = z;
        return this;
    }

    public Context getContext() {
        return this.n;
    }

    public da tt(boolean z) {
        this.sp = z;
        return this;
    }

    public Looper ve() {
        return this.nu;
    }

    public da(com.byazt.nl.uj ujVar) {
        this.c = ujVar;
    }

    public da() {
    }

    public da c(t tVar) {
        this.uj = x.c(tVar);
        return this;
    }

    public nu tt() {
        uj();
        return new nu(this);
    }

    private void uj() {
        if ((this.c == null && !this.yp && this.tt == null) || ((TextUtils.isEmpty(this.ve) && this.c != null) || this.uj == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }
}
