package com.adprof.sdk;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class dd implements ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hd f1126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f211a;

    public dd(hd hdVar, String str) {
        this.f1126a = hdVar;
        this.f211a = str;
    }

    @Override // com.adprof.sdk.ub
    public void a(Exception exc) {
        pk.a("InterstitialView_one  onBitmapLoadFailed ------------");
        this.f1126a.d("image ad BitmapLoadFailed " + this.f211a + "  e: ");
    }

    public final void b(Bitmap bitmap) {
        pk.c("InterstitialView handleBlurView");
        ((vc) this.f1126a).f766a.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = ((vc) this.f1126a).f766a.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.f1126a.getMediaWidth();
            layoutParams.height = (this.f1126a.getMediaWidth() * 16) / 9;
            ((vc) this.f1126a).f766a.setLayoutParams(layoutParams);
        }
        Bitmap bitmapA = d6.a(((vc) this.f1126a).f774b, bitmap, 25.0f);
        ImageView imageView = ((vc) this.f1126a).f766a;
        if (imageView != null) {
            imageView.setImageBitmap(bitmapA);
        }
        z5 z5Var = ((vc) this.f1126a).f772a;
        if (z5Var != null) {
            z5Var.a(bitmapA);
        }
    }

    @Override // com.adprof.sdk.ub
    public void a(Bitmap bitmap) {
        if (pk.f594a) {
            pk.a("InterstitialView_one  onBitmapLoaded ------------: " + bitmap);
        }
        if (bitmap != null) {
            try {
                if (((x0) this.f1126a).f821a.m605f() || bitmap.getWidth() > bitmap.getHeight()) {
                    b(bitmap);
                }
            } catch (Throwable th) {
                pk.a(th);
            }
            try {
                if (((vc) this.f1126a).f777b.getDrawable() == null) {
                    this.f1126a.setPostImageBitmap(bitmap);
                }
                this.f1126a.findViewById(R.id.adprof_interstitial_close_text).bringToFront();
            } catch (Exception e) {
                pk.a(e);
            }
        }
    }
}
