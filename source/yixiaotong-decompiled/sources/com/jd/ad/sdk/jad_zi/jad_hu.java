package com.jd.ad.sdk.jad_zi;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.jad_mx.jad_ly;
import com.jd.ad.sdk.jad_mx.jad_sf;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADFoundationService;

/* JADX INFO: compiled from: JADFoundationServiceImplementor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu implements JADFoundationService {
    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public Application getApplication() {
        return com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public boolean isNetAvailable() {
        Application applicationJad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        return (applicationJad_an == null || com.jd.ad.sdk.jad_qd.jad_iv.jad_an(applicationJad_an) == 0) ? false : true;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public void loadImage(Context context, String str, OnImageLoadListener onImageLoadListener) {
        if (!com.jd.ad.sdk.jad_fq.jad_dq.jad_an(context) || TextUtils.isEmpty(str) || onImageLoadListener == null) {
            return;
        }
        com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(context).jad_an(str).jad_an(jad_ly.jad_cp).jad_bo(new jad_bo(this)).jad_an(new jad_an(this, onImageLoadListener));
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public void preloadImage(Context context, String str, OnImageLoadListener onImageLoadListener) {
        if (com.jd.ad.sdk.jad_fq.jad_dq.jad_an(context) && !TextUtils.isEmpty(str)) {
            com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(context).jad_an(str).jad_an(jad_ly.jad_bo).jad_bo(new jad_cp(this, onImageLoadListener)).jad_dq();
        }
    }

    /* JADX INFO: compiled from: JADFoundationServiceImplementor.java */
    public class jad_bo implements com.jd.ad.sdk.jad_en.jad_jt<Drawable> {
        public jad_bo(jad_hu jad_huVar) {
        }

        @Override // com.jd.ad.sdk.jad_en.jad_jt
        public boolean jad_an(Drawable drawable, Object obj, com.jd.ad.sdk.jad_fo.jad_er<Drawable> jad_erVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, boolean z) {
            Logger.d("preload 加载图片 成功");
            return false;
        }

        @Override // com.jd.ad.sdk.jad_en.jad_jt
        public boolean jad_an(jad_sf jad_sfVar, Object obj, com.jd.ad.sdk.jad_fo.jad_er<Drawable> jad_erVar, boolean z) {
            Logger.d("preload 加载图片 失败");
            return false;
        }
    }

    /* JADX INFO: compiled from: JADFoundationServiceImplementor.java */
    public class jad_cp implements com.jd.ad.sdk.jad_en.jad_jt<Drawable> {
        public final /* synthetic */ OnImageLoadListener jad_an;

        public jad_cp(jad_hu jad_huVar, OnImageLoadListener onImageLoadListener) {
            this.jad_an = onImageLoadListener;
        }

        @Override // com.jd.ad.sdk.jad_en.jad_jt
        public boolean jad_an(Drawable drawable, Object obj, com.jd.ad.sdk.jad_fo.jad_er<Drawable> jad_erVar, com.jd.ad.sdk.jad_ju.jad_an jad_anVar, boolean z) {
            this.jad_an.onLoadSuccess(null);
            return false;
        }

        @Override // com.jd.ad.sdk.jad_en.jad_jt
        public boolean jad_an(jad_sf jad_sfVar, Object obj, com.jd.ad.sdk.jad_fo.jad_er<Drawable> jad_erVar, boolean z) {
            this.jad_an.onLoadFailed(-1, "load error", null);
            return false;
        }
    }

    /* JADX INFO: compiled from: JADFoundationServiceImplementor.java */
    public class jad_an extends com.jd.ad.sdk.jad_fo.jad_an<Drawable> {
        public final /* synthetic */ OnImageLoadListener jad_dq;

        public jad_an(jad_hu jad_huVar, OnImageLoadListener onImageLoadListener) {
            this.jad_dq = onImageLoadListener;
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(Object obj, com.jd.ad.sdk.jad_gp.jad_bo jad_boVar) {
            Drawable drawable = (Drawable) obj;
            Logger.d("preload 加载图片 onResourceReady");
            OnImageLoadListener onImageLoadListener = this.jad_dq;
            if (onImageLoadListener != null) {
                onImageLoadListener.onLoadSuccess(drawable);
            }
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_an, com.jd.ad.sdk.jad_fo.jad_er
        public void jad_cp(Drawable drawable) {
            Logger.d("preload 加载图片 onLoadFailed");
            OnImageLoadListener onImageLoadListener = this.jad_dq;
            if (onImageLoadListener != null) {
                onImageLoadListener.onLoadFailed(-1, "load error", drawable);
            }
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(Drawable drawable) {
            Logger.d("preload 加载图片 onLoadCleared");
        }
    }
}
