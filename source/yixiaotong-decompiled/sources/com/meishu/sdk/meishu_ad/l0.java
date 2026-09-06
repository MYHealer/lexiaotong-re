package com.meishu.sdk.meishu_ad;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l0 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalMediaView f5033a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ v c;

    /* JADX INFO: compiled from: AdNative.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f5034a;

        public a(Bitmap bitmap) {
            this.f5034a = bitmap;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                if (this.f5034a != null) {
                    l0.this.c.f5096a.getApplicationContext();
                    l0.this.b.setImageBitmap(com.meishu.sdk.core.utils.e0.a(this.f5034a, 25));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public l0(v vVar, NormalMediaView normalMediaView, ImageView imageView) {
        this.c = vVar;
        this.f5033a = normalMediaView;
        this.b = imageView;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            Bitmap videoThumb = this.f5033a.getVideoThumb();
            if (videoThumb != null) {
                SdkHandler.getInstance().runOnUiThread(new a(videoThumb));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
