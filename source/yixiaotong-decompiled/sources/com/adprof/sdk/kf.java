package com.adprof.sdk;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class kf implements ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f1266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pf f425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f426a;

    public kf(pf pfVar, String str, ImageView imageView) {
        this.f425a = pfVar;
        this.f426a = str;
        this.f1266a = imageView;
    }

    @Override // com.adprof.sdk.ub
    public void a(Bitmap bitmap) {
        pk.a("-----loadSingleImage:  onBitmapLoaded " + this.f426a);
        try {
            this.f1266a.setImageBitmap(bitmap);
            this.f1266a.post(new Cif(this, bitmap));
        } catch (Throwable th) {
            pk.d("-----loadSingleImage: 22  " + Log.getStackTraceString(th));
        }
    }

    @Override // com.adprof.sdk.ub
    public void a(Exception exc) {
        pk.a("-----loadSingleImage:  onBitmapLoadFailed " + this.f426a);
        ImageView imageView = this.f1266a;
        if (imageView == null) {
            return;
        }
        imageView.post(new jf(this));
    }
}
