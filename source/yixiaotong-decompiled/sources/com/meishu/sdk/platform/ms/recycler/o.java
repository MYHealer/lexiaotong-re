package com.meishu.sdk.platform.ms.recycler;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.widget.ImageView;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.e0;

/* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f5226a;
    public final /* synthetic */ l b;

    public o(l lVar, ImageView imageView) {
        this.b = lVar;
        this.f5226a = imageView;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        String str;
        String str2;
        Bitmap frameAtTime = null;
        try {
            try {
                l lVar = this.b;
                lVar.getClass();
                try {
                    str = lVar.getAdPatternType() == 2 ? lVar.getImgUrls()[0] : null;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (!TextUtils.isEmpty(str)) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    l lVar2 = this.b;
                    lVar2.getClass();
                    try {
                        str2 = lVar2.getAdPatternType() == 2 ? lVar2.getImgUrls()[0] : null;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    mediaMetadataRetriever.setDataSource(str2);
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            if (frameAtTime != null) {
                SdkHandler.getInstance().runOnUiThread(new a(frameAtTime));
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: MeishuRecyclerAdDataAdapter.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f5227a;

        public a(Bitmap bitmap) {
            this.f5227a = bitmap;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                Bitmap bitmap = this.f5227a;
                if (bitmap != null) {
                    Bitmap.Config config = bitmap.getConfig();
                    Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                    Bitmap bitmapCopy = config == config2 ? this.f5227a : this.f5227a.copy(config2, true);
                    if (bitmapCopy != null) {
                        AdSdk.getContext();
                        Bitmap bitmapA = e0.a(bitmapCopy, 25);
                        if (bitmapA != null) {
                            o.this.f5226a.setImageBitmap(bitmapA);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
