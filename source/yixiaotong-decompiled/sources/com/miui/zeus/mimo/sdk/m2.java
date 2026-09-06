package com.miui.zeus.mimo.sdk;

import android.content.DialogInterface;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m2 implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j2 f5526a;

    public m2(j2 j2Var) {
        this.f5526a = j2Var;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        MimoMediaView mimoMediaView = this.f5526a.b;
        if (mimoMediaView != null) {
            mimoMediaView.a();
        }
    }
}
