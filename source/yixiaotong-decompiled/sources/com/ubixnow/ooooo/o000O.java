package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.adtype.splash.api.UMNSplashAd;
import com.ubixnow.adtype.splash.api.UMNSplashEyeAdHolder;
import com.ubixnow.adtype.splash.api.UMNSplashInfo;
import com.ubixnow.adtype.splash.api.UMNSplashListener;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o000O extends o00O0O0 {
    private long OooOOO = 0;
    public UMNSplashListener OooOOO0;

    public class OooO implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooO(o00O0 o00o0, oo00o oo00oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o000O o000o;
            o00O0 o00o0;
            ErrorInfo errorInfo;
            o000O.this.OooO0Oo(this.OooO00o, this.OooO0O0);
            o000O.this.OooOO0O.add(1);
            UMNSplashInfo uMNSplashInfo = new UMNSplashInfo(o000O.this.OooO00o(this.OooO0O0.getBaseAdConfig().OooO00o.OooO0o0, oO00000o.o0O0O00.OooO00o(this.OooO0O0.getBaseAdConfig().OooO00o.OooO0OO)), o000O.this.OooO00o(this.OooO0O0.material));
            if (o000O.this.OooO00o(this.OooO00o)) {
                o000o = o000O.this;
                o00o0 = this.OooO00o;
                errorInfo = new ErrorInfo(o0OO000o.o0000o0, o0OO000o.o0000o0O);
            } else {
                if (oO00000o.o00O0O.OooO00o == 0) {
                    ooooO000.OooO0O0(UMNSplashAd.TAG, "回调开发者：onAdLoadSuccess： " + this.OooO0O0.getBaseAdConfig().OooO00o.OooO + " SlotId:" + this.OooO0O0.getBaseAdConfig().OooO00o.OooO0o0 + " PlatformId:" + this.OooO0O0.getBaseAdConfig().OooO00o.OooO0OO);
                    o000O o000o2 = o000O.this;
                    if (o000o2.OooOOO0 != null) {
                        o000o2.OooO00o(this.OooO00o.OooOOo0, this.OooO0O0);
                        o000O.this.OooOOO0.onAdLoadSuccess(uMNSplashInfo);
                        return;
                    }
                    return;
                }
                o000o = o000O.this;
                o00o0 = this.OooO00o;
                errorInfo = new ErrorInfo(o0OO000o.o0000o0o, o0OO000o.o0000o);
            }
            o000o.OooO00o(o00o0, errorInfo);
        }
    }

    public class OooO00o implements Runnable {
        public final /* synthetic */ o000O00O OooO00o;
        public final /* synthetic */ o00O0 OooO0O0;

        public OooO00o(o000O00O o000o00o, o00O0 o00o0) {
            this.OooO00o = o000o00o;
            this.OooO0O0 = o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            o000O.this.OooOO0O.add(2);
            UMNSplashEyeAdHolder.platformId = this.OooO00o.getBaseAdConfig().OooO00o.OooO0OO;
            o000O o000o = o000O.this;
            if (o000o.OooOOO0 != null) {
                o000o.OooO0O0(this.OooO0O0.OooOOo0, this.OooO00o, 0);
                o000O.this.OooOOO0.onAdExposure();
            }
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ o000O00O OooO00o;
        public final /* synthetic */ boolean OooO0O0;
        public final /* synthetic */ o00O0 OooO0OO;

        public OooO0O0(o000O00O o000o00o, boolean z, o00O0 o00o0) {
            this.OooO00o = o000o00o;
            this.OooO0O0 = z;
            this.OooO0OO = o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            o000O o000o;
            oo0oO0 oo0oo0;
            o000O00O o000o00o;
            int i;
            o000O o000o2 = o000O.this;
            if (o000o2.OooOOO0 != null) {
                o000o2.OooOO0O.add(3);
                o0O0OOOo.OooO00o(this.OooO00o);
                if (this.OooO0O0) {
                    o000o = o000O.this;
                    oo0oo0 = this.OooO0OO.OooOOo0;
                    o000o00o = this.OooO00o;
                    i = 2;
                } else {
                    o000O.this.OooOOO0.onAdClicked();
                    o000o = o000O.this;
                    oo0oo0 = this.OooO0OO.OooOOo0;
                    o000o00o = this.OooO00o;
                    i = 0;
                }
                o000o.OooO00o(oo0oo0, o000o00o, i);
            }
        }
    }

    public class OooO0OO implements Runnable {
        public final /* synthetic */ long OooO00o;
        public final /* synthetic */ o000O00O OooO0O0;

        public class OooO00o implements Runnable {
            public OooO00o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ooooO000.OooO0O0(UMNSplashAd.TAG, "延迟dismiss 延迟时间：" + (ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS - OooO0OO.this.OooO00o) + " 回调开发者：onAdDismiss： " + OooO0OO.this.OooO0O0.getBaseAdConfig().OooO00o.OooO0OO + PPSLabelView.Code + OooO0OO.this.OooO0O0.hashCode());
                OooO0OO oooO0OO = OooO0OO.this;
                UMNSplashListener uMNSplashListener = o000O.this.OooOOO0;
                if (uMNSplashListener != null) {
                    uMNSplashListener.onAdDismiss(oooO0OO.OooO0O0.OooO00o);
                }
            }
        }

        public OooO0OO(long j, o000O00O o000o00o) {
            this.OooO00o = j;
            this.OooO0O0 = o000o00o;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseUtils.runInMainThread(new OooO00o());
        }
    }

    public class OooO0o implements Runnable {
        public final /* synthetic */ o000O00O OooO00o;

        public OooO0o(o000O00O o000o00o) {
            this.OooO00o = o000o00o;
        }

        @Override // java.lang.Runnable
        public void run() {
            ooooO000.OooO0O0(UMNSplashAd.TAG, "回调开发者：onAdDismiss： " + this.OooO00o.getBaseAdConfig().OooO00o.OooO0OO + PPSLabelView.Code + this.OooO00o.hashCode());
            UMNSplashListener uMNSplashListener = o000O.this.OooOOO0;
            if (uMNSplashListener != null) {
                uMNSplashListener.onAdDismiss(this.OooO00o.OooO00o);
            }
        }
    }

    public class OooOO0 implements Runnable {
        public final /* synthetic */ ErrorInfo OooO00o;
        public final /* synthetic */ o00O0 OooO0O0;

        public OooOO0(ErrorInfo errorInfo, o00O0 o00o0) {
            this.OooO00o = errorInfo;
            this.OooO0O0 = o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            ErrorInfo errorInfo = this.OooO00o;
            UMNError uMNError = new UMNError(errorInfo.code, errorInfo.msg);
            if (!TextUtils.isEmpty(this.OooO00o.platFormCode)) {
                uMNError.platFormCode = this.OooO00o.platFormCode;
            }
            if (!TextUtils.isEmpty(this.OooO00o.platFormMsg)) {
                uMNError.platFormMsg = this.OooO00o.platFormMsg;
            }
            ooooO000.OooO0O0(UMNSplashAd.TAG, "回调开发者：object:" + (this.OooO00o.object instanceof oo00o));
            o000O o000o = o000O.this;
            if (o000o.OooOOO0 != null) {
                ErrorInfo errorInfo2 = this.OooO00o;
                Object obj = errorInfo2.object;
                if (obj instanceof oo00o) {
                    o000o.OooO00o(this.OooO0O0.OooOOo0, (oo00o) obj, errorInfo2);
                } else {
                    o000o.OooO00o(this.OooO0O0.OooOOo0, (oo00o) null, errorInfo2);
                }
                o000O.this.OooOOO0.showError(uMNError);
            }
        }
    }

    public class OooOO0O implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ ErrorInfo OooO0O0;

        public OooOO0O(o00O0 o00o0, ErrorInfo errorInfo) {
            this.OooO00o = o00o0;
            this.OooO0O0 = errorInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            o000O.this.OooOO0O.add(5);
            o000O.this.OooO00o(this.OooO00o.OooOOo0, this.OooO0O0);
            ErrorInfo errorInfo = this.OooO0O0;
            UMNError uMNError = new UMNError(errorInfo.code, errorInfo.msg);
            if (!TextUtils.isEmpty(this.OooO0O0.platFormCode)) {
                uMNError.platFormCode = this.OooO0O0.platFormCode;
            }
            if (!TextUtils.isEmpty(this.OooO0O0.platFormMsg)) {
                uMNError.platFormMsg = this.OooO0O0.platFormMsg;
            }
            UMNSplashListener uMNSplashListener = o000O.this.OooOOO0;
            if (uMNSplashListener != null) {
                uMNSplashListener.onError(uMNError);
            }
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public synchronized void OooO00o(o00O0 o00o0, ErrorInfo errorInfo) {
        if (!OooO00o(5) && this.OooOOO0 != null) {
            ooooO000.OooO0O0(UMNSplashAd.TAG, "回调开发者：onError：" + errorInfo.toString());
            BaseUtils.runInMainThread(new OooOO0O(o00o0, errorInfo));
        }
    }

    public synchronized void OooO00o(o00O0 o00o0, o000O00O o000o00o) {
        if (!OooO00o(4)) {
            this.OooOO0O.add(4);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.OooOOO;
            if (jCurrentTimeMillis >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS || jCurrentTimeMillis <= 0) {
                BaseUtils.runInMainThread(new OooO0o(o000o00o));
            } else {
                BaseUtils.postDelayed(new OooO0OO(jCurrentTimeMillis, o000o00o), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS - jCurrentTimeMillis);
            }
        }
    }

    public synchronized void OooO00o(o00O0 o00o0, String str, o000O00O o000o00o) {
        try {
            boolean zOooO0O0 = OooO0O0(o000o00o);
            if ("1".equals(str)) {
                this.OooOOO = System.currentTimeMillis();
                ooooO000.OooO0O0("-------SplashExport", "----onAdClicked " + this.OooOOO);
            }
            if (OooO00o(3)) {
                if (this.OooOOO0 != null && OooO0OO(o000o00o)) {
                    this.OooOOO0.onAdClicked();
                }
                OooO00o(o00o0.OooOOo0, o000o00o, 1);
            } else if (this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooO0O0(o000o00o, zOooO0O0, o00o0));
            }
            ooooO000.OooO0O0(UMNSplashAd.TAG, "回调开发者：onAdClicked： " + o000o00o.getBaseAdConfig().OooO00o.OooO0OO);
        } catch (Exception unused) {
        }
    }

    public synchronized void OooO0O0(o00O0 o00o0, ErrorInfo errorInfo) {
        ooooO000.OooO0O0(UMNSplashAd.TAG, "回调开发者：showError:" + errorInfo.toString() + (this.OooOOO0 != null));
        if (!OooO00o(6) && this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooOO0(errorInfo, o00o0));
        }
    }

    public synchronized void OooO0O0(o00O0 o00o0, o000O00O o000o00o) {
        if (OooO00o(2)) {
            OooO0O0(o00o0.OooOOo0, o000o00o, 1);
        } else {
            if (this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooO00o(o000o00o, o00o0));
            }
            ooooO000.OooO0O0(UMNSplashAd.TAG, "回调开发者：onAdExposure： " + oO00000o.o0O0O00.OooO00o(o000o00o.getBaseAdConfig().OooO00o.OooO0OO));
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public synchronized void OooO0O0(o00O0 o00o0, oo00o oo00oVar) {
        try {
            if (!OooO00o(1) && this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooO(o00o0, oo00oVar));
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void OooO0OO(o00O0 o00o0, o000O00O o000o00o) {
        OooO00o(o00o0.OooOOo0, o000o00o, 3);
    }

    public synchronized void OooO0Oo(o00O0 o00o0, o000O00O o000o00o) {
        oOO000o.OooO00o(BaseUtils.getContext(), oO00000o.o00000O0.Oooo0 + o00o0.OooO0Oo.OooO00o.slotId, System.currentTimeMillis());
        OooO0OO(o00o0, (oo00o) o000o00o);
        OooO0O0(o00o0.OooOOo0, o000o00o, 2);
    }
}
