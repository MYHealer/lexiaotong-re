package com.yfanads.android.adx.model;

import android.content.Context;
import android.util.Log;
import com.yfanads.android.adx.core.model.NativeSourceNew;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: compiled from: DownloadTemplate.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NativeSourceNew f9611a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;

    public a(Context context, int i, NativeSourceNew nativeSourceNew, int i2) {
        this.f9611a = nativeSourceNew;
        a(context, i2);
    }

    public final void a(Context context, int i) {
        YFAdsPhone yFAdsPhone = YFAdsPhone.getInstance();
        this.q = yFAdsPhone.isTablet();
        if (yFAdsPhone.isPhoneSplitScreen(context, i)) {
            this.b = ScreenUtil.isLandscape(context, 1.33f);
        } else {
            this.b = yFAdsPhone.isScreenLand(i);
        }
        Log.d(Util.TAG, "download updateSize isLandTemplate=" + this.b + ",isTablet=" + this.q + " , " + i);
        int windowHeight = this.b ? (int) (ScreenUtil.getWindowHeight(context) * (this.q ? 0.5f : 0.8f)) : -2;
        this.e = windowHeight;
        if (!this.b) {
            windowHeight = ScreenUtil.getWindowWidth(context);
        }
        this.d = windowHeight;
        this.c = ScreenUtil.dip2px(context, this.b ? 20.0f : 33.0f);
        this.f = ScreenUtil.dip2px(context, this.b ? 43.0f : 70.0f);
        this.g = ScreenUtil.dip2px(context, this.b ? 53.0f : 85.0f);
        this.h = ScreenUtil.dip2px(context, this.b ? 28.0f : 45.0f);
        boolean z = this.b;
        this.i = z ? 12 : 20;
        this.j = z ? 9 : 14;
        this.k = z ? 8 : 12;
        this.l = z ? 11 : 18;
        this.m = z ? 9 : 14;
        this.n = z ? 8 : 12;
        this.o = z ? 8 : 12;
        this.p = z ? 12 : 20;
    }
}
