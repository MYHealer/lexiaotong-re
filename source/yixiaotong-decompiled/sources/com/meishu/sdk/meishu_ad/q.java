package com.meishu.sdk.meishu_ad;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f5062a;
    public final /* synthetic */ RelativeLayout b;
    public final /* synthetic */ RelativeLayout c;
    public final /* synthetic */ ImageView d;
    public final /* synthetic */ v e;

    public q(v vVar, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2) {
        this.e = vVar;
        this.f5062a = imageView;
        this.b = relativeLayout;
        this.c = relativeLayout2;
        this.d = imageView2;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        v vVar = this.e;
        int i = vVar.c + 1;
        vVar.c = i;
        if (i % 2 == 0) {
            this.f5062a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.d.setVisibility(0);
            v vVar2 = this.e;
            ImageView imageView = this.d;
            vVar2.getClass();
            if (imageView != null) {
                imageView.post(new r(vVar2, imageView, 1));
            }
        } else {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            v vVar3 = this.e;
            RelativeLayout relativeLayout = this.b;
            ImageView imageView2 = this.f5062a;
            vVar3.getClass();
            if (imageView2 != null) {
                imageView2.post(new t(vVar3, relativeLayout, imageView2, 1));
            }
        }
        Handler handler = v.C;
        this.e.getClass();
        handler.postDelayed(this, 800L);
    }
}
