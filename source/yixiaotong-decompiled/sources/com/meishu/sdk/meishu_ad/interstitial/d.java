package com.meishu.sdk.meishu_ad.interstitial;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.SdkHandler;
import java.util.HashMap;

/* JADX INFO: compiled from: NativeInterstitialAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f5025a;
    public final /* synthetic */ c b;

    /* JADX INFO: compiled from: NativeInterstitialAd.java */
    public class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f5026a;

        public a(Bitmap bitmap) {
            this.f5026a = bitmap;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                d.this.b.e = this.f5026a.getHeight();
                d.this.b.f = this.f5026a.getWidth();
                d dVar = d.this;
                c cVar = dVar.b;
                if (cVar.e > cVar.f) {
                    cVar.d = 2;
                }
                c.a(cVar, dVar.f5025a, cVar.a().getAct_type());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public d(c cVar, Activity activity) {
        this.b = cVar;
        this.f5025a = activity;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.b.a().getImageUrls()[0], new HashMap());
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (frameAtTime == null || jCurrentTimeMillis2 >= 1000) {
                c cVar = this.b;
                c.a(cVar, this.f5025a, cVar.a().getAct_type());
            } else {
                SdkHandler.getInstance().runOnUiThread(new a(frameAtTime));
            }
        } catch (Throwable th) {
            com.meishu.sdk.meishu_ad.interstitial.a aVar = this.b.b;
            if (aVar != null) {
                ((com.meishu.sdk.platform.ms.interstitial.a) aVar).onAdRenderFail("插屏视频渲染失败", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
            }
            th.printStackTrace();
        }
    }
}
