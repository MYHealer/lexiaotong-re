package com.jd.ad.sdk.jad_f_an;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;

/* JADX INFO: compiled from: JADFeedRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_f_hu implements OnImageLoadListener {
    public final /* synthetic */ ImageView jad_f_an;

    public jad_f_hu(com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar, ImageView imageView) {
        this.jad_f_an = imageView;
    }

    @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
    public void onLoadFailed(int i, String str, Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
    public void onLoadSuccess(Drawable drawable) {
        ImageView imageView = this.jad_f_an;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }
}
