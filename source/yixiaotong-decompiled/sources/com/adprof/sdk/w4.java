package com.adprof.sdk;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class w4 implements ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f1492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ g5 f792a;

    public w4(g5 g5Var, ImageView imageView) {
        this.f792a = g5Var;
        this.f1492a = imageView;
    }

    @Override // com.adprof.sdk.ub
    public void a(Bitmap bitmap) {
        ImageView imageView;
        try {
            Bitmap bitmapA = d6.a(this.f792a.getContext(), bitmap, 20.0f);
            this.f1492a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f1492a.setImageBitmap(bitmapA);
            this.f1492a.setAlpha(0.6f);
        } catch (Throwable unused) {
            if (bitmap == null || (imageView = this.f1492a) == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            this.f1492a.setAlpha(0.6f);
        }
    }

    @Override // com.adprof.sdk.ub
    public void a(Exception exc) {
    }
}
