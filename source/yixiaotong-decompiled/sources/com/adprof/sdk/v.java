package com.adprof.sdk;

import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewGroup f761a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public v(ViewGroup viewGroup, int i, int i2, int i3) {
        this.f761a = viewGroup;
        this.f1467a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        ViewGroup viewGroup = this.f761a;
        if (viewGroup == null) {
            return;
        }
        try {
            int measuredWidth = (viewGroup.getMeasuredWidth() * 9) / 16;
            if (this.f1467a != 0 && this.b != 0) {
                measuredWidth = (this.f761a.getMeasuredWidth() * this.f1467a) / this.b;
            }
            int i2 = this.c;
            if (i2 > 0 && measuredWidth > i2) {
                measuredWidth = i2;
            }
            int i3 = this.f1467a;
            int i4 = (i3 == 0 || (i = this.b) == 0) ? (measuredWidth * 16) / 9 : (i * measuredWidth) / i3;
            ViewGroup.LayoutParams layoutParams = this.f761a.getLayoutParams();
            layoutParams.height = measuredWidth;
            layoutParams.width = i4;
        } catch (Exception e) {
            pk.a("-------bindMediaView:Exception  " + e.getMessage());
        }
    }
}
