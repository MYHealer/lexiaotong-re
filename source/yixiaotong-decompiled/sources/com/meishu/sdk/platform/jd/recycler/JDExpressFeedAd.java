package com.meishu.sdk.platform.jd.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.feed.JADFeed;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDExpressFeedAd extends a implements RecyclerAdData {
    private JDFeedAdWrapper adWrapper;
    private JADFeed feedAd;
    private RecylcerAdInteractionListener recylcerAdInteractionListener;

    public JDExpressFeedAd(JDFeedAdWrapper jDFeedAdWrapper) {
        super(jDFeedAdWrapper, "JD");
        this.adWrapper = jDFeedAdWrapper;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        JDFeedAdWrapper jDFeedAdWrapper = this.adWrapper;
        if (jDFeedAdWrapper != null && jDFeedAdWrapper.getSdkAdInfo() != null) {
            o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
        }
        this.recylcerAdInteractionListener = recylcerAdInteractionListener;
        if (viewGroup == null || getAdView() == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(getAdView());
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        return 100000;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public List<MeishuAdInfo.PermissionBean> getAppPermissionList() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        return 0L;
    }

    public JADFeed getFeedAd() {
        return this.feedAd;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        return new String[0];
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        JADFeed jADFeed = this.feedAd;
        if (jADFeed == null || jADFeed.getExtra() == null) {
            return null;
        }
        return this.feedAd.getExtra().getPrice() + "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return "JD";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
    }

    public RecylcerAdInteractionListener getRecylcerAdInteractionListener() {
        return this.recylcerAdInteractionListener;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        return "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        int adPatternType = this.adWrapper.getAdLoader().getAdPatternType();
        if (adPatternType == 200000) {
            return 2 == this.adWrapper.getSdkAdInfo().getDrawing();
        }
        return adPatternType == 100000;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void mute() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void replay() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setDownloadStatusListener(DownloadStatusListener downloadStatusListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
    }

    public void setFeedAd(JADFeed jADFeed) {
        this.feedAd = jADFeed;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void startVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void unmute() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
        JADFeed jADFeed = this.feedAd;
        if (jADFeed != null) {
            jADFeed.destroy();
            this.feedAd = null;
        }
    }
}
