package com.meishu.sdk.meishu_ad;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f5061a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ RelativeLayout c;
    public final /* synthetic */ v d;

    public p(v vVar, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout) {
        this.d = vVar;
        this.f5061a = imageView;
        this.b = imageView2;
        this.c = relativeLayout;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        v vVar = this.d;
        int i = vVar.c + 1;
        vVar.c = i;
        if (i % 2 == 0) {
            this.f5061a.setVisibility(8);
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            v vVar2 = this.d;
            ImageView imageView = this.b;
            vVar2.getClass();
            if (imageView != null) {
                imageView.post(new r(vVar2, imageView, 1));
            }
        } else {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.f5061a.setVisibility(0);
            v vVar3 = this.d;
            ImageView imageView2 = this.f5061a;
            vVar3.getClass();
            if (imageView2 != null) {
                imageView2.post(new s(vVar3, imageView2, 1));
            }
        }
        Handler handler = v.C;
        this.d.getClass();
        handler.postDelayed(this, 800L);
    }
}
