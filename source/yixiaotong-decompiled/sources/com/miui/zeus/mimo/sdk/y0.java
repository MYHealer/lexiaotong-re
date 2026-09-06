package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.view.component.CloseICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class y0 extends x0 {
    public y0(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public y0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.miui.zeus.mimo.sdk.x0, com.miui.zeus.mimo.sdk.j0
    public void a(View view) {
        super.a(view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), 27.0f), f9.a(getContext(), 27.0f));
        layoutParams.addRule(21);
        layoutParams.topMargin = f9.a(getContext(), 10.0f);
        layoutParams.setMarginEnd(f9.a(getContext(), 10.0f));
        CloseICP closeICP = this.h;
        int i = a0.j2;
        closeICP.setPadding(0, 0, 0, 0);
        closeICP.setImageResource(i);
        this.h.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(f9.a(getContext(), 27.0f), f9.a(getContext(), 27.0f));
        layoutParams2.addRule(20);
        layoutParams2.topMargin = f9.a(getContext(), 10.0f);
        layoutParams2.setMarginStart(f9.a(getContext(), 10.0f));
        this.f5477a.setLayoutParams(layoutParams2);
    }

    @Override // com.miui.zeus.mimo.sdk.x0, com.miui.zeus.mimo.sdk.j0
    public void a(MimoAdInfo mimoAdInfo) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(a0.f5);
        if (relativeLayout != null) {
            relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.miui.zeus.mimo.sdk.x0, com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        RelativeLayout.LayoutParams layoutParams;
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        this.o.setVisibility(0);
        View view = this.n;
        if (view != null) {
            view.setVisibility(8);
        }
        if (mimoAdInfo.E() && (layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams()) != null) {
            layoutParams.bottomMargin = f9.a(getContext(), 2.2f);
            this.o.setLayoutParams(layoutParams);
        }
        this.c.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 91, 95, 126, 126, 117, 39, 34, 32}, "5bf883")));
        if (activity.getResources().getConfiguration().orientation == 2) {
            this.c.setVisibility(8);
        }
        setOutlineProvider(new t6(f9.a(getContext(), 14.5f)));
        setClipToOutline(true);
        this.b.setOutlineProvider(new t6(f9.a(getContext(), 14.5f)));
        this.b.setClipToOutline(true);
        if (activity.getResources().getConfiguration().orientation == 1 && !mimoAdInfo.I.equals(ijiami_1011.s.s.s.d(new byte[]{16, 1, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, 80, 2, 0, 8}, "fd2c9a"))) {
            if (this.b.getVideoLayout().getVisibility() == 0) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = f9.a(getContext(), 145.0f);
                this.b.getVideoLayout().setLayoutParams(layoutParams2);
            }
            if (this.b.getBackgroundImageView().getVisibility() == 0) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = f9.a(getContext(), 145.0f);
                this.b.getBackgroundImageView().setLayoutParams(layoutParams3);
            }
        }
        if (this.b.getVideoLayout().getVisibility() == 0) {
            ProgressBar progressBar = new ProgressBar(getContext(), null, android.R.attr.progressBarStyleHorizontal);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, f9.a(getContext(), 2.2f));
            layoutParams4.addRule(12);
            progressBar.setLayoutParams(layoutParams4);
            progressBar.setIndeterminate(false);
            progressBar.setMax(100);
            progressBar.setProgressDrawable(ContextCompat.getDrawable(getContext(), a0.b2));
            ((RelativeLayout) findViewById(a0.f5)).addView(progressBar);
            this.b.setCustomProgressView(progressBar);
        }
    }
}
