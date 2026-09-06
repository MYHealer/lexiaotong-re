package com.adprof.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class gk implements ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jk f1194a;

    public gk(jk jkVar) {
        this.f1194a = jkVar;
    }

    @Override // com.adprof.sdk.ub
    public void a(Bitmap bitmap) {
        ViewGroup.LayoutParams layoutParams;
        DisplayMetrics displayMetrics;
        if (pk.f594a) {
            pk.a("RewardView_one  onBitmapLoaded ------------: " + bitmap);
        }
        if (bitmap != null) {
            try {
                ImageView imageView = ((yj) this.f1194a).f869b;
                if (imageView != null && imageView.getDrawable() == null) {
                    ((yj) this.f1194a).f869b.setImageBitmap(bitmap);
                }
                jk jkVar = this.f1194a;
                if (((x0) jkVar).f821a.f199b && (layoutParams = ((yj) jkVar).f860a.getLayoutParams()) != null) {
                    Context context = he.m644a().f350a;
                    String str = g8.f312a;
                    if (context != null) {
                        try {
                            displayMetrics = context.getResources().getDisplayMetrics();
                        } catch (Throwable th) {
                            pk.b("getDisplayMetrics error: ", th);
                            displayMetrics = null;
                        }
                        layoutParams.height = displayMetrics.heightPixels;
                        ((yj) this.f1194a).f860a.setLayoutParams(layoutParams);
                    } else {
                        displayMetrics = null;
                        layoutParams.height = displayMetrics.heightPixels;
                        ((yj) this.f1194a).f860a.setLayoutParams(layoutParams);
                    }
                }
                Bitmap bitmapA = d6.a(((x0) this.f1194a).f817a, bitmap, 25.0f);
                ImageView imageView2 = ((yj) this.f1194a).f860a;
                if (imageView2 != null) {
                    imageView2.setImageBitmap(bitmapA);
                }
            } catch (Throwable th2) {
                pk.a(th2);
                oh.b(th2);
            }
        }
    }

    @Override // com.adprof.sdk.ub
    public void a(Exception exc) {
    }
}
