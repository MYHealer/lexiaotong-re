package com.meishu.sdk.core.ad.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.s2s.ISBidding;
import com.meishu.sdk.core.utils.ResultBean;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface RecyclerAdData extends ISBidding {
    void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener);

    void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener);

    void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener);

    void destroy();

    String getActionText();

    int getAdPatternType();

    View getAdView();

    String getAppIntro();

    String getAppIntroUrl();

    String getAppName();

    List<MeishuAdInfo.PermissionBean> getAppPermissionList();

    String getAppPremissionUrl();

    String getAppSize();

    String getAppVersion();

    String getContent();

    MsCustomVideo getCustomVideo();

    ResultBean getData();

    String getDesc();

    String getDeveloper();

    long getDuration();

    String getFrom();

    String getFromId();

    String getFromLogo();

    int getHeight();

    String getIconTitle();

    String getIconUrl();

    String[] getImgUrls();

    int getInteractionType();

    View getMediaView();

    String getPackageName();

    String getPlatFormEcpm();

    String getPlatform();

    String getPrivacyAgreement();

    String getTitle();

    String getVideoCover();

    String getVideoUrl();

    int getWidth();

    boolean isAdValid();

    boolean isNativeExpress();

    void mute();

    void pauseVideo();

    void replay();

    void resumeVideo();

    void setDownloadStatusListener(DownloadStatusListener downloadStatusListener);

    void setExpressMediaListener(ExpressMediaListener expressMediaListener);

    void startVideo();

    void stopVideo();

    void unmute();
}
