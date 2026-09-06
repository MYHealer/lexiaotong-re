package com.bytedance.sdk.openadsdk;

import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF})
public class AdSlot implements SlotType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3091a;
    private String c;
    private String da;
    private TTAdLoadType gr;
    private String gt;
    private String gu;
    private boolean i;
    private int[] m;
    private String my;
    private float n;
    private int nu;
    private String p;
    private String qy;
    private String rh;
    private String rl;
    private String sl;
    private boolean sp;
    private int t;
    private int tt;
    private int u;
    private float uj;
    private int ve;
    private boolean x;
    private int yp;
    private int yv;
    private boolean z;
    private IMediationAdSlot zm;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.AdSlot$1, reason: invalid class name */
    @c(c = {0, 80, 81, 82, MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS})
    static /* synthetic */ class AnonymousClass1 {
    }

    public int getAdCount() {
        return this.f3091a;
    }

    public String getAdId() {
        return this.gt;
    }

    public TTAdLoadType getAdLoadType() {
        return this.gr;
    }

    public int getAdType() {
        return this.u;
    }

    public int getAdloadSeq() {
        return this.nu;
    }

    public String getBidAdm() {
        return this.my;
    }

    public String getCodeId() {
        return this.c;
    }

    public String getCreativeId() {
        return this.rl;
    }

    public float getExpressViewAcceptedHeight() {
        return this.n;
    }

    public float getExpressViewAcceptedWidth() {
        return this.uj;
    }

    public String getExt() {
        return this.qy;
    }

    public int[] getExternalABVid() {
        return this.m;
    }

    public int getImgAcceptedHeight() {
        return this.ve;
    }

    public int getImgAcceptedWidth() {
        return this.tt;
    }

    public String getMediaExtra() {
        return this.da;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.zm;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.yp;
    }

    public int getOrientation() {
        return this.t;
    }

    public String getPrimeRit() {
        String str = this.rh;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.yv;
    }

    public String getRewardName() {
        return this.p;
    }

    public String getUserData() {
        return this.gu;
    }

    public String getUserID() {
        return this.sl;
    }

    public boolean isAutoPlay() {
        return this.z;
    }

    public boolean isSupportDeepLink() {
        return this.sp;
    }

    public boolean isSupportIconStyle() {
        return this.i;
    }

    public boolean isSupportRenderConrol() {
        return this.x;
    }

    public void setAdCount(int i) {
        this.f3091a = i;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.gr = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.m = iArr;
    }

    public void setNativeAdType(int i) {
        this.yp = i;
    }

    public void setUserData(String str) {
        this.gu = str;
    }

    /* synthetic */ AdSlot(AnonymousClass1 anonymousClass1) {
        this();
    }

    private AdSlot() {
        this.t = 2;
        this.z = true;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.c + "', mImgAcceptedWidth=" + this.tt + ", mImgAcceptedHeight=" + this.ve + ", mExpressViewAcceptedWidth=" + this.uj + ", mExpressViewAcceptedHeight=" + this.n + ", mAdCount=" + this.f3091a + ", mSupportDeepLink=" + this.sp + ", mSupportRenderControl=" + this.x + ", mSupportIconStyle=" + this.i + ", mMediaExtra='" + this.da + "', mUserID='" + this.sl + "', mOrientation=" + this.t + ", mNativeAdType=" + this.yp + ", mIsAutoPlay=" + this.z + ", mPrimeRit" + this.rh + ", mAdloadSeq" + this.nu + ", mAdId" + this.gt + ", mCreativeId" + this.rl + ", mExt" + this.qy + ", mUserData" + this.gu + ", mAdLoadType" + this.gr + '}';
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.c);
            jSONObject.put("mIsAutoPlay", this.z);
            jSONObject.put("mImgAcceptedWidth", this.tt);
            jSONObject.put("mImgAcceptedHeight", this.ve);
            jSONObject.put("mExpressViewAcceptedWidth", this.uj);
            jSONObject.put("mExpressViewAcceptedHeight", this.n);
            jSONObject.put("mAdCount", this.f3091a);
            jSONObject.put("mSupportDeepLink", this.sp);
            jSONObject.put("mSupportRenderControl", this.x);
            jSONObject.put("mSupportIconStyle", this.i);
            jSONObject.put("mMediaExtra", this.da);
            jSONObject.put("mUserID", this.sl);
            jSONObject.put("mOrientation", this.t);
            jSONObject.put("mNativeAdType", this.yp);
            jSONObject.put("mAdloadSeq", this.nu);
            jSONObject.put("mPrimeRit", this.rh);
            jSONObject.put("mAdId", this.gt);
            jSONObject.put("mCreativeId", this.rl);
            jSONObject.put("mExt", this.qy);
            jSONObject.put("mBidAdm", this.my);
            jSONObject.put("mUserData", this.gu);
            jSONObject.put("mAdLoadType", this.gr);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @c(c = {0, 80, 81, 82, 897})
    public static class Builder {
        private String c;
        private String gr;
        private String gt;
        private String gu;
        private int[] m;
        private String my;
        private int nu;
        private String p;
        private String qy;
        private String rh;
        private int sl;
        private int t;
        private float u;
        private String x;
        private float yp;
        private int yv;
        private IMediationAdSlot zm;
        private int tt = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int ve = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        private boolean uj = true;
        private boolean n = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f3092a = false;
        private int sp = 1;
        private String i = "defaultUser";
        private int da = 2;
        private boolean z = true;
        private TTAdLoadType rl = TTAdLoadType.UNKNOWN;

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.sp = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.qy = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.rl = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i) {
            this.t = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.nu = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.c = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.gu = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.u = f;
            this.yp = f2;
            return this;
        }

        public Builder setExt(String str) {
            this.gr = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.m = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.tt = i;
            this.ve = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.z = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.x = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.zm = iMediationAdSlot;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i) {
            this.sl = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.da = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.rh = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.yv = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.p = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.uj = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.gt = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.i = str;
            return this;
        }

        public Builder supportIconStyle() {
            this.f3092a = true;
            return this;
        }

        public Builder supportRenderControl() {
            this.n = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.my = str;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot(null);
            adSlot.c = this.c;
            adSlot.f3091a = this.sp;
            adSlot.sp = this.uj;
            adSlot.x = this.n;
            adSlot.i = this.f3092a;
            adSlot.tt = this.tt;
            adSlot.ve = this.ve;
            adSlot.uj = this.u;
            adSlot.n = this.yp;
            adSlot.da = this.x;
            adSlot.sl = this.i;
            adSlot.t = this.da;
            adSlot.yp = this.sl;
            adSlot.z = this.z;
            adSlot.m = this.m;
            adSlot.nu = this.nu;
            adSlot.rh = this.rh;
            adSlot.gt = this.qy;
            adSlot.rl = this.gu;
            adSlot.qy = this.gr;
            adSlot.u = this.t;
            adSlot.my = this.my;
            adSlot.gu = this.gt;
            adSlot.gr = this.rl;
            adSlot.p = this.p;
            adSlot.yv = this.yv;
            adSlot.zm = this.zm;
            return adSlot;
        }
    }
}
