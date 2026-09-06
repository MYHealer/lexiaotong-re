package com.fancy.adsdk.lib.model;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fancy._au;
import com.fancy._c7;
import com.fancy._ci;
import com.fancy._os;
import com.fancy._w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface AdSlot {

    public static class Builder {

        @Deprecated
        private ViewGroup adContainer;
        private long basePrice;
        private List<View> clickView;
        private String codeID;
        private int countdownTime;
        private List<View> creativeView;
        private String expressViewColor;
        private String mediaExtra;
        private int nativeAdType;
        private int orientation;
        private String ptgSlotID;
        private int rewardAmount;
        private String rewardName;
        private boolean selfRender;
        private int usedFor;
        private String userID;
        private int imgAcceptedWidth = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int imgAcceptedHeight = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        private float expressViewAcceptedWidth = 0.0f;
        private float expressViewAcceptedHeight = 0.0f;
        private boolean autoPlay = true;
        private boolean playMuted = true;
        public int currentReqLayer = 1;
        private PtgAdLoadType adLoadType = PtgAdLoadType.UNKNOWN;
        private boolean countdownVisibility = true;
        private int timeoutMs = 0;
        private String qubitSeq = "";
        private long qubitPhase = 0;
        private float expressViewPaddingLeft = 0.0f;
        private float expressViewPaddingTop = 0.0f;
        private float expressViewPaddingRight = 0.0f;
        private float expressViewPaddingBottom = 0.0f;

        public AdSlot build() {
            _w _wVar = new _w();
            _wVar._h = 1;
            _wVar._a = this.ptgSlotID;
            _wVar._c = this.codeID;
            _wVar._d = this.imgAcceptedWidth;
            _wVar._e = this.imgAcceptedHeight;
            _wVar._f = this.expressViewAcceptedWidth;
            _wVar._g = this.expressViewAcceptedHeight;
            _wVar._F = this.rewardName;
            _wVar._G = this.rewardAmount;
            _wVar._H = this.mediaExtra;
            _wVar._I = this.userID;
            _wVar._i = this.orientation;
            _wVar._j = this.nativeAdType;
            _wVar._k = this.autoPlay;
            _wVar._n = new WeakReference<>(this.adContainer);
            _wVar._r = this.clickView;
            _wVar._s = this.creativeView;
            _wVar._l = this.playMuted;
            _wVar._x = this.selfRender;
            _wVar._y = this.usedFor;
            _wVar._z = this.currentReqLayer;
            _wVar._A = this.basePrice;
            _wVar._B = this.adLoadType;
            _wVar._C = this.countdownVisibility;
            _wVar._D = this.countdownTime;
            _wVar._R = this.timeoutMs;
            _wVar._M = this.expressViewPaddingLeft;
            _wVar._N = this.expressViewPaddingTop;
            _wVar._O = this.expressViewPaddingRight;
            _wVar._P = this.expressViewPaddingBottom;
            _wVar._Q = this.expressViewColor;
            _wVar._S = this.qubitSeq;
            _wVar._T = this.qubitPhase;
            return _wVar;
        }

        @Deprecated
        public Builder setAdContainer(ViewGroup viewGroup) {
            this.adContainer = viewGroup;
            return this;
        }

        public Builder setAdLoadType(PtgAdLoadType ptgAdLoadType) {
            this.adLoadType = ptgAdLoadType;
            return this;
        }

        public Builder setBasePrice(long j) {
            this.basePrice = j;
            return this;
        }

        public Builder setClickView(View... viewArr) {
            this.clickView = new ArrayList();
            for (View view : viewArr) {
                this.clickView.add(view);
            }
            return this;
        }

        public Builder setCodeId(String str) {
            this.codeID = str;
            return this;
        }

        public Builder setCountdownTime(int i) {
            this.countdownTime = i;
            return this;
        }

        public Builder setCountdownVisibility(boolean z) {
            this.countdownVisibility = z;
            return this;
        }

        public Builder setCreativeView(View... viewArr) {
            this.creativeView = new ArrayList();
            for (View view : viewArr) {
                this.creativeView.add(view);
            }
            return this;
        }

        public Builder setExpressViewAcceptedDpSize(float f, float f2) {
            this.expressViewAcceptedWidth = f;
            this.expressViewAcceptedHeight = f2;
            return this;
        }

        @Deprecated
        public Builder setExpressViewAcceptedSize(float f, float f2) {
            setExpressViewAcceptedDpSize(f, f2);
            return this;
        }

        public Builder setExpressViewColor(String str) {
            this.expressViewColor = str;
            return this;
        }

        public Builder setExpressViewPadding(float f, float f2, float f3, float f4) {
            this.expressViewPaddingLeft = f;
            this.expressViewPaddingTop = f2;
            this.expressViewPaddingRight = f3;
            this.expressViewPaddingBottom = f4;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.imgAcceptedWidth = i;
            this.imgAcceptedHeight = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.autoPlay = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.mediaExtra = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.nativeAdType = i;
            return this;
        }

        @Deprecated
        public Builder setNeedSkipView(boolean z) {
            return this;
        }

        public Builder setNextLayer(int i) {
            this.currentReqLayer = i + 1;
            return this;
        }

        public Builder setOrientation(int i) {
            this.orientation = i;
            return this;
        }

        public Builder setPlayMuted(boolean z) {
            this.playMuted = z;
            return this;
        }

        public Builder setPtgSlotId(String str) {
            this.ptgSlotID = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.rewardAmount = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.rewardName = str;
            return this;
        }

        public Builder setSelfRender(boolean z) {
            this.selfRender = z;
            return this;
        }

        @Deprecated
        public Builder setSkipButtonOffsetTopDp(int i) {
            return this;
        }

        public Builder setTimeoutMs(int i) {
            this.timeoutMs = i;
            return this;
        }

        public Builder setUsedFor(int i) {
            this.usedFor = i;
            return this;
        }

        public Builder setUserID(String str) {
            this.userID = str;
            return this;
        }
    }

    @Deprecated
    ViewGroup _a();

    AdSlot _a(AdSlot adSlot);

    void _a(int i);

    void _a(long j);

    @Deprecated
    void _a(FrameLayout frameLayout);

    void _a(_c7 _c7Var);

    void _a(_ci _ciVar);

    void _a(_os _osVar);

    void _a(String str);

    AdSlot _b(_ci _ciVar);

    void _b();

    void _b(int i);

    void _b(long j);

    _au _c();

    void _c(int i);

    void _c(_ci _ciVar);

    String _d();

    void _d(int i);

    int _e();

    void _e(int i);

    boolean _f();

    long _g();

    void _h();

    _ci _i();

    int _j();

    void _k();

    String _l();

    _c7 _m();

    int _n();

    void _o();

    String _p();

    long _q();

    @Deprecated
    ViewGroup _s();

    _os _t();

    int _u();

    int _v();

    int _w();

    boolean _x();

    int getAdCount();

    PtgAdLoadType getAdLoadType();

    long getBasePrice();

    List<View> getClickView();

    String getCodeId();

    long getCountdownTime();

    List<View> getCreativeView();

    float getExpressViewAcceptedHeight();

    float getExpressViewAcceptedWidth();

    String getExpressViewColor();

    float getExpressViewPaddingBottom();

    float getExpressViewPaddingLeft();

    float getExpressViewPaddingRight();

    float getExpressViewPaddingTop();

    int getImgAcceptedHeight();

    int getImgAcceptedWidth();

    String getMediaExtra();

    String getPtgSlotID();

    int getRewardAmount();

    String getRewardName();

    int getTimeoutMs();

    String getUserID();

    boolean isAutoPlay();

    boolean isCountdownVisibility();

    boolean isPlayMuted();

    boolean isSelfRender();

    void setAdCount(int i);

    void setAdLoadType(PtgAdLoadType ptgAdLoadType);

    void setBasePrice(long j);

    void setCodeID(String str);

    void setCountdownTime(long j);

    void setCountdownVisibility(boolean z);

    void setExpressViewColor(String str);

    void setTimeoutMs(int i);

    void withBid(String str);
}
