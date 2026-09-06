package com.miui.zeus.mimo.sdk.ad.interstitial.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.b;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.i0;
import com.miui.zeus.mimo.sdk.view.component.IconICP;
import com.miui.zeus.mimo.sdk.w3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class InterstitialBottomFull extends i0 {
    public ViewFlipper i;

    public InterstitialBottomFull(Context context) {
        super(context);
    }

    public InterstitialBottomFull(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterstitialBottomFull(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.miui.zeus.mimo.sdk.i0
    public void a(View view) {
        super.a(view);
        this.i = (ViewFlipper) view.findViewById(a0.m5);
    }

    @Override // com.miui.zeus.mimo.sdk.i0
    public boolean a() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.i0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        super.destroy();
        ViewFlipper viewFlipper = this.i;
        if (viewFlipper != null) {
            viewFlipper.stopFlipping();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.i0
    public int getLayoutId() {
        return a0.d5;
    }

    @Override // com.miui.zeus.mimo.sdk.i0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        this.i.setVisibility(this.e.t() ? 0 : 8);
        this.i.removeAllViews();
        for (int i = 0; i < 2; i++) {
            IconICP iconICP = new IconICP(getContext());
            iconICP.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iconICP.a(b.h(mimoAdInfo.b(w3Var)) ? mimoAdInfo.b(w3Var) : mimoAdInfo.A, this.h);
            this.i.addView(iconICP);
        }
        this.i.setFlipInterval(3000);
        this.i.startFlipping();
        if (this.f.getResources().getConfiguration().orientation == 2) {
            this.f5456a.getLayoutParams().width = f9.a(getContext(), 203.6f);
            this.f5456a.getLayoutParams().height = f9.a(getContext(), 43.6f);
        }
    }
}
