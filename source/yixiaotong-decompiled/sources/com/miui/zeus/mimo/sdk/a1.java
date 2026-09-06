package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a1 extends x0 {
    public AdMarkICP p;

    public a1(Context context) {
        super(context);
    }

    @Override // com.miui.zeus.mimo.sdk.x0, com.miui.zeus.mimo.sdk.j0
    public void a(View view) {
        super.a(view);
        this.p = (AdMarkICP) view.findViewById(a0.K3);
        this.b.setPicStartCountDown(false);
        this.b.setLooping(true);
        this.b.setBackgroundScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    @Override // com.miui.zeus.mimo.sdk.x0
    public void b(String str) {
        this.h.bringToFront();
        this.p.bringToFront();
        this.h.bringToFront();
    }

    @Override // com.miui.zeus.mimo.sdk.x0, com.miui.zeus.mimo.sdk.j0
    public int getLayoutId() {
        return a0.Z0;
    }

    @Override // com.miui.zeus.mimo.sdk.x0, com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        AdMarkICP adMarkICP = this.p;
        i8 i8Var = this.j;
        adMarkICP.f5687a.setText(mimoAdInfo.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo, i8Var));
    }
}
