package com.meishu.sdk.meishu_ad;

import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meishu.sdk.core.view.DownloadView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5039a;
    public final /* synthetic */ RelativeLayout b;
    public final /* synthetic */ ImageView c;
    public final /* synthetic */ ImageView d;
    public final /* synthetic */ RelativeLayout e;
    public final /* synthetic */ ImageView f;
    public final /* synthetic */ TextView g;
    public final /* synthetic */ TextView h;
    public final /* synthetic */ TextView i;
    public final /* synthetic */ ImageView j;
    public final /* synthetic */ v k;

    public n(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, ImageView imageView4) {
        this.k = vVar;
        this.f5039a = cVar;
        this.b = relativeLayout;
        this.c = imageView;
        this.d = imageView2;
        this.e = relativeLayout2;
        this.f = imageView3;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = imageView4;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        int iA = com.meishu.sdk.core.utils.m.a(this.k.f5096a);
        com.meishu.sdk.meishu_ad.splash.c cVar = this.f5039a;
        boolean z = cVar != null && DownloadView.isDownloadStyleAd(cVar.b);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        double d = iA;
        double d2 = d * 13.7d;
        int i = ((int) d2) / 100;
        layoutParams.width = i;
        layoutParams.height = i;
        layoutParams.bottomMargin = ((int) (3.8d * d)) / 100;
        this.b.setLayoutParams(layoutParams);
        this.c.setLayoutParams(layoutParams);
        int i2 = ((int) (d2 * 0.592d)) / 100;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams2.width = i2;
        layoutParams2.height = i2;
        layoutParams2.addRule(13);
        this.d.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams3.bottomMargin = ((int) (2.8d * d)) / 100;
        layoutParams3.topMargin = i;
        layoutParams3.width = i;
        layoutParams3.height = i;
        this.e.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams4.addRule(12);
        layoutParams4.addRule(14);
        this.f.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams5.bottomMargin = ((int) (0.9d * d)) / 100;
        this.g.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams6.bottomMargin = ((int) (4.9d * d)) / 100;
        if (z) {
            layoutParams6.bottomMargin = ((int) (6.9d * d)) / 100;
        }
        this.h.setLayoutParams(layoutParams6);
        DisplayMetrics displayMetrics = this.k.f5096a.getResources().getDisplayMetrics();
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        int i3 = ((int) (((double) displayMetrics.widthPixels) * 13.7d)) / 100;
        layoutParams7.leftMargin = i3;
        layoutParams7.rightMargin = i3;
        layoutParams7.bottomMargin = ((int) (5.7d * d)) / 100;
        if (z) {
            layoutParams7.bottomMargin = ((int) (6.7d * d)) / 100;
        }
        layoutParams7.height = (iA * 6) / 100;
        this.i.setLayoutParams(layoutParams7);
        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams8.bottomMargin = ((int) (d * 1.8d)) / 100;
        layoutParams8.rightMargin = ((int) (((double) displayMetrics.widthPixels) * 3.6d)) / 100;
        this.j.setLayoutParams(layoutParams8);
    }
}
