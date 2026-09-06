package com.meishu.sdk.platform.csj.draw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.draw.DrawAd;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJNativeDrawAd extends DrawAd {
    private static final String TAG = "CSJNativeDrawAd";
    private d adWrapper;
    private boolean hasExposed;
    private List<String> imgList;
    private TTDrawFeedAd ttDrawFeedAd;

    public CSJNativeDrawAd(d dVar, TTDrawFeedAd tTDrawFeedAd) {
        super(dVar, MSAdConfig.PLATFORM_CSJ);
        this.imgList = new ArrayList();
        this.adWrapper = dVar;
        this.ttDrawFeedAd = tTDrawFeedAd;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void destroy() {
        super.destroy();
        if (this.ttDrawFeedAd != null) {
            this.ttDrawFeedAd = null;
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public int getDrawType() {
        return 1;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public String getIconUrl() {
        TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
        return (tTDrawFeedAd == null || tTDrawFeedAd.getIcon() == null) ? super.getIconUrl() : this.ttDrawFeedAd.getIcon().getImageUrl();
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public List<String> getImageUrl() {
        try {
            TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
            if (tTDrawFeedAd != null && tTDrawFeedAd.getImageList() != null && this.ttDrawFeedAd.getImageList().size() > 0) {
                this.imgList.clear();
                Iterator<TTImage> it = this.ttDrawFeedAd.getImageList().iterator();
                while (it.hasNext()) {
                    this.imgList.add(it.next().getImageUrl());
                }
                return this.imgList;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.getImageUrl();
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public Bitmap getAdLogo() {
        TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
        return tTDrawFeedAd != null ? tTDrawFeedAd.getAdLogo() : super.getAdLogo();
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public String getDescription() {
        TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
        return tTDrawFeedAd != null ? tTDrawFeedAd.getDescription() : super.getDescription();
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public int getImageMode() {
        try {
            TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
            if (tTDrawFeedAd != null) {
                int imageMode = tTDrawFeedAd.getImageMode();
                if (imageMode == 2) {
                    return 11;
                }
                if (imageMode != 3) {
                    if (imageMode == 4) {
                        return 13;
                    }
                    if (imageMode == 5) {
                        return 2;
                    }
                }
                return 12;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.getImageMode();
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public String getSource() {
        TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
        return tTDrawFeedAd != null ? tTDrawFeedAd.getSource() : super.getSource();
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public String getTitle() {
        TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
        return tTDrawFeedAd != null ? tTDrawFeedAd.getTitle() : super.getTitle();
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void setActivityForDownloadApp(Activity activity) {
        try {
            TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
            if (tTDrawFeedAd != null) {
                tTDrawFeedAd.setActivityForDownloadApp(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void setCanInterruptVideoPlay(boolean z) {
        TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
        if (tTDrawFeedAd != null) {
            tTDrawFeedAd.setCanInterruptVideoPlay(z);
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void setPauseIcon(Bitmap bitmap, int i) {
        TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
        if (tTDrawFeedAd != null) {
            tTDrawFeedAd.setPauseIcon(bitmap, i);
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void bindAdToView(ViewGroup viewGroup, ViewGroup viewGroup2, List<View> list, final RecylcerAdInteractionListener recylcerAdInteractionListener) {
        try {
            if (this.ttDrawFeedAd != null) {
                if (viewGroup2 != null) {
                    viewGroup2.removeAllViews();
                    viewGroup2.addView(this.ttDrawFeedAd.getAdView());
                }
                this.ttDrawFeedAd.registerViewForInteraction(viewGroup, list, list, new TTNativeAd.AdInteractionListener() { // from class: com.meishu.sdk.platform.csj.draw.CSJNativeDrawAd.1
                    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                        try {
                            LogUtil.d(CSJNativeDrawAd.TAG, "onAdCreativeClick");
                            if (CSJNativeDrawAd.this.adWrapper != null && !TextUtils.isEmpty(CSJNativeDrawAd.this.adWrapper.getSdkAdInfo().getClk())) {
                                LogUtil.d(CSJNativeDrawAd.TAG, "send onAdClicked");
                                z.a(CSJNativeDrawAd.this.adWrapper.getContext(), f.a(CSJNativeDrawAd.this.adWrapper.getSdkAdInfo().getClk(), CSJNativeDrawAd.this), new i());
                            }
                            RecylcerAdInteractionListener recylcerAdInteractionListener2 = recylcerAdInteractionListener;
                            if (recylcerAdInteractionListener2 != null) {
                                recylcerAdInteractionListener2.onAdClicked();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                    public void onAdShow(TTNativeAd tTNativeAd) {
                        try {
                            if (CSJNativeDrawAd.this.hasExposed || CSJNativeDrawAd.this.adWrapper.getLoaderListener() == null) {
                                return;
                            }
                            CSJNativeDrawAd.this.hasExposed = true;
                            CSJNativeDrawAd.this.adWrapper.getLoaderListener().onAdExposure();
                            if (CSJNativeDrawAd.this.getInteractionListener() != null) {
                                CSJNativeDrawAd.this.getInteractionListener().onAdExposure();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public int getInteractionType() {
        try {
            TTDrawFeedAd tTDrawFeedAd = this.ttDrawFeedAd;
            if (tTDrawFeedAd != null) {
                int interactionType = tTDrawFeedAd.getInteractionType();
                return (interactionType == 2 || interactionType == 3 || interactionType != 4) ? 0 : 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.getInteractionType();
    }
}
