package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p0 extends i0 {
    public p0(Context context) {
        super(context);
    }

    @Override // com.miui.zeus.mimo.sdk.i0
    public void a(View view) {
        this.f5456a = (DownloadButtonICP) view.findViewById(a0.G5);
    }

    @Override // com.miui.zeus.mimo.sdk.i0
    public int getLayoutId() {
        return a0.u0;
    }

    @Override // com.miui.zeus.mimo.sdk.i0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        this.e = mimoAdInfo;
        this.f = activity;
        this.f5456a.a(mimoAdInfo, this.h);
        setCLickAreaListener(this.h);
    }
}
