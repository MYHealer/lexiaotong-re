package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.adtype.banner.api.UMNBannerAd;
import com.ubixnow.adtype.banner.api.UMNBannerListener;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.bean.UMNAdInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class OooO extends o00O0O0 {
    private long OooOOO = 0;
    public UMNBannerListener OooOOO0;

    /* JADX INFO: renamed from: com.ubixnow.ooooo.OooO$OooO, reason: collision with other inner class name */
    public class RunnableC1136OooO implements Runnable {
        public final /* synthetic */ ErrorInfo OooO00o;
        public final /* synthetic */ o00O0 OooO0O0;

        public RunnableC1136OooO(ErrorInfo errorInfo, o00O0 o00o0) {
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
            ErrorInfo errorInfo2 = this.OooO00o;
            Object obj = errorInfo2.object;
            if (obj instanceof oo00o) {
                OooO.this.OooO00o(this.OooO0O0.OooOOo0, (oo00o) obj, errorInfo2);
            } else {
                OooO.this.OooO00o(this.OooO0O0.OooOOo0, (oo00o) null, errorInfo2);
            }
            OooO.this.OooOOO0.showError(uMNError);
        }
    }

    public class OooO00o implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooO00o(o00O0 o00o0, oo00o oo00oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            OooO.this.OooOO0O.add(2);
            OooO.this.OooO0O0(this.OooO00o.OooOOo0, this.OooO0O0, 0);
            OooO.this.OooOOO0.onAdExposure();
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ oo00o OooO00o;
        public final /* synthetic */ o00O0 OooO0O0;

        public OooO0O0(oo00o oo00oVar, o00O0 o00o0) {
            this.OooO00o = oo00oVar;
            this.OooO0O0 = o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            OooO.this.OooOO0O.add(3);
            o0O0OOOo.OooO00o(this.OooO00o);
            OooO.this.OooO00o(this.OooO0O0.OooOOo0, this.OooO00o, 0);
            OooO.this.OooOOO0.onAdClicked();
        }
    }

    public class OooO0OO implements Runnable {
        public OooO0OO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OooO.this.OooOO0O.add(4);
            OooO.this.OooOOO0.onAdDismiss();
        }
    }

    public class OooO0o implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooO0o(o00O0 o00o0, oo00o oo00oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            OooO oooO;
            o00O0 o00o0;
            ErrorInfo errorInfo;
            OooO.this.OooO0Oo(this.OooO00o, this.OooO0O0);
            OooO.this.OooOO0O.add(1);
            UMNAdInfo uMNAdInfo = new UMNAdInfo(OooO.this.OooO00o(this.OooO0O0.getBaseAdConfig().OooO00o.OooO0o0, oO00000o.o0O0O00.OooO00o(this.OooO0O0.getBaseAdConfig().OooO00o.OooO0OO)), OooO.this.OooO00o(this.OooO0O0.material));
            if (OooO.this.OooO00o(this.OooO00o)) {
                oooO = OooO.this;
                o00o0 = this.OooO00o;
                errorInfo = new ErrorInfo(o0OO000o.o0000o0, o0OO000o.o0000o0O);
            } else if (oO00000o.o00O0O.OooO00o == 0) {
                ooooO000.OooO0O0(UMNBannerAd.TAG, "回调开发者：onAdLoadSuccess： " + this.OooO0O0.getBaseAdConfig().OooO00o.OooO + " SlotId:" + this.OooO0O0.getBaseAdConfig().OooO00o.OooO0o0 + " PlatformId:" + oO00000o.o0O0O00.OooO00o(this.OooO0O0.getBaseAdConfig().OooO00o.OooO0OO));
                OooO.this.OooO00o(this.OooO00o.OooOOo0, this.OooO0O0);
                OooO.this.OooOOO0.onAdLoadSuccess(uMNAdInfo);
                return;
            } else {
                oooO = OooO.this;
                o00o0 = this.OooO00o;
                errorInfo = new ErrorInfo(o0OO000o.o0000o0o, o0OO000o.o0000o);
            }
            oooO.OooO00o(o00o0, errorInfo);
        }
    }

    public class OooOO0 implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ ErrorInfo OooO0O0;

        public OooOO0(o00O0 o00o0, ErrorInfo errorInfo) {
            this.OooO00o = o00o0;
            this.OooO0O0 = errorInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            OooO.this.OooOO0O.add(5);
            OooO.this.OooO00o(this.OooO00o.OooOOo0, this.OooO0O0);
            ErrorInfo errorInfo = this.OooO0O0;
            UMNError uMNError = new UMNError(errorInfo.code, errorInfo.msg);
            if (!TextUtils.isEmpty(this.OooO0O0.platFormCode)) {
                uMNError.platFormCode = this.OooO0O0.platFormCode;
            }
            if (!TextUtils.isEmpty(this.OooO0O0.platFormMsg)) {
                uMNError.platFormMsg = this.OooO0O0.platFormMsg;
            }
            OooO.this.OooOOO0.onError(uMNError);
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public synchronized void OooO00o(o00O0 o00o0, ErrorInfo errorInfo) {
        ooooO000.OooO0O0(UMNBannerAd.TAG, "回调开发者：onError：" + errorInfo.toString());
        if (!OooO00o(5) && this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooOO0(o00o0, errorInfo));
        }
    }

    public synchronized void OooO0O0(o00O0 o00o0, ErrorInfo errorInfo) {
        ooooO000.OooO0O0(UMNBannerAd.TAG, "回调开发者：showError:" + errorInfo.toString());
        if (!OooO00o(6) && this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new RunnableC1136OooO(errorInfo, o00o0));
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public synchronized void OooO0O0(o00O0 o00o0, oo00o oo00oVar) {
        try {
            if (!OooO00o(1) && this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooO0o(o00o0, oo00oVar));
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void OooO0o(o00O0 o00o0, oo00o oo00oVar) {
        try {
            ooooO000.OooO0O0(UMNBannerAd.TAG, "回调开发者：onAdDismiss： " + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO));
            if (!OooO00o(4) && this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooO0OO());
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void OooO0o0(o00O0 o00o0, oo00o oo00oVar) {
        try {
            ooooO000.OooO0O0(UMNBannerAd.TAG, "回调开发者：onAdClicked： " + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO));
            if (this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooO0O0(oo00oVar, o00o0));
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void OooO0oO(o00O0 o00o0, oo00o oo00oVar) {
        try {
            if (System.currentTimeMillis() - this.OooOOO < 29000) {
                return;
            }
            this.OooOOO = System.currentTimeMillis();
            ooooO000.OooO0O0(UMNBannerAd.TAG, "回调开发者：onAdExposure： " + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO));
            if (this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooO00o(o00o0, oo00oVar));
            }
        } catch (Exception unused) {
        }
    }
}
