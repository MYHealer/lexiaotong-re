package com.meishu.sdk.platform.oppo.recycler;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.bv.BaseConstants;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.ad.recycler.d;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPORecyclerAd extends a implements RecyclerAdData {
    private static final String TAG = "OPPORecyclerAd";
    private INativeAdvanceData nativeAdvanceData;
    private OPPORecyclerAdLoader oppoRecyclerAdLoader;
    private boolean showed;

    public OPPORecyclerAd(INativeAdvanceData iNativeAdvanceData, OPPORecyclerAdLoader oPPORecyclerAdLoader) {
        super(oPPORecyclerAdLoader, BaseConstants.ROM_OPPO_UPPER_CONSTANT);
        this.nativeAdvanceData = iNativeAdvanceData;
        this.oppoRecyclerAdLoader = oPPORecyclerAdLoader;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, final RecylcerAdInteractionListener recylcerAdInteractionListener) {
        ViewGroup viewGroupA = d.a(viewGroup);
        if (viewGroupA == null) {
            viewGroup.setTag(R.id.ms_ad_container_tag_recycler, "meishu_ad_container_tag_recycler");
        } else {
            viewGroup = viewGroupA;
        }
        d.b(viewGroup);
        NativeAdvanceContainer nativeAdvanceContainer = new NativeAdvanceContainer(viewGroup.getContext());
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
        if (viewGroup2 != null) {
            int iIndexOfChild = viewGroup2.indexOfChild(viewGroup);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            viewGroup2.removeView(viewGroup);
            nativeAdvanceContainer.setId(viewGroup.getId());
            nativeAdvanceContainer.addView(viewGroup, layoutParams2);
            viewGroup2.addView(nativeAdvanceContainer, iIndexOfChild, layoutParams);
        }
        this.nativeAdvanceData.setInteractListener(new INativeAdvanceInteractListener() { // from class: com.meishu.sdk.platform.oppo.recycler.OPPORecyclerAd.1
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onClick() {
                LogUtil.d(OPPORecyclerAd.TAG, "send onADClicked");
                if (OPPORecyclerAd.this.oppoRecyclerAdLoader.getSdkAdInfo() != null && !TextUtils.isEmpty(OPPORecyclerAd.this.oppoRecyclerAdLoader.getSdkAdInfo().getClk())) {
                    com.meishu.sdk.core.loader.a.a(OPPORecyclerAd.this.oppoRecyclerAdLoader.getContext(), f.a(OPPORecyclerAd.this.oppoRecyclerAdLoader.getSdkAdInfo().getClk(), OPPORecyclerAd.this));
                }
                RecylcerAdInteractionListener recylcerAdInteractionListener2 = recylcerAdInteractionListener;
                if (recylcerAdInteractionListener2 != null) {
                    recylcerAdInteractionListener2.onAdClicked();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onError(int i, String str) {
                LogUtil.e(OPPORecyclerAd.TAG, "onError: " + str + PPSLabelView.Code + i);
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener
            public void onShow() {
                if (OPPORecyclerAd.this.showed) {
                    return;
                }
                if (OPPORecyclerAd.this.oppoRecyclerAdLoader.getLoaderListener() != null) {
                    OPPORecyclerAd.this.oppoRecyclerAdLoader.getLoaderListener().onAdExposure();
                }
                OPPORecyclerAd.this.showed = true;
            }
        });
        this.nativeAdvanceData.bindToView(context, nativeAdvanceContainer, list);
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, final RecyclerAdMediaListener recyclerAdMediaListener) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ms_oppo_media_view, viewGroup, false);
        MediaView mediaView = (MediaView) viewInflate.findViewById(R.id.ms_oppo_media_view);
        viewGroup.removeAllViews();
        viewGroup.addView(viewInflate);
        this.nativeAdvanceData.bindMediaView(viewGroup.getContext(), mediaView, new INativeAdvanceMediaListener() { // from class: com.meishu.sdk.platform.oppo.recycler.OPPORecyclerAd.2
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayError(int i, String str) {
                LogUtil.e(OPPORecyclerAd.TAG, "onVideoPlayError " + str + PPSLabelView.Code + i);
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayComplete() {
                RecyclerAdMediaListener recyclerAdMediaListener2 = recyclerAdMediaListener;
                if (recyclerAdMediaListener2 != null) {
                    recyclerAdMediaListener2.onVideoCompleted();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener
            public void onVideoPlayStart() {
                RecyclerAdMediaListener recyclerAdMediaListener2 = recyclerAdMediaListener;
                if (recyclerAdMediaListener2 != null) {
                    recyclerAdMediaListener2.onVideoStart();
                }
            }
        });
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        switch (this.nativeAdvanceData.getCreativeType()) {
            case 8:
                return 13;
            case 9:
            case 10:
            case 11:
            case 13:
                return 2;
            case 12:
            default:
                return 12;
        }
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
        return this.nativeAdvanceData.getDesc();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        return this.nativeAdvanceData.getDesc();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        return BaseConstants.ROM_OPPO_UPPER_CONSTANT;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        if (this.nativeAdvanceData.getLogoFile() != null) {
            return this.nativeAdvanceData.getLogoFile().getUrl();
        }
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
        return (this.nativeAdvanceData.getIconFiles() == null || this.nativeAdvanceData.getIconFiles().isEmpty()) ? "" : this.nativeAdvanceData.getIconFiles().get(0).getUrl();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        if (this.nativeAdvanceData.getImgFiles() == null) {
            return new String[]{""};
        }
        String[] strArr = new String[this.nativeAdvanceData.getImgFiles().size()];
        for (int i = 0; i < this.nativeAdvanceData.getImgFiles().size(); i++) {
            strArr[i] = this.nativeAdvanceData.getImgFiles().get(i).getUrl();
        }
        return strArr;
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
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return BaseConstants.ROM_OPPO_UPPER_CONSTANT;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        return this.nativeAdvanceData.getTitle();
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
        int adPatternType = this.oppoRecyclerAdLoader.getAdLoader().getAdPatternType();
        if (adPatternType == 200000) {
            return 2 == this.oppoRecyclerAdLoader.getSdkAdInfo().getDrawing();
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
        INativeAdvanceData iNativeAdvanceData = this.nativeAdvanceData;
        if (iNativeAdvanceData != null) {
            iNativeAdvanceData.release();
        }
    }
}
