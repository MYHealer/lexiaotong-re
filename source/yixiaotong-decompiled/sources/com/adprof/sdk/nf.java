package com.adprof.sdk;

import android.widget.RelativeLayout;
import com.adprof.sdk.base.view.gif.GifImageView2;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class nf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pf f1324a;

    public nf(pf pfVar) {
        this.f1324a = pfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView2 gifImageView2;
        try {
            pf pfVar = this.f1324a;
            if (pfVar.f580a != null && (gifImageView2 = pfVar.f581a) != null) {
                int[] iArr = new int[2];
                gifImageView2.getLocationInWindow(iArr);
                int height = this.f1324a.f581a.getHeight();
                this.f1324a.f581a.getWidth();
                int[] iArr2 = new int[2];
                this.f1324a.getLocationInWindow(iArr2);
                this.f1324a.f580a.measure(0, 0);
                int measuredHeight = this.f1324a.f580a.getMeasuredHeight();
                int measuredWidth = this.f1324a.f580a.getMeasuredWidth();
                int iA = ((iArr[0] - iArr2[0]) - measuredWidth) - h8.a(8.0f);
                int i = (iArr[1] - iArr2[1]) + ((height - measuredHeight) / 2);
                if (iA < 0) {
                    iA = (iArr[0] - iArr2[0]) - measuredWidth;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f1324a.f580a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.addRule(10, 0);
                    layoutParams.addRule(20, 0);
                    layoutParams.topMargin = i;
                    layoutParams.leftMargin = iA;
                    this.f1324a.f580a.setLayoutParams(layoutParams);
                }
                this.f1324a.f580a.bringToFront();
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
