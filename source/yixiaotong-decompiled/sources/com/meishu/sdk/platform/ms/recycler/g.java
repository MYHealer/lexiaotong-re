package com.meishu.sdk.platform.ms.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.domain.LayoutBean;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.e0;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import java.util.Hashtable;

/* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5189a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ImageView c;
    public final /* synthetic */ LayoutBean.StyleBean d;
    public final /* synthetic */ RelativeLayout e;
    public final /* synthetic */ i f;

    /* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f5190a;

        public a(Bitmap bitmap) {
            this.f5190a = bitmap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            if (this.f5190a != null) {
                Integer accept_ad_width = ((RecyclerMixAdLoader) g.this.f.b.getAdLoader()).getAccept_ad_width();
                Integer accept_ad_height = ((RecyclerMixAdLoader) g.this.f.b.getAdLoader()).getAccept_ad_height();
                Bitmap.Config config = this.f5190a.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                Bitmap bitmapCopy = config == config2 ? this.f5190a : this.f5190a.copy(config2, true);
                if (bitmapCopy != null) {
                    g.this.b.getApplicationContext();
                    Bitmap bitmapA = e0.a(bitmapCopy, 25);
                    if (bitmapA != null) {
                        int width = this.f5190a.getWidth();
                        int height = this.f5190a.getHeight();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) g.this.c.getLayoutParams();
                        if (accept_ad_width != null && accept_ad_width.intValue() > 0) {
                            accept_ad_width.intValue();
                        }
                        if (accept_ad_height != null && accept_ad_height.intValue() > 0) {
                            height = accept_ad_height.intValue();
                        }
                        LayoutBean.StyleBean styleBean = g.this.d;
                        if (styleBean != null && (styleBean.getType() == 201 || g.this.d.getType() == 101 || g.this.d.getType() == 601)) {
                            if ((width * 1.0f) / height >= 1.77d || accept_ad_height == null || accept_ad_height.intValue() != -1) {
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) g.this.e.getLayoutParams();
                                layoutParams2.width = -1;
                                layoutParams2.height = -2;
                                g.this.e.setLayoutParams(layoutParams2);
                            } else {
                                height = (int) Math.round(((double) g.this.b.getResources().getDisplayMetrics().widthPixels) / 1.77d);
                                int iRound = (int) Math.round(((double) height) * 1.77d);
                                layoutParams.width = -1;
                                layoutParams.height = height;
                                layoutParams.addRule(14);
                                g.this.c.setLayoutParams(layoutParams);
                                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) g.this.e.getLayoutParams();
                                layoutParams3.width = -1;
                                layoutParams3.height = height;
                                g.this.e.setLayoutParams(layoutParams3);
                                ((NormalMediaView) g.this.f.f5193a.getMediaView()).setContainerWidth(iRound);
                                ((NormalMediaView) g.this.f.f5193a.getMediaView()).setContainerHeight(height);
                                ((NormalMediaView) g.this.f.f5193a.getMediaView()).S = true;
                            }
                        }
                        LayoutBean.StyleBean styleBean2 = g.this.d;
                        if (styleBean2 != null && ((styleBean2.getType() == 301 || g.this.d.getType() == 401) && (width * 1.0f) / height < 1.77d && accept_ad_height != null && accept_ad_height.intValue() == -1)) {
                            ((NormalMediaView) g.this.f.f5193a.getMediaView()).S = true;
                        }
                        g.this.c.setImageBitmap(bitmapA);
                    }
                }
            }
            g.this.e.setVisibility(0);
        }
    }

    public g(i iVar, String str, Context context, ImageView imageView, LayoutBean.StyleBean styleBean, RelativeLayout relativeLayout) {
        this.f = iVar;
        this.f5189a = str;
        this.b = context;
        this.c = imageView;
        this.d = styleBean;
        this.e = relativeLayout;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        Bitmap frameAtTime;
        try {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f5189a, new Hashtable());
                frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                frameAtTime = null;
            }
            SdkHandler.getInstance().runOnUiThread(new a(frameAtTime));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
