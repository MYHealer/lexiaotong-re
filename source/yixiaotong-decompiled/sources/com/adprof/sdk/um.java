package com.adprof.sdk;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class um implements ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ an f1464a;

    public um(an anVar) {
        this.f1464a = anVar;
    }

    @Override // com.adprof.sdk.ub
    public void a(Bitmap bitmap) {
        if (pk.f594a) {
            pk.a("SplashBaseView ------blurImage------onBitmapLoaded------------: " + bitmap);
        }
        if (bitmap == null) {
            return;
        }
        try {
            zl zlVar = this.f1464a.f31a;
            if (zlVar == null) {
                return;
            }
            if (zlVar.mo586a()) {
                zlVar.a(((x0) this.f1464a).f821a, bitmap);
            }
            Bitmap bitmapA = d6.a(((x0) this.f1464a).f817a, bitmap, 25.0f);
            ImageView imageView = ((qm) this.f1464a).f683a;
            if (imageView != null) {
                imageView.setImageBitmap(bitmapA);
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    @Override // com.adprof.sdk.ub
    public void a(Exception exc) {
    }
}
