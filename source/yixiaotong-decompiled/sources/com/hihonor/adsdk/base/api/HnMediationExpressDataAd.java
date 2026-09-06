package com.hihonor.adsdk.base.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.heytap.msp.mobad.api.ad.NativeAd;
import com.hihonor.adsdk.base.api.BaseExpressAd;
import com.hihonor.adsdk.base.bean.DetailPageCtrl;
import com.hihonor.adsdk.base.bean.Style;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.callback.DislikeItemClickListener;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnMediationExpressDataAd<T extends BaseExpressAd> implements BaseExpressAd, BaseAd, Parcelable {
    public static final Parcelable.Creator<HnMediationExpressDataAd> CREATOR = new a();
    private static final String TAG = "HnMediationExpressDataAd";
    protected T hnadsd;
    protected AdListener hnadse;
    protected String hnadsf;
    protected String hnadsg;
    protected String hnadsh;
    protected int hnadsi;

    class a implements Parcelable.Creator<HnMediationExpressDataAd> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public HnMediationExpressDataAd createFromParcel(Parcel parcel) {
            return new HnMediationExpressDataAd(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public HnMediationExpressDataAd[] newArray(int i) {
            return new HnMediationExpressDataAd[i];
        }
    }

    private class b extends AdListener {
        private b() {
        }

        @Override // com.hihonor.adsdk.base.callback.AdListener
        public void onAdClicked() {
            com.hihonor.adsdk.common.b.b.hnadsc(HnMediationExpressDataAd.TAG, "AdType:【%s】,onAdClicked", HnMediationExpressDataAd.this.hnadsa());
            HnMediationExpressDataAd hnMediationExpressDataAd = HnMediationExpressDataAd.this;
            com.hihonor.adsdk.base.g.b.hnadsa(105, hnMediationExpressDataAd.hnadse, hnMediationExpressDataAd.hnadsb().hnadsa());
        }

        @Override // com.hihonor.adsdk.base.callback.AdListener
        public void onAdClosed() {
            com.hihonor.adsdk.common.b.b.hnadsc(HnMediationExpressDataAd.TAG, "AdType:【%s】,onAdClosed", HnMediationExpressDataAd.this.hnadsa());
            HnMediationExpressDataAd hnMediationExpressDataAd = HnMediationExpressDataAd.this;
            com.hihonor.adsdk.base.g.b.hnadsa(106, hnMediationExpressDataAd.hnadse, hnMediationExpressDataAd.hnadsb().hnadsa());
        }

        @Override // com.hihonor.adsdk.base.callback.AdListener
        public void onAdImpression() {
            com.hihonor.adsdk.common.b.b.hnadsc(HnMediationExpressDataAd.TAG, "AdType:【%s】,onAdImpression", HnMediationExpressDataAd.this.hnadsa());
            HnMediationExpressDataAd hnMediationExpressDataAd = HnMediationExpressDataAd.this;
            com.hihonor.adsdk.base.g.b.hnadsa(103, hnMediationExpressDataAd.hnadse, hnMediationExpressDataAd.hnadsb().hnadsa());
        }

        @Override // com.hihonor.adsdk.base.callback.AdListener
        public void onAdImpressionFailed(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(HnMediationExpressDataAd.TAG, "AdType:【%s】,onAdImpressionFailed#msg=%s", HnMediationExpressDataAd.this.hnadsa(), str);
        }

        @Override // com.hihonor.adsdk.base.callback.AdListener
        public void onAdSkip(int i) {
            com.hihonor.adsdk.common.b.b.hnadsc(HnMediationExpressDataAd.TAG, "AdType:【%s】,onAdSkip#type=%s", HnMediationExpressDataAd.this.hnadsa(), Integer.valueOf(i));
            HnMediationExpressDataAd hnMediationExpressDataAd = HnMediationExpressDataAd.this;
            com.hihonor.adsdk.base.g.b.hnadsa(108, hnMediationExpressDataAd.hnadse, hnMediationExpressDataAd.hnadsb().hnadsi(i).hnadsk(i == 0 ? "ad skip" : "time over").hnadsa());
        }

        @Override // com.hihonor.adsdk.base.callback.AdListener
        public void onMiniAppStarted() {
            com.hihonor.adsdk.common.b.b.hnadsc(HnMediationExpressDataAd.TAG, "AdType:【%s】,onMiniAppStarted", HnMediationExpressDataAd.this.hnadsa());
            HnMediationExpressDataAd hnMediationExpressDataAd = HnMediationExpressDataAd.this;
            com.hihonor.adsdk.base.g.b.hnadsa(119, hnMediationExpressDataAd.hnadse, hnMediationExpressDataAd.hnadsb().hnadsa());
        }

        /* synthetic */ b(HnMediationExpressDataAd hnMediationExpressDataAd, a aVar) {
            this();
        }
    }

    public HnMediationExpressDataAd(T t) {
        this.hnadsd = t;
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "init HnMediationExpressDataAd", new Object[0]);
        if (hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(TAG, "init setAdListener", new Object[0]);
            this.hnadsd.setAdListener(new b(this, null));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getActionTips() {
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getActionType() {
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getAdFlag() {
        if (hnadsc()) {
            return this.hnadsd.getAdFlag();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getAdFlagFontSize() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getAdId() {
        return hnadsc() ? this.hnadsd.getAdId() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public AdListener getAdListener() {
        return this.hnadse;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getAdSpecTemplateType() {
        if (hnadsc()) {
            return this.hnadsd.getAdSpecTemplateType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getAdType() {
        if (hnadsc()) {
            return this.hnadsd.getAdType();
        }
        return -1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getAdUnitId() {
        return this.hnadsf;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public String getAdnId() {
        return hnadsc() ? this.hnadsd.getAdnId() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public String getAdnType() {
        return hnadsc() ? this.hnadsd.getAdnType() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getAppIntro() {
        return hnadsc() ? this.hnadsd.getAppIntro() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getAppPackage() {
        return hnadsc() ? this.hnadsd.getAppPackage() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getAppVersion() {
        return hnadsc() ? this.hnadsd.getAppVersion() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getBrand() {
        return hnadsc() ? this.hnadsd.getBrand() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getBrandFontSize() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getButtonText() {
        if (hnadsc()) {
            return this.hnadsd.getButtonText();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getChannelInfo() {
        return hnadsc() ? this.hnadsd.getChannelInfo() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getCloseFlag() {
        if (hnadsc()) {
            return this.hnadsd.getCloseFlag();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getCreativeTemplateId() {
        if (hnadsc()) {
            return this.hnadsd.getCreativeTemplateId();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getDataType() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getDeeplinkUrl() {
        return "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public DetailPageCtrl getDetailPageCtrl() {
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getDetailPageOpenMode() {
        if (hnadsc()) {
            return this.hnadsd.getDetailPageOpenMode();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getDetailType() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getDeveloperName() {
        return hnadsc() ? this.hnadsd.getDeveloperName() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getDownloadType() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getDpPackageName() {
        return hnadsc() ? this.hnadsd.getDpPackageName() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public long getEcpm() {
        if (hnadsc()) {
            return this.hnadsd.getEcpm();
        }
        return 0L;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public View getExpressAdView() {
        if (hnadsc()) {
            return this.hnadsd.getExpressAdView();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getExtraJson() {
        return hnadsc() ? this.hnadsd.getExtraJson() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getForwardInterval() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getHomePage() {
        return hnadsc() ? this.hnadsd.getHomePage() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public List<String> getImages() {
        return hnadsc() ? this.hnadsd.getImages() : new ArrayList();
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getImgHeight() {
        if (hnadsc()) {
            return this.hnadsd.getImgHeight();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getImgWidth() {
        if (hnadsc()) {
            return this.hnadsd.getImgWidth();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getImpDuration() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public List<Integer> getIncentivePoints() {
        if (hnadsc()) {
            return this.hnadsd.getIncentivePoints();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getInstallPkgType() {
        if (hnadsc()) {
            return this.hnadsd.getInstallPkgType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getInteractType() {
        if (hnadsc()) {
            return this.hnadsd.getInteractType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getIntroUrl() {
        return hnadsc() ? this.hnadsd.getIntroUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getItemPosition() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getLandingPageType() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getLandingPageUrl() {
        return hnadsc() ? this.hnadsd.getLandingPageUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public int getLevel() {
        if (hnadsc()) {
            return this.hnadsd.getLevel();
        }
        return -1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getLogo() {
        return hnadsc() ? this.hnadsd.getLogo() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getMiniProgramId() {
        return "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getMiniProgramPath() {
        return "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getMiniProgramType() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getNewLandingPageType() {
        return -1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getOrientation() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getPackageUrl() {
        return "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getPartner() {
        return "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getPermissionsUrl() {
        return hnadsc() ? this.hnadsd.getPermissionsUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getPkgSign() {
        return hnadsc() ? this.hnadsd.getPkgSign() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public long getPkgSizeBytes() {
        if (hnadsc()) {
            return this.hnadsd.getPkgSizeBytes();
        }
        return 0L;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getPkgType() {
        if (!hnadsc()) {
            return 0;
        }
        this.hnadsd.getPkgType();
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getPrivacyAgreementUrl() {
        return hnadsc() ? this.hnadsd.getHomePage() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getPromotionPurpose() {
        if (hnadsc()) {
            return this.hnadsd.getPromotionPurpose();
        }
        return -1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public float getProportion() {
        if (hnadsc()) {
            return this.hnadsd.getProportion();
        }
        return 0.0f;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getRequestId() {
        return hnadsc() ? this.hnadsd.getRequestId() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getSequence() {
        if (hnadsc()) {
            return this.hnadsd.getSequence();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public double getShakeAcc() {
        return 0.0d;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public double getShakeAngle() {
        return 0.0d;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public double getShakeDuration() {
        return 0.0d;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getSifSign() {
        return "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getSkipFontSize() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getStoreChannel() {
        return hnadsc() ? this.hnadsd.getStoreChannel() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public Style getStyle() {
        if (hnadsc()) {
            return this.hnadsd.getStyle();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getSubChannel() {
        return hnadsc() ? this.hnadsd.getSubChannel() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public int getSubType() {
        if (hnadsc()) {
            return this.hnadsd.getSubType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getTargetTips() {
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getTemplateId() {
        return hnadsc() ? this.hnadsd.getTemplateId() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getTitle() {
        return hnadsc() ? this.hnadsd.getTitle() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public TrackUrl getTrackUrl() {
        return hnadsc() ? this.hnadsd.getTrackUrl() : new TrackUrl();
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public long getTs() {
        return 0L;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public String getUnInstallFilter() {
        return hnadsc() ? this.hnadsd.getUnInstallFilter() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public long getUseTime() {
        if (hnadsc()) {
            return this.hnadsd.getUseTime();
        }
        return 0L;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public Video getVideo() {
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getWechatExtInfo() {
        return null;
    }

    public void hnadsa(int i) {
        this.hnadsi = i;
    }

    public void hnadsa(String str) {
        this.hnadsh = str;
    }

    protected com.hihonor.adsdk.base.g.j.d.c.a hnadsb() {
        return new com.hihonor.adsdk.base.g.j.d.c.a().hnadsc(this.hnadsf).hnadsm(this.hnadsg).hnadsr(getRequestId()).hnadsa(getAdId()).hnadsw(getAdnId()).hnadso(getAppPackage()).hnadsy(getUnInstallFilter()).hnadse(getAppVersion()).hnadsg(getChannelInfo()).hnadsq(String.valueOf(this.hnadsi)).hnadsd(-1).hnadsb(getAdType()).hnadsp("0").hnadsf(getPromotionPurpose()).hnadse(getPkgType()).hnadsd("0").hnadsf(AdnConfig.a.hnadsa);
    }

    public void hnadsb(String str) {
        this.hnadsg = str;
    }

    public void hnadsc(String str) {
        this.hnadsf = str;
    }

    protected boolean hnadsc() {
        return this.hnadsd != null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public boolean isCarousel() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public boolean isDownload() {
        if (hnadsc()) {
            return this.hnadsd.isDownload();
        }
        return false;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public boolean isMediaUseCustomVideo() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void release() {
        if (hnadsc()) {
            this.hnadsd.release();
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void sendLossNotification(long j, int i, String str) {
        if (hnadsc()) {
            this.hnadsd.sendLossNotification(j, i, str);
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void sendWinNotification(long j) {
        if (hnadsc()) {
            this.hnadsd.sendWinNotification(j);
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public void setAdListener(AdListener adListener) {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "setAdListener mProxyAdListener", new Object[0]);
        this.hnadse = adListener;
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setAdnId(String str) {
        if (hnadsc()) {
            this.hnadsd.setAdnId(str);
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setDislikeClickListener(DislikeItemClickListener dislikeItemClickListener) {
        if (hnadsc()) {
            this.hnadsd.setDislikeClickListener(dislikeItemClickListener);
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setItemPosition(int i) {
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setLevel(int i) {
        if (hnadsc()) {
            this.hnadsd.setLevel(i);
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setRenderType(int i) {
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void setUseTime(long j) {
        if (hnadsc()) {
            this.hnadsd.setUseTime(j);
        }
    }

    @Override // com.hihonor.adsdk.base.api.BaseExpressAd
    public void unUseAd(int i, String str) {
        if (hnadsc()) {
            this.hnadsd.unUseAd(i, str);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hnadsf);
        parcel.writeString(this.hnadsg);
        parcel.writeString(this.hnadsh);
        parcel.writeInt(this.hnadsi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hnadsa() {
        int adType = getAdType();
        if (adType == 0) {
            return NativeAd.TAG;
        }
        if (adType == 1) {
            return "BannerAd";
        }
        if (adType == 2) {
            return "PicTextAd";
        }
        if (adType == 3) {
            return "SplashAd";
        }
        if (adType != 4) {
            return adType != 5 ? "UN_KNOW_AD" : "InterstitialAd";
        }
        return "RewardVideo";
    }

    protected HnMediationExpressDataAd(Parcel parcel) {
        this.hnadsf = parcel.readString();
        this.hnadsg = parcel.readString();
        this.hnadsh = parcel.readString();
        this.hnadsi = parcel.readInt();
    }
}
