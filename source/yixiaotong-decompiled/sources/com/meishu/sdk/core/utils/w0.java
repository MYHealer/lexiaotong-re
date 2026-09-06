package com.meishu.sdk.core.utils;

import android.content.Context;
import com.meishu.sdk.core.ad.AdType;

/* JADX INFO: compiled from: RequestUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class w0 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f4954a;
    public final /* synthetic */ AdType b;

    public w0(Context context, AdType adType) {
        this.f4954a = context;
        this.b = adType;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        x0.a(this.f4954a, this.b);
    }
}
