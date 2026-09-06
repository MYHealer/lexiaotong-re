package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.view.MimoMarkView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class w2 extends h2 {
    public MimoMarkView s;

    public w2(Context context) {
        super(context);
    }

    @Override // com.miui.zeus.mimo.sdk.h2
    public void a(View view) {
        super.a(view);
        this.o = false;
        MimoMarkView mimoMarkView = (MimoMarkView) view.findViewById(a0.z2);
        this.s = mimoMarkView;
        mimoMarkView.setGravity(17);
        this.i.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{66, 80, 15, 3, 7, 81, 81, 84, 86}, "af937a")));
    }

    @Override // com.miui.zeus.mimo.sdk.h2
    public int getLayoutId() {
        Activity activity = this.j;
        return (activity == null || activity.getResources().getConfiguration().orientation != 2) ? a0.a5 : a0.r0;
    }

    @Override // com.miui.zeus.mimo.sdk.h2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        if (mimoAdInfo.t()) {
            this.i.setGravity(17);
            this.s.setVisibility(mimoAdInfo.d().isEmpty() ? 8 : 0);
            this.s.a(mimoAdInfo.d(), this);
        } else {
            this.c.setVisibility(8);
            this.f.setVisibility(8);
            this.s.setVisibility(8);
        }
    }
}
