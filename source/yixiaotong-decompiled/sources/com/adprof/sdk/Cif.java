package com.adprof.sdk;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.adprof.sdk.if, reason: invalid class name */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class Cif implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f1230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ kf f379a;

    public Cif(kf kfVar, Bitmap bitmap) {
        this.f379a = kfVar;
        this.f1230a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        pk.d("-----loadSingleImage:  run " + this.f379a.f426a);
        try {
            ViewGroup.LayoutParams layoutParams = this.f379a.f1266a.getLayoutParams();
            int measuredWidth = this.f379a.f425a.getMeasuredWidth();
            pk.d("-----loadSingleImage:  value =  " + measuredWidth + "    bitmap_width = " + this.f1230a.getWidth() + "    bitmap_height =  " + this.f1230a.getHeight());
            if (measuredWidth > 0 && this.f1230a.getWidth() > 0 && this.f1230a.getHeight() > 0) {
                int height = (this.f1230a.getHeight() * this.f379a.f425a.getMeasuredWidth()) / this.f1230a.getWidth();
                pf pfVar = this.f379a.f425a;
                if (pfVar.b > 40 && height >= h8.a(pfVar.getImageSetMaxHeightDP())) {
                    height = h8.a(this.f379a.f425a.getImageSetMaxHeightDP());
                }
                layoutParams.height = height;
                layoutParams.width = (height * this.f1230a.getWidth()) / this.f1230a.getHeight();
                pk.d("-----loadSingleImage:  target width =  " + layoutParams.width + "   height = " + layoutParams.height);
                this.f379a.f1266a.setLayoutParams(layoutParams);
            }
            this.f379a.f1266a.setVisibility(0);
        } catch (Throwable th) {
            pk.d("-----loadSingleImage: 11  " + Log.getStackTraceString(th));
            this.f379a.f1266a.setVisibility(0);
        }
    }
}
